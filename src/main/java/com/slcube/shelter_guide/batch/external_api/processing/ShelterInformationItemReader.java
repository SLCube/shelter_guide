package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.util.ShelterInformationApiServiceMap;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationItemReader implements ItemReader<List<SeoulShelterInformationResultDataDto>> {

    private final String region;

    private final ShelterInformationApiServiceMap apiServiceMap;

    private static final int PAGE_SIZE = 100;
    private int startIndex = 1;
    private int endIndex = PAGE_SIZE;
    private boolean hasMoreData = true;

    @Override
    public List<SeoulShelterInformationResultDataDto> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        ShelterInformationApiService apiService = apiServiceMap.getApiService(region);

        if (hasMoreData) {
            List<SeoulShelterInformationResultDataDto> seoulShelterInformationResultDataDtos = apiService.fetchShelterInformation(startIndex, endIndex);
            if (seoulShelterInformationResultDataDtos.isEmpty()) {
                hasMoreData = false;
                return null;
            }

            startIndex += PAGE_SIZE;
            endIndex += PAGE_SIZE;
            return seoulShelterInformationResultDataDtos;
        }
        return null;
    }
}
