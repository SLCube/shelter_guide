package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.service.SeoulShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.util.ShelterInformationApiServiceMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.SEOUL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationItemReaderUnitTest {

    @Mock
    private SeoulShelterInformationApiService seoulShelterInformationApiService;

    @Mock
    private ShelterInformationApiServiceMap apiServiceMap;
    private ShelterInformationItemReader itemReader;

    AutoCloseable autoCloseable;

    @Before
    public void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);

        when(apiServiceMap.getApiService(anyString()))
                .thenReturn(seoulShelterInformationApiService);

        this.itemReader = new ShelterInformationItemReader(SEOUL.getRegion(), apiServiceMap);
    }

    @After
    public void cleanUp() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void 서울시_대피소에_대한_Item_Reader_단위테스트() throws Exception {
        List<ShelterInformationDto> resultDataDtoList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ShelterInformationDto shelterInformationResultDataDto = new ShelterInformationDto();
            resultDataDtoList.add(shelterInformationResultDataDto);
        }

        when(seoulShelterInformationApiService.fetchShelterInformation(anyInt(), anyInt()))
                .thenReturn(resultDataDtoList);

        assertThat(itemReader.read()).isEqualTo(resultDataDtoList);
    }

    @Test
    public void 서울시_대피소_정보_리스트가_비어있을_때의_테스트() throws Exception {
        List<ShelterInformationDto> resultDataDtoList = new ArrayList<>();
        when(seoulShelterInformationApiService.fetchShelterInformation(anyInt(), anyInt()))
                .thenReturn(resultDataDtoList);

        assertThat(itemReader.read()).isNull();
    }
}
