package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.*;

@RequiredArgsConstructor
public class ShelterInformationItemReader implements ItemReader<SeoulShelterInformationDto> {

    private final ShelterInformationApiService shelterInformationApiService;
    private int startIndex = 1;
    private int endIndex = 100;
    private boolean hasMoreData = true;

    @Override
    public SeoulShelterInformationDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (hasMoreData) {
            SeoulShelterInformationDto seoulShelterInformationDto = shelterInformationApiService.fetchShelterInformation(startIndex, endIndex);
            if (seoulShelterInformationDto.getResult().getResultDataDtoList().isEmpty()) {
                hasMoreData = false;
                return null;
            }

            startIndex += 100;
            endIndex += 100;
            return seoulShelterInformationDto;
        }
        return null;
    }
}
