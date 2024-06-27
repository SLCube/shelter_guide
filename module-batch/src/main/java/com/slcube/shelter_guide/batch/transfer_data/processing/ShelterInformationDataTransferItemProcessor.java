package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.util.ShelterInformationComparator;
import com.slcube.shelter_guide.domain.ShelterInformation;
import com.slcube.shelter_guide.domain.ShelterInformationStaging;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import com.slcube.shelter_guide.repository.ShelterInformationRepository;

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
        shelterInformationRepository.findByBusinessEstablishmentNameIn(businessEstablishmentNameList);
        List<ShelterInformation> foundShelterInformation = shelterInformationRepository.findByBusinessEstablishmentNameIn(businessEstablishmentNameList);

        List<ShelterInformation> sameEntity = foundShelterInformation.stream()
                .filter(shelterInformation -> findByBusinessEstablishmentNameFromShelterInformationStaging(item, shelterInformation.getBusinessEstablishmentName())
                        .filter(shelterInformationStaging -> !ShelterInformationComparator.compare(shelterInformation, shelterInformationStaging))
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
