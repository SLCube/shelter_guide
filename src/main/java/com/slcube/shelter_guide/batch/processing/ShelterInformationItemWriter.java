package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationItemWriter implements ItemWriter<List<SeoulShelterInformationResultDataDto>> {

    private final ShelterInformationApiService shelterInformationApiService;

    @Override
    public void write(List<? extends List<SeoulShelterInformationResultDataDto>> items) throws Exception {
        validationShelterInformation(items);
        items.forEach(shelterInformationApiService::storeShelterInformation);
    }

    private void validationShelterInformation(List<? extends List<SeoulShelterInformationResultDataDto>>  shelterInformation) {
        if (shelterInformation == null) {
            throw new IllegalArgumentException("Shelter Information can not null");
        }
    }
}
