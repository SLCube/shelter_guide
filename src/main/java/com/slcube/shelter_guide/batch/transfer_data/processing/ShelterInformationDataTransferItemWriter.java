package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.transfer_data.mapper.ShelterInformationMapper;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShelterInformationDataTransferItemWriter implements ItemWriter<List<ShelterInformationStaging>> {

    private final ShelterInformationRepository shelterInformationRepository;
    @Override
    public void write(List<? extends List<ShelterInformationStaging>> items) throws Exception {
        validationItems(items);
        items.forEach(item -> {
            List<ShelterInformation> shelterinformationList = item.stream().map(ShelterInformationMapper::toEntity)
                    .collect(Collectors.toList());

            shelterInformationRepository.saveAll(shelterinformationList);
        });
    }

    private void validationItems(List<? extends List<ShelterInformationStaging>> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items can not be null");
        }
    }
}
