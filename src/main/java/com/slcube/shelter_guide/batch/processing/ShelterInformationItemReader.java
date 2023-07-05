package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.*;

@RequiredArgsConstructor
public class ShelterInformationItemReader extends ItemStreamSupport implements ItemReader<SeoulShelterInformationDto> {

    private final ShelterInformationApiService shelterInformationApiService;

    @Override
    public void open(ExecutionContext executionContext) {

    }

    @Override
    public SeoulShelterInformationDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return shelterInformationApiService.fetchShelterInformation();
    }
}
