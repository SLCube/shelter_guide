package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.transfer_data.service.ShelterInformationDataTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationDataTransferItemWriter implements ItemWriter<List<ShelterInformationStaging>> {

    private final ShelterInformationDataTransferService shelterInformationDataTransferService;

    @Override
    public void write(List<? extends List<ShelterInformationStaging>> items) throws Exception {
        validationItems(items);
        items.forEach(shelterInformationDataTransferService::storeShelterInformation);
    }

    private void validationItems(List<? extends List<ShelterInformationStaging>> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items can not be null");
        }
    }
}
