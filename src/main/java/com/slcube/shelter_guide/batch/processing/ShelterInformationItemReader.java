package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationItemReader implements ItemReader<List<SeoulShelterInformationResultDataDto>> {

    private final ShelterInformationApiService shelterInformationApiService;
    private int startIndex = 1;
    private int endIndex = 100;
    private boolean hasMoreData = true;

    @Override
    public List<SeoulShelterInformationResultDataDto> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (hasMoreData) {
            List<SeoulShelterInformationResultDataDto> seoulShelterInformationResultDataDtos = shelterInformationApiService.fetchShelterInformation(startIndex, endIndex);
            if (seoulShelterInformationResultDataDtos.isEmpty()) {
                hasMoreData = false;
                return null;
            }

            startIndex += 100;
            endIndex += 100;
            return seoulShelterInformationResultDataDtos;
        }
        return null;
    }
}
