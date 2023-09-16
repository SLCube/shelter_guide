package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RequiredArgsConstructor
public class ShelterInformationDataTransferItemReader implements ItemReader<List<ShelterInformationStaging>> {

    private final ShelterInformationStagingRepository shelterInformationStagingRepository;

    private int pageNumber = 0;
    private boolean hasMoreData = true;
    private static final int PAGE_SIZE = 1000;
    @Override

    public List<ShelterInformationStaging> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (hasMoreData) {
            PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE);
            List<ShelterInformationStaging> shelterInformationStagings = shelterInformationStagingRepository.findAllWithPaging(pageRequest);
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
