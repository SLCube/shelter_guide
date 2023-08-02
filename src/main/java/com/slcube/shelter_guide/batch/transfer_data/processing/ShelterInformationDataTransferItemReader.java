package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.transfer_data.service.ShelterInformationDataTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationDataTransferItemReader implements ItemReader<List<ShelterInformationStaging>> {

    private final ShelterInformationDataTransferService shelterInformationDataTransferService;

    private int pageNumber = 0;
    private boolean hasMoreData = true;
    @Override

    public List<ShelterInformationStaging> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (hasMoreData) {
            List<ShelterInformationStaging> shelterInformationStagings = shelterInformationDataTransferService.findShelterInformationStagings(pageNumber);
            if (shelterInformationStagings.isEmpty()) {
                hasMoreData = false;
                return null;
            }

            pageNumber++;
            return shelterInformationStagings;
        }

        return null;
    }
}
