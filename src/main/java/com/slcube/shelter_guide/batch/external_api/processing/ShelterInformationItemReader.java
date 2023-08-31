package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.util.ShelterInformationApiServiceMap;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationItemReader implements ItemReader<List<ShelterInformationDto>> {

    private final String region;

    private final ShelterInformationApiServiceMap apiServiceMap;

    private static final int PAGE_SIZE = 1000;
    private int pageNo = 1;
    private boolean hasMoreData = true;

    @Override
    public List<ShelterInformationDto> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        ShelterInformationApiService apiService = apiServiceMap.getApiService(region);

        if (hasMoreData) {
            List<ShelterInformationDto> seoulShelterInformationResultDataDtos = apiService.fetchShelterInformation(pageNo, PAGE_SIZE);
            if (seoulShelterInformationResultDataDtos.isEmpty()) {
                hasMoreData = false;
                return null;
            }

            pageNo++;
            return seoulShelterInformationResultDataDtos;
        }
        return null;
    }
}
