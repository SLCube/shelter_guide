package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeolla_buk_do.JeollaBukDoShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeolla_buk_do.JeollaBukDoShelterInformationResultDataDto;
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
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class JeollaBukDoShelterInformationApiServiceUnitTest {

    @InjectMocks
    private JeollaBukDoShelterInformationApiService jeollaBukDoShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    private final int EXPECTED_LIST_SIZE = 5;

    @BeforeEach
    void setUp() {
        String externalUrl = "https://api.odcloud.kr/api/15055712/v1/uddi:2047b907-2c87-4177-8411-fb0e71043d2f_201708171411?" +
                "page={pageIndex}" +
                "&perPage={pageSize}" +
                "&serviceKey={apiKey}";
        String apiKey = "testApiKey";

        setField(jeollaBukDoShelterInformationApiService, "externalUrl", externalUrl);
        setField(jeollaBukDoShelterInformationApiService, "apiKey", apiKey);
    }

    @Test
    void 전라북도_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<JeollaBukDoShelterInformationDto>>any()))
                .thenReturn(createShelterInformation());

        List<ShelterInformationDto> shelterInformation = jeollaBukDoShelterInformationApiService.fetchShelterInformation(1, EXPECTED_LIST_SIZE);

        assertThat(shelterInformation).hasSize(EXPECTED_LIST_SIZE);
    }

    private JeollaBukDoShelterInformationDto createShelterInformation() {
        JeollaBukDoShelterInformationDto shelterInformationDto = new JeollaBukDoShelterInformationDto();
        List<JeollaBukDoShelterInformationResultDataDto> shelterInformationResultDataDtoList = new ArrayList<>();

        for (int i = 0; i < EXPECTED_LIST_SIZE; i++) {
            JeollaBukDoShelterInformationResultDataDto shelterInformationResultDataDto = new JeollaBukDoShelterInformationResultDataDto();

            setField(shelterInformationResultDataDto, "businessEstablishmentName", "테스트 대피소이름");
            setField(shelterInformationResultDataDto, "roadNameAddress", "전라북도 전주시 테스트 도로명주소");
            setField(shelterInformationResultDataDto, "landNumberAddress", "전라북도 전주시 테스트 지번주소");
            setField(shelterInformationResultDataDto, "locationArea", 1000);

            shelterInformationResultDataDtoList.add(shelterInformationResultDataDto);
        }

        setField(shelterInformationDto, "resultDtoList", shelterInformationResultDataDtoList);

        return shelterInformationDto;
    }
}