package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.service.SeoulShelterInformationApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationItemWriterUnitTest {

    @Mock
    private SeoulShelterInformationApiService seoulShelterInformationApiService;

    @InjectMocks
    private ShelterInformationItemWriter shelterInformationItemWriter;

    @Test
    void list가_null일때_예외체크_테스트() {
        assertThatThrownBy(() -> shelterInformationItemWriter.write(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Items can not be null");
    }
}
