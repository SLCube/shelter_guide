package com.slcube.shelter_guide.batch.external_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class GyeongSangNamDoShelterInformationApiServiceUnitTest {

    @InjectMocks
    private GyeongSangNamDoShelterInformationApiService gyeongSangNamDoShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    @Spy
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        setField(gyeongSangNamDoShelterInformationApiService, "externalUrl", "https://apis.data.go.kr/6480000/gyeongnamdisasterfacility/gyeongnamdisasterfacilitylist?pageNo={pageIndex}&numOfRows={pageSize}&resultType=json&serviceKey={apiKey}");
        setField(gyeongSangNamDoShelterInformationApiService, "apiKey", "testKey");
    }

    @Test
    void 경상남도_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {

        String resultJsonString = "{\"gyeongnamdisasterfacilitylist\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL_CODE\"},\"body\":{\"items\":{\"item\":[{\"DATA_IDX\":1,\"DATA_TITLE\":\"동읍사무소\",\"USER_ADDRESS\":\"창원시 의창구 동읍 용잠리 575 동읍사무소\"},{\"DATA_IDX\":2,\"DATA_TITLE\":\"신안아파트\",\"USER_ADDRESS\":\"창원시 의창구 동읍 용잠리 419 신안아파트\"},{\"DATA_IDX\":1,\"DATA_TITLE\":\"동읍사무소\",\"USER_ADDRESS\":\"창원시 의창구 동읍 용잠리 575 동읍사무소\"},{\"DATA_IDX\":2,\"DATA_TITLE\":\"신안아파트\",\"USER_ADDRESS\":\"창원시 의창구 동읍 용잠리 419 신안아파트\"},{\"DATA_IDX\":3,\"DATA_TITLE\":\"평화맨션\",\"USER_ADDRESS\":\"창원시 의창구 동읍 용잠리 357-1 평화맨션\"}]},\"numOfRows\":5,\"pageNo\":1,\"totalCount\":1562}}}";

        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<String>>any()))
                .thenReturn(resultJsonString);

        List<ShelterInformationDto> shelterInformation = gyeongSangNamDoShelterInformationApiService.fetchShelterInformation(1, 5);

        assertThat(shelterInformation).hasSize(5);
    }
}