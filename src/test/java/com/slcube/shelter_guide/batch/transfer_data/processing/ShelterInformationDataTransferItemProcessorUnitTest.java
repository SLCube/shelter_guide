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
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShelterInformationDataTransferItemProcessorUnitTest {

    @Mock
    private ShelterInformationRepository shelterInformationRepository;

    @InjectMocks
    private ShelterInformationDataTransferItemProcessor shelterInformationDataTransferItemProcessor;

    @Test
    void 기존_데이터가_없을때_processor_테스트() throws Exception {
        when(shelterInformationRepository.findByBusinessEstablishmentName(anyString()))
                .thenReturn(Optional.empty());

        List<ShelterInformationStaging> shelterInformationStagings = createShelterInformationStagings();
        List<ShelterInformationStaging> originalShelterInformationStagings = new ArrayList<>(shelterInformationStagings);

        shelterInformationDataTransferItemProcessor.process(shelterInformationStagings);

        assertThat(shelterInformationStagings).isEqualTo(originalShelterInformationStagings);
    }

    @Test
    void 수정이_필요한_데이터가_있을때_테스트() throws Exception {
        String managementNumber = "0";

        when(shelterInformationRepository.findByBusinessEstablishmentName(managementNumber))
                .thenReturn(Optional.of(createShelterInformation()));
        List<ShelterInformationStaging> shelterInformationStagings = createShelterInformationStagings();
        shelterInformationDataTransferItemProcessor.process(shelterInformationStagings);

        assertThat(shelterInformationStagings).hasSize(2);
    }

    private List<ShelterInformationStaging> createShelterInformationStagings() {
        List<ShelterInformationStaging> shelterInformationStagings = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ShelterInformationStaging shelterInformationStaging = ShelterInformationStaging.builder()
                    .managementNumber(String.valueOf(i))
                    .licenseDate("2023-07-13")
                    .businessStatusCode("01")
                    .businessStatusName("영업/정상")
                    .detailedBusinessStatusCode("18")
                    .detailedBusinessStatusName("사용중")
                    .positionX(187473.221837261)
                    .positionY(444729.961384482)
                    .locationArea(15666.0)
                    .closingDate("")
                    .roadNamePostalCode("")
                    .landNumberAddress("서울특별시 구로구 고척동 342 벽산베스트블루밍아파트")
                    .locationPostalCode("08228")
                    .roadNameAddress("서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)")
                    .lastModifiedDate("2023-07-24 15:53:31")
                    .build();

            shelterInformationStagings.add(shelterInformationStaging);
        }

        return shelterInformationStagings;
    }

    private ShelterInformation createShelterInformation() {
        ShelterInformation shelterInformation = ShelterInformation.builder()
                .managementNumber("3160000-S202300004")
                .licenseDate("2023-07-13")
                .businessStatusCode("01")
                .businessStatusName("영업/정상")
                .detailedBusinessStatusCode("18")
                .detailedBusinessStatusName("사용중")
                .positionX(187473.221837261)
                .positionY(444729.961384482)
                .locationArea(15666.0)
                .landNumberAddress("서울특별시 구로구 고척동 342 벽산베스트블루밍아파트")
                .locationPostalCode("08228")
                .roadNameAddress("서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)")
                .lastModifiedDate("2023-07-24 15:53:31")
                .build();
        return shelterInformation;
    }
}