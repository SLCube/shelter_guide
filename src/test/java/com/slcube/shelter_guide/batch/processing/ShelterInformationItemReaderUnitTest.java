package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShelterInformationItemReaderUnitTest {

    @Mock
    private ShelterInformationApiService shelterInformationApiService;

    @InjectMocks
    private ShelterInformationItemReader itemReader;

    @Test
    @DisplayName("서울시 대피소에 대한 Item Reader 단위테스트")
    public void seoulShelterInformationItemReaderUnitTest() throws Exception {
        List<SeoulShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            SeoulShelterInformationResultDataDto seoulShelterInformationResultDataDto = new SeoulShelterInformationResultDataDto();
            resultDataDtoList.add(seoulShelterInformationResultDataDto);
        }

        when(shelterInformationApiService.fetchShelterInformation(anyInt(), anyInt()))
                .thenReturn(resultDataDtoList);

        assertThat(itemReader.read()).isEqualTo(resultDataDtoList);
    }

    @Test
    public void 서울시_대피소_정보_리스트가_비어있을_때의_테스트() throws Exception {
        List<SeoulShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
        when(shelterInformationApiService.fetchShelterInformation(anyInt(), anyInt()))
                .thenReturn(resultDataDtoList);

        assertThat(itemReader.read()).isNull();
    }
}