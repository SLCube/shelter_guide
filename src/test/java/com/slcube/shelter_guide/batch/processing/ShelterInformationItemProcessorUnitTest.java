package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
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

    private List<SeoulShelterInformationResultDataDto> createShelterInformationList() {
        List<SeoulShelterInformationResultDataDto> shelterInformationResultDataDtoList
                = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            shelterInformationResultDataDtoList.add(new SeoulShelterInformationResultDataDto());
        }

        return shelterInformationResultDataDtoList;
    }
}
