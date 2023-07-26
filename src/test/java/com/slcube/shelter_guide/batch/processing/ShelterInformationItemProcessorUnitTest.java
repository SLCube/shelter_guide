package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.processing.ShelterInformationItemProcessor;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationItemProcessorUnitTest {

    @Mock
    private ShelterInformationApiService shelterInformationApiService;

    @InjectMocks
    private ShelterInformationItemProcessor shelterInformationItemProcessor;

    @Test
    void 테이블에_데이터가_없을_때의_프로세스_테스트() throws Exception {

        when(shelterInformationApiService.findByManagementNumber(any()))
                .thenReturn(Optional.empty());

        List<SeoulShelterInformationResultDataDto> shelterInformationList = createShelterInformationList();
        List<SeoulShelterInformationResultDataDto> originalShelterInformationList = new ArrayList<>(shelterInformationList);

        shelterInformationItemProcessor.process(shelterInformationList);

        assertThat(shelterInformationList).isEqualTo(originalShelterInformationList);
    }

    @Test
    void 테이블에_수정해야될_데이터가_존재할_때의_프로세스_테스트() throws Exception {
        String managementNumber = "0";

        when(shelterInformationApiService.findByManagementNumber(managementNumber))
                .thenReturn(Optional.of(ShelterInformationStaging.builder().build()));

        List<SeoulShelterInformationResultDataDto> shelterInformationList = createShelterInformationList();

        shelterInformationItemProcessor.process(shelterInformationList);

        int expectedListSize = 2;

        assertThat(shelterInformationList).hasSize(expectedListSize);
    }

    private List<SeoulShelterInformationResultDataDto> createShelterInformationList() {
        List<SeoulShelterInformationResultDataDto> shelterInformationResultDataDtoList
                = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            SeoulShelterInformationResultDataDto shelterInformationDataDto = new SeoulShelterInformationResultDataDto();
            setField(shelterInformationDataDto, "managementNumber", i + "");
            shelterInformationResultDataDtoList.add(shelterInformationDataDto);
        }

        return shelterInformationResultDataDtoList;
    }
}
