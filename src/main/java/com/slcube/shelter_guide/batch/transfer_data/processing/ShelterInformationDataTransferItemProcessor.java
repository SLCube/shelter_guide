package com.slcube.shelter_guide.batch.transfer_data.processing;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.transfer_data.comparator.ShelterInformationComparator;
import com.slcube.shelter_guide.batch.transfer_data.service.ShelterInformationDataTransferService;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ShelterInformationDataTransferItemProcessor implements ItemProcessor<List<ShelterInformationStaging>, List<ShelterInformationStaging>> {

    private final ShelterInformationDataTransferService shelterInformationDataTransferService;

    @Override
    public List<ShelterInformationStaging> process(List<ShelterInformationStaging> item) throws Exception {
        Iterator<ShelterInformationStaging> iterator = item.iterator();
        while (iterator.hasNext()) {
            ShelterInformationStaging shelterInformationStaging = iterator.next();
            Optional<ShelterInformation> shelterInformation = shelterInformationDataTransferService.findByManagementNumber(shelterInformationStaging.getManagementNumber());

            if (shelterInformation.isPresent()) {
                ShelterInformation shelterInformationEntity = shelterInformation.get();
                if (!ShelterInformationComparator.areEqual(shelterInformationStaging, shelterInformationEntity)) {
                    shelterInformationEntity.update(shelterInformationStaging);
                }

                iterator.remove();
            }
        }
        return item;
    }
}
