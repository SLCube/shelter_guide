package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
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

@ExtendWith(MockitoExtension.class)
class ShelterInformationDataTransferItemProcessorUnitTest {

    @Mock
    private ShelterInformationRepository shelterInformationRepository;

    @InjectMocks
    private ShelterInformationDataTransferItemProcessor shelterInformationDataTransferItemProcessor;

    @Test
    void 기존_데이터가_없을때_processor_테스트() throws Exception {
        when(shelterInformationRepository.findByBusinessEstablishmentNameIn(anyList()))
                .thenReturn(Collections.emptyList());

        List<ShelterInformationStaging> shelterInformationStagings = createShelterInformationStagings();
        List<ShelterInformationStaging> originalShelterInformationStagings = new ArrayList<>(shelterInformationStagings);

        List<ShelterInformationStaging> result = shelterInformationDataTransferItemProcessor.process(shelterInformationStagings);

        assertThat(result).isEqualTo(originalShelterInformationStagings);
    }

    @Test
    void 수정이_필요한_데이터가_있을때_테스트() throws Exception {
        String managementNumber = "0";

        when(shelterInformationRepository.findByBusinessEstablishmentNameIn(anyList()))
                .thenReturn(List.of(createShelterInformation(),
                        ShelterInformation.builder().build(),
                        ShelterInformation.builder().build()));

        List<ShelterInformationStaging> shelterInformationStagings = createShelterInformationStagings();
        List<ShelterInformationStaging> result = shelterInformationDataTransferItemProcessor.process(shelterInformationStagings);

        assertThat(result).hasSize(2);
    }

    private List<ShelterInformationStaging> createShelterInformationStagings() {
        List<ShelterInformationStaging> shelterInformationStagings = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ShelterInformationStaging shelterInformationStaging = ShelterInformationStaging.builder()
                    .businessStatusCode("01")
                    .businessStatusName("영업/정상")
                    .locationArea(15666.0)
                    .roadNamePostalCode("")
                    .landNumberAddress("서울특별시 구로구 고척동 342 벽산베스트블루밍아파트")
                    .locationPostalCode("08228")
                    .businessEstablishmentName("벽산블루밍아파트" + i)
                    .roadNameAddress("서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)")
                    .roadNamePostalCode("")
                    .build();

            shelterInformationStagings.add(shelterInformationStaging);
        }

        return shelterInformationStagings;
    }

    private ShelterInformation createShelterInformation() {
        return ShelterInformation.builder()
                .businessStatusCode("01")
                .businessStatusName("영업/정상")
                .closingDate("")
                .locationArea(15666.0)
                .landNumberAddress("서울특별시 구로구 고척동 342 벽산베스트블루밍아파트")
                .locationPostalCode("08228")
                .businessEstablishmentName("벽산블루밍아파트" + 0)
                .roadNameAddress("서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)")
                .roadNamePostalCode("")
                .build();
    }
}