package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.daejeon.DaeJeonShelterInformationDto;
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
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class DaeJeonShelterInformationApiServiceUnitTest {

    @InjectMocks
    private DaeJeonShelterInformationApiService daeJeonShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        setField(daeJeonShelterInformationApiService, "externalUrl", "https://api.odcloud.kr/api/15065249/v1/uddi:0ea884c0-0e90-4c1c-be4c-e04ded0966f3?page={pageIndex}&perPage={pageSize}&serviceKey={apiKey}");
        setField(daeJeonShelterInformationApiService, "apiKey", "testApiKey");
    }

    @Test
    void 대전광역시_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<DaeJeonShelterInformationDto>>any()))
                .thenReturn(new DaeJeonShelterInformationDto());

        List<ShelterInformationDto> shelterInformation = daeJeonShelterInformationApiService.fetchShelterInformation(1, 5);

        assertThat(shelterInformation).isEmpty();
    }
}