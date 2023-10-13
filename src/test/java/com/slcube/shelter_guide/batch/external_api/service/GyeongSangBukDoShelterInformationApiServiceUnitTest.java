package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_buk_do.GyeongSangBukDoShelterInformationDto;
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
class GyeongSangBukDoShelterInformationApiServiceUnitTest {

    @InjectMocks
    private GyeongSangBukDoShelterInformationApiService gyeongSangBukDoShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        setField(gyeongSangBukDoShelterInformationApiService, "externalUrl", "https://api.odcloud.kr/api/3083902/v1/uddi:466f096f-f495-4917-b541-93f1037b82c1_201808191154?page={pageIndex}&perPage={pageSize}&serviceKey={apiKey}");
        setField(gyeongSangBukDoShelterInformationApiService, "apiKey", "testApiKey");
    }

    @Test
    void 경상북도_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<GyeongSangBukDoShelterInformationDto>>any()))
                .thenReturn(new GyeongSangBukDoShelterInformationDto());

        List<ShelterInformationDto> shelterInformation = gyeongSangBukDoShelterInformationApiService.fetchShelterInformation(1, 5);

        assertThat(shelterInformation).isEmpty();
    }
}