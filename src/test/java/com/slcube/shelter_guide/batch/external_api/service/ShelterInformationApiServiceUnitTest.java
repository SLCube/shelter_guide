package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultCodeDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationApiServiceUnitTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SeoulShelterInformationApiService seoulShelterInformationApiService;

    private final int EXPECTED_LIST_SIZE = 3;

    @BeforeEach
    public void setUp() {
        setField(seoulShelterInformationApiService, "externalUrl", "http://openapi.seoul.go.kr:8088/{apiKey}/json/LOCALDATA_114602");
        setField(seoulShelterInformationApiService, "apiKey", "unit-test-api-key");
    }

    @Test
    void 서울시_공공_api에서_대피소_정보를_갖고오는_메소드_테스트() {

        SeoulShelterInformationDto seoulShelterInformationDto = createShelterInformationDto();

        when(restTemplate.getForObject(anyString(), Mockito.<Class<SeoulShelterInformationDto>>any()))
                .thenReturn(seoulShelterInformationDto);

        int startIndex = 1;
        int endIndex = 100;

        List<ShelterInformationDto> resultDataDtoList = seoulShelterInformationApiService.fetchShelterInformation(startIndex, endIndex);
        assertThat(resultDataDtoList).hasSize(EXPECTED_LIST_SIZE);
    }

    private SeoulShelterInformationDto createShelterInformationDto() {
        SeoulShelterInformationDto seoulShelterInformationDto = new SeoulShelterInformationDto();

        SeoulShelterInformationResultDto resultDto = new SeoulShelterInformationResultDto();
        setField(resultDto, "listTotalCount", 6020);

        SeoulShelterInformationResultCodeDto codeDto = new SeoulShelterInformationResultCodeDto();
        setField(codeDto, "resultCode", "INFO-000");
        setField(codeDto, "message", "정상 처리되었습니다.");

        setField(resultDto, "resultCodeDto", codeDto);

        List<SeoulShelterInformationResultDataDto> shelterInformationDataList = createShelterInformationDataList();
        setField(resultDto, "resultDataDtoList", shelterInformationDataList);

        setField(seoulShelterInformationDto, "result", resultDto);


        return seoulShelterInformationDto;
    }

    private List<SeoulShelterInformationResultDataDto> createShelterInformationDataList() {
        List<SeoulShelterInformationResultDataDto> shelterInformationDataList = new ArrayList<>();

        for (int i = 0; i < EXPECTED_LIST_SIZE; i++) {
            SeoulShelterInformationResultDataDto shelterInformationResultDataDto = new SeoulShelterInformationResultDataDto();
            setField(shelterInformationResultDataDto, "municipalityCode", "3120000");
            setField(shelterInformationResultDataDto, "managementNumber", "3120000-S202300001");
            setField(shelterInformationResultDataDto, "licenseDate", "2008-12-02");
            setField(shelterInformationResultDataDto, "businessStatusCode", "01");
            setField(shelterInformationResultDataDto, "businessStatusName", "영업/정상");
            setField(shelterInformationResultDataDto, "detailedBusinessStatusCode", "18");
            setField(shelterInformationResultDataDto, "detailedBusinessStatusName", "사용중");
            setField(shelterInformationResultDataDto, "locationArea", 1369.8);
            setField(shelterInformationResultDataDto, "landNumberAddress", "서울특별시 서대문구 홍제동 453 무악청구아파트");
            setField(shelterInformationResultDataDto, "roadNameAddress", "서울특별시 서대문구 통일로 348 (홍제동, 무악청구아파트)");
            setField(shelterInformationResultDataDto, "roadNamePostalCode", "03635");
            setField(shelterInformationResultDataDto, "businessEstablishmentName", "무악청구1차아파트 제1주차장 지하1~2층");
            setField(shelterInformationResultDataDto, "lastModifiedDate", "2023-06-29 13:44:38");
            setField(shelterInformationResultDataDto, "dataUpdateCode", "U");
            setField(shelterInformationResultDataDto, "dataUpdateDate", "2022-12-07 00:01:00.0");
            setField(shelterInformationResultDataDto, "positionX", 195694.979414141);
            setField(shelterInformationResultDataDto, "positionY", 453291.683935348);

            shelterInformationDataList.add(shelterInformationResultDataDto);
        }

        return shelterInformationDataList;
    }
}
