package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationItemWriterUnitTest {

    @Mock
    private ShelterInformationApiService shelterInformationApiService;

    @InjectMocks
    private ShelterInformationItemWriter shelterInformationItemWriter;

    @Test
    void list가_null일때_예외체크_테스트() {
        assertThatThrownBy(() -> shelterInformationItemWriter.write(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Shelter Information can not null");
    }
}