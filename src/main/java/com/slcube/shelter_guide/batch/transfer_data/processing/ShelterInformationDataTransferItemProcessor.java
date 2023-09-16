package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ShelterInformationDataTransferItemProcessor implements ItemProcessor<List<ShelterInformationStaging>, List<ShelterInformationStaging>> {

    private final ShelterInformationRepository shelterInformationRepository;

    @Override
    public List<ShelterInformationStaging> process(List<ShelterInformationStaging> item) throws Exception {
        Iterator<ShelterInformationStaging> iterator = item.iterator();
        while (iterator.hasNext()) {
            ShelterInformationStaging shelterInformationStaging = iterator.next();
            Optional<ShelterInformation> shelterInformation = shelterInformationRepository.findByBusinessEstablishmentName(shelterInformationStaging.getBusinessEstablishmentName());

            if (shelterInformation.isPresent()) {
                ShelterInformation shelterInformationEntity = shelterInformation.get();
                if (!shelterInformationEntity.areEqual(shelterInformationStaging, shelterInformationEntity)) {
                    shelterInformationEntity.update(shelterInformationStaging);
                }

                iterator.remove();
            }
        }
        return item;
    }
}
