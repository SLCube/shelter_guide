package com.slcube.shelter_guide.batch.transfer_data.processor;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ShelterInformationDataTransferItemReader implements ItemReader<ShelterInformationStaging> {
    @Override
    public ShelterInformationStaging read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
