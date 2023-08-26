package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationStagingService;
import com.slcube.shelter_guide.batch.external_api.util.ShelterInformationStagingComparator;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ShelterInformationItemProcessor implements ItemProcessor<List<ShelterInformationDto>, List<ShelterInformationDto>> {

    private final ShelterInformationStagingService shelterInformationStagingService;

    @Override
    public List<ShelterInformationDto> process(List<ShelterInformationDto> item) throws Exception {

        Iterator<ShelterInformationDto> iterator = item.iterator();

        while (iterator.hasNext()) {
            ShelterInformationDto shelterInformationDto = iterator.next();
            Optional<ShelterInformationStaging> shelterInformationStaging =
                    shelterInformationStagingService.findByManagementNumber(shelterInformationDto.getManagementNumber());

            if (shelterInformationStaging.isPresent()) {
                ShelterInformationStaging shelterInformationStagingEntity = shelterInformationStaging.get();

                if (!ShelterInformationStagingComparator.areEqual(shelterInformationDto, shelterInformationStagingEntity)) {
                    shelterInformationStagingEntity.update(shelterInformationDto);
                }
                iterator.remove();
            }
        }

        return item;
    }
}
