package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.chung_cheong_buk_do.ChungCheongBukDoShelterInformationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.*;

@ExtendWith(MockitoExtension.class)
class ChungCheongBukDoShelterInformationApiServiceUnitTest {

    @InjectMocks
    private ChungCheongBukDoShelterInformationApiService chungCheongBukDoShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        setField(chungCheongBukDoShelterInformationApiService, "externalUrl", "http://apis.data.go.kr/6430000/emdAreaAcctoMsfrtncntrmsrzoneDataService/getemdAreaAcctoMsfrtncntrmsrzoneData?currentPage={pageIndex}&perPage={pageSize}&serviceKey={apiKey}");
        setField(chungCheongBukDoShelterInformationApiService, "apiKey", "testApiKey");
    }

    @Test
    void 충청북도_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<ChungCheongBukDoShelterInformationDto>>any()))
                .thenReturn(new ChungCheongBukDoShelterInformationDto());

        List<ShelterInformationDto> shelterInformation = chungCheongBukDoShelterInformationApiService.fetchShelterInformation(1, 5);

        assertThat(shelterInformation).isEmpty();
    }
}