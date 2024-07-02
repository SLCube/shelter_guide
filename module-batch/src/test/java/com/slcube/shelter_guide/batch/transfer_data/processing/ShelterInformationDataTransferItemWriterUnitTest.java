package com.slcube.shelter_guide.batch.transfer_data.processing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShelterInformationDataTransferItemWriterUnitTest {

    @InjectMocks
    private ShelterInformationDataTransferItemWriter shelterInformationDataTransferItemWriter;

    @Test
    void list가_null일때_예외체크_테스트() {
        Assertions.assertThatThrownBy(() -> shelterInformationDataTransferItemWriter.write(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Items can not be null");
    }
}