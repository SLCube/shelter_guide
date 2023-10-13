package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.in_cheon.InCheonShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.in_cheon.InCheonShelterInformationResultDataDto;
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
class InCheonShelterInformationApiServiceUnitTest {

    @InjectMocks
    private InCheonShelterInformationApiService inCheonShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    private final int EXPECTED_LIST_SIZE = 5;

    @BeforeEach
    void setUp() {
        setField(inCheonShelterInformationApiService, "externalUrl", "https://api.odcloud.kr/api/15105989/v1/uddi:01f00634-00bc-4943-be02-f59bf84871ea?page={pageIndex}&perPage={pageSize}&serviceKey={apiKey}");
        setField(inCheonShelterInformationApiService, "apiKey", "testApiKey");
    }

    @Test
    void 인천_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {
        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<InCheonShelterInformationDto>>any()))
                .thenReturn(createShelterInformation());

        List<ShelterInformationDto> shelterInformation = inCheonShelterInformationApiService.fetchShelterInformation(1, EXPECTED_LIST_SIZE);

        assertThat(shelterInformation).hasSize(EXPECTED_LIST_SIZE);
    }

    private InCheonShelterInformationDto createShelterInformation() {
        InCheonShelterInformationDto shelterInformationDto = new InCheonShelterInformationDto();
        List<InCheonShelterInformationResultDataDto> shelterInformationResultDataDtoList = new ArrayList<>();

        for (int i = 0; i < EXPECTED_LIST_SIZE; i++) {
            InCheonShelterInformationResultDataDto shelterInformationResultDataDto = new InCheonShelterInformationResultDataDto();
            shelterInformationResultDataDtoList.add(shelterInformationResultDataDto);
        }

        setField(shelterInformationDto, "resultDataDtoList", shelterInformationResultDataDtoList);

        return shelterInformationDto;
    }
}