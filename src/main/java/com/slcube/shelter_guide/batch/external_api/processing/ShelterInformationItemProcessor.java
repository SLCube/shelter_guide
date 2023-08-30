package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ShelterInformationItemProcessor implements ItemProcessor<List<ShelterInformationDto>, List<ShelterInformationDto>> {

    private final ShelterInformationStagingRepository shelterInformationStagingRepository;

    @Override
    public List<ShelterInformationDto> process(List<ShelterInformationDto> item) throws Exception {

        Iterator<ShelterInformationDto> iterator = item.iterator();

        while (iterator.hasNext()) {
            ShelterInformationDto shelterInformationDto = iterator.next();
            Optional<ShelterInformationStaging> foundShelterInformationStaging = shelterInformationStagingRepository.findByManagementNumber(shelterInformationDto.getManagementNumber());

            if (foundShelterInformationStaging.isPresent()) {
                ShelterInformationStaging shelterInformationStaging = foundShelterInformationStaging.get();

                if (!ShelterInformationStaging.areEqual(shelterInformationDto, shelterInformationStaging)) {
                    shelterInformationStaging.update(shelterInformationDto);
                }
                iterator.remove();
            }
        }

        return item;
    }
}

