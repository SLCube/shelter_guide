package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.gwang_ju.GwangJuShelterInformationDto;
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
class GwangJuShelterInformationApiServiceUnitTest {

    @InjectMocks
    private GwangJuShelterInformationApiService gwangJuShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        setField(gwangJuShelterInformationApiService, "externalUrl", "https://api.odcloud.kr/api/15059989/v1/uddi:3d348c76-ac6b-4934-827f-9d4d7525112a?page={pageIndex}&perPage={pageSize}&serviceKey={apiKey}");
        setField(gwangJuShelterInformationApiService, "apiKey", "testApiKey");
    }

    @Test
    void 광주광역시_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<GwangJuShelterInformationDto>>any()))
                .thenReturn(new GwangJuShelterInformationDto());

        List<ShelterInformationDto> shelterInformation = gwangJuShelterInformationApiService.fetchShelterInformation(1, 5);

        assertThat(shelterInformation).isEmpty();
    }
}