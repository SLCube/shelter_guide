package com.slcube.shelter_guide.batch.external_api.service;


import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeolla_nam_do.JeollaNamDoShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeolla_nam_do.JeollaNamDoShelterInformationResultDataDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class JeollaNamDoShelterInformationApiServiceUnitTest {

    @InjectMocks
    private JeollaNamDoShelterInformationApiService jeollaNamDoShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    private final int EXPECTED_LIST_SIZE = 5;

    @BeforeEach
    void setUp() {
        String externalUrl = "https://api.odcloud.kr/api/15105960/v1/uddi:4f444fb5-f5e1-46c8-82c9-f752e0af1208" +
                "?page={pageIndex}" +
                "&perPage={pageSize}" +
                "&serviceKey={apiKey}";
        String apiKey = "testApiKey";

        setField(jeollaNamDoShelterInformationApiService, "externalUrl", externalUrl);
        setField(jeollaNamDoShelterInformationApiService, "apiKey", apiKey);
    }

    @Test
    void 전라남도_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<JeollaNamDoShelterInformationDto>>any()))
                .thenReturn(createShelterInformationDto());

        List<ShelterInformationDto> shelterInformation = jeollaNamDoShelterInformationApiService.fetchShelterInformation(1, EXPECTED_LIST_SIZE);

        assertThat(shelterInformation).hasSize(EXPECTED_LIST_SIZE);
    }

    private JeollaNamDoShelterInformationDto createShelterInformationDto() {

        JeollaNamDoShelterInformationDto shelterInformation = new JeollaNamDoShelterInformationDto();
        List<JeollaNamDoShelterInformationResultDataDto> shelterInformationResultDataDtoList = new ArrayList<>();
        for (int i = 0; i < EXPECTED_LIST_SIZE; i++) {
            JeollaNamDoShelterInformationResultDataDto shelterInformationResultDataDto = new JeollaNamDoShelterInformationResultDataDto();
            setField(shelterInformationResultDataDto, "businessEstablishmentName", "테스트 대피소 이름");
            setField(shelterInformationResultDataDto, "roadNameAddress", "전라남도 여수시");
            setField(shelterInformationResultDataDto, "locationArea", 1000);

            shelterInformationResultDataDtoList.add(shelterInformationResultDataDto);
        }

        setField(shelterInformation, "resultDataDtoList", shelterInformationResultDataDtoList);

        return shelterInformation;
    }
}