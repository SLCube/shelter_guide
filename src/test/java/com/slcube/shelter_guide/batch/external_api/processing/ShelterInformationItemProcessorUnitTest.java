package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationItemProcessorUnitTest {

    @Mock
    private ShelterInformationStagingRepository shelterInformationStagingRepository;

    @InjectMocks
    private ShelterInformationItemProcessor shelterInformationItemProcessor;

    @Test
    void 테이블에_데이터가_없을_때의_프로세스_테스트() throws Exception {

        when(shelterInformationStagingRepository.findByBusinessEstablishmentNameIn(anyList()))
                .thenReturn(Collections.emptyList());

        List<ShelterInformationDto> shelterInformationList = createShelterInformationList();
        List<ShelterInformationDto> originalShelterInformationList = new ArrayList<>(shelterInformationList);

        List<ShelterInformationDto> result = shelterInformationItemProcessor.process(shelterInformationList);

        assertThat(result).isEqualTo(originalShelterInformationList);
    }

    @Test
    void 테이블에_수정해야될_데이터가_존재할_때의_프로세스_테스트() throws Exception {

        List<ShelterInformationDto> shelterInformationList = createShelterInformationList();

        when(shelterInformationStagingRepository.findByBusinessEstablishmentNameIn(anyList()))
                .thenReturn(
                        List.of(createShelterInformationStaging(),
                                ShelterInformationStaging.builder().build(),
                                ShelterInformationStaging.builder().build()
                        ));

//        when(shelterInformationStagingRepository.findByBusinessEstablishmentName(anyString()))
//                .thenReturn(Optional.of(ShelterInformationStaging.builder().build()));

        List<ShelterInformationDto> result = shelterInformationItemProcessor.process(shelterInformationList);

        int expectedListSize = 2;

        assertThat(result).hasSize(expectedListSize);
    }

    private List<ShelterInformationDto> createShelterInformationList() {
        List<ShelterInformationDto> shelterInformationResultDataDtoList
                = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ShelterInformationDto shelterInformationDataDto = new ShelterInformationDto();
            setField(shelterInformationDataDto, "managementNumber", String.valueOf(i));
            setField(shelterInformationDataDto, "licenseDate", "2023-07-13");
            setField(shelterInformationDataDto, "businessStatusCode", "01");
            setField(shelterInformationDataDto, "businessStatusName", "영업/정상");
            setField(shelterInformationDataDto, "detailedBusinessStatusCode", "18");
            setField(shelterInformationDataDto, "detailedBusinessStatusName", "사용중");
            setField(shelterInformationDataDto, "positionX", 187473.221837261);
            setField(shelterInformationDataDto, "positionY", 444729.961384482);
            setField(shelterInformationDataDto, "locationArea", 15666);
            setField(shelterInformationDataDto, "landNumberAddress", "서울특별시 구로구 고척동 342 벽산베스트블루밍아파트");
            setField(shelterInformationDataDto, "roadNameAddress", "서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)");
            setField(shelterInformationDataDto, "businessEstablishmentName", "벽산블루밍아파트" + i);
            setField(shelterInformationDataDto, "roadNamePostalCode", "08228");
            shelterInformationResultDataDtoList.add(shelterInformationDataDto);
        }

        return shelterInformationResultDataDtoList;
    }

    private ShelterInformationStaging createShelterInformationStaging() {
        return ShelterInformationStaging.builder()
                .managementNumber(String.valueOf(0))
                .licenseDate("2023-07-13")
                .businessStatusCode("01")
                .businessStatusName("영업/정상")
                .detailedBusinessStatusCode("18")
                .detailedBusinessStatusName("사용중")
                .positionX(187473.221837261)
                .positionY(444729.961384482)
                .locationArea(15666)
                .landNumberAddress("서울특별시 구로구 고척동 342 벽산베스트블루밍아파트")
                .roadNameAddress("서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)")
                .businessEstablishmentName("벽산블루밍아파트" + 0)
                .roadNamePostalCode("08228")
                .build();

    }
}
