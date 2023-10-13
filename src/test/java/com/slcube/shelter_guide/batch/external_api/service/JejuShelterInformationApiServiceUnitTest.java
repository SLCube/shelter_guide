package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeju.JejuShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeju.JejuShelterInformationResultDataDto;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.*;

@ExtendWith(MockitoExtension.class)
class JejuShelterInformationApiServiceUnitTest {

    @InjectMocks
    private JejuShelterInformationApiService jejuShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    private final int EXPECTED_LIST_SIZE = 5;

    @BeforeEach
    void setUp() {
        setField(jejuShelterInformationApiService, "externalUrl", "https://api.odcloud.kr/api/15056026/v1/uddi:1ee934ce-5400-4d70-a05f-8380cbe616fe_201706281055?page={pageIndex}&perPage={pageSize}&serviceKey={apiKey}");
        setField(jejuShelterInformationApiService, "apiKey", "testApiKey");
    }

    @Test
    void 제주도_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<JejuShelterInformationDto>>any()))
                .thenReturn(createShelterInformation());

        List<ShelterInformationDto> shelterInformation = jejuShelterInformationApiService.fetchShelterInformation(1, EXPECTED_LIST_SIZE);

        assertThat(shelterInformation).hasSize(EXPECTED_LIST_SIZE);
    }

    private JejuShelterInformationDto createShelterInformation() {
        JejuShelterInformationDto shelterInformationDto = new JejuShelterInformationDto();
        List<JejuShelterInformationResultDataDto> shelterInformationResultDataDtoList = new ArrayList<>();

        for (int i = 0; i < EXPECTED_LIST_SIZE; i++) {
            JejuShelterInformationResultDataDto shelterInformationResultDataDto = new JejuShelterInformationResultDataDto();

            setField(shelterInformationResultDataDto, "businessEstablishmentName", "테스트 대피소이름");
            setField(shelterInformationResultDataDto, "roadNameAddress", "제주특별자치도 테스트 도로명 주소");
            setField(shelterInformationResultDataDto, "locationArea", 1000);

            shelterInformationResultDataDtoList.add(shelterInformationResultDataDto);
        }

        setField(shelterInformationDto, "resultDataDtoList", shelterInformationResultDataDtoList);
        return shelterInformationDto;
    }
}