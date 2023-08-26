package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationStagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationItemWriter implements ItemWriter<List<ShelterInformationDto>> {

    private final ShelterInformationStagingService shelterInformationStagingService;

    @Override
    public void write(List<? extends List<ShelterInformationDto>> items) throws Exception {
        validationItems(items);
        items.forEach(shelterInformationStagingService::storeShelterInformation);
    }

    private void validationItems(List<? extends List<ShelterInformationDto>> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items can not be null");
        }
    }
}
