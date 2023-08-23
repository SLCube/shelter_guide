package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
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
            setField(shelterInformationDataDto, "roadNamePostalCode", "08228");
            shelterInformationResultDataDtoList.add(shelterInformationDataDto);
        }

        return shelterInformationResultDataDtoList;
    }
}
