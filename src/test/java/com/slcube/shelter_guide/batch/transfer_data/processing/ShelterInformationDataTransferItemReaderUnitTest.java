package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShelterInformationDataTransferItemReaderUnitTest {

    @Mock
    private ShelterInformationStagingRepository shelterInformationStagingRepository;

    @InjectMocks
    private ShelterInformationDataTransferItemReader shelterInformationDataTransferItemReader;

    @Test
    void 저장용_테이블에_더이상_갖고올_데이터가_없을때_reader_테스트() throws Exception {
        List<ShelterInformationStaging> shelterInformationStagings = new ArrayList<>();

        when(shelterInformationStagingRepository.findAllWithPaging(any()))
                .thenReturn(shelterInformationStagings);

        assertThat(shelterInformationDataTransferItemReader.read()).isNull();
    }

    @Test
    void 저장용_테이블에서_데이터를_갖고오는_reader_테스트() throws Exception {

        List<ShelterInformationStaging> shelterInformationStagings = createShelterInformationStagings();

        when(shelterInformationStagingRepository.findAllWithPaging(any()))
                .thenReturn(shelterInformationStagings);

        assertThat(shelterInformationDataTransferItemReader.read()).isEqualTo(shelterInformationStagings);
    }

    private List<ShelterInformationStaging> createShelterInformationStagings() {
        List<ShelterInformationStaging> shelterInformationStagings = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ShelterInformationStaging shelterInformationStaging = ShelterInformationStaging.builder()
                    .businessStatusCode("01")
                    .businessStatusName("영업/정상")
                    .locationArea(15666.0)
                    .landNumberAddress("서울특별시 구로구 고척동 342 벽산베스트블루밍아파트")
                    .locationPostalCode("08228")
                    .roadNameAddress("서울특별시 구로구 고척로60길 30, 지하1~2층 (고척동, 벽산베스트블루밍아파트)")
                    .build();
            shelterInformationStagings.add(shelterInformationStaging);
        }
        return shelterInformationStagings;
    }
}