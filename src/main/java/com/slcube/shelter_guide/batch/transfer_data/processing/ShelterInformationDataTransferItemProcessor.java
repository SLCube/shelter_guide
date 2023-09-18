package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShelterInformationDataTransferItemProcessor implements ItemProcessor<List<ShelterInformationStaging>, List<ShelterInformationStaging>> {

    private final ShelterInformationRepository shelterInformationRepository;

    @Override
    public List<ShelterInformationStaging> process(List<ShelterInformationStaging> item) throws Exception {

        List<String> businessEstablishmentNameList = item.stream()
                .map(ShelterInformationStaging::getBusinessEstablishmentName)
                .collect(Collectors.toList());

        List<ShelterInformation> foundShelterInformation = shelterInformationRepository.findByBusinessEstablishmentNameIn(businessEstablishmentNameList);

        List<ShelterInformation> sameEntity = foundShelterInformation.stream()
                .filter(shelterInformation -> findByBusinessEstablishmentNameFromShelterInformationStaging(item, shelterInformation.getBusinessEstablishmentName())
                        .filter(shelterInformationStaging -> !shelterInformation.areEqual(shelterInformationStaging))
                        .map(shelterInformationStaging -> {
                            shelterInformation.update(shelterInformationStaging);
                            return shelterInformationStaging;
                        }).isPresent()
                ).collect(Collectors.toList());

        return item.stream()
                .filter(shelterInformationStaging -> sameEntity.stream()
                        .noneMatch(entity -> entity.getBusinessEstablishmentName().equals(shelterInformationStaging.getBusinessEstablishmentName())))
                .collect(Collectors.toList());
    }

    private Optional<ShelterInformationStaging> findByBusinessEstablishmentNameFromShelterInformationStaging(List<ShelterInformationStaging> shelterInformationStagingList, String businessEstablishmentName) {
        return shelterInformationStagingList.stream()
                .filter(shelterInformationStaging -> shelterInformationStaging.getBusinessEstablishmentName().equals(businessEstablishmentName))
                .findFirst();
    }
}
