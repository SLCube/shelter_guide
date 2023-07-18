package com.slcube.shelter_guide.batch.processing;

import com.slcube.shelter_guide.batch.comparator.ShelterInformationStagingComparator;
import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ShelterInformationItemProcessor implements ItemProcessor<List<SeoulShelterInformationResultDataDto>, List<SeoulShelterInformationResultDataDto>> {

    private final ShelterInformationApiService shelterInformationApiService;

    @Override
    public List<SeoulShelterInformationResultDataDto> process(List<SeoulShelterInformationResultDataDto> item) throws Exception {

        Iterator<SeoulShelterInformationResultDataDto> iterator = item.iterator();

        while (iterator.hasNext()) {
            SeoulShelterInformationResultDataDto seoulShelterInformationResultDataDto = iterator.next();
            Optional<ShelterInformationStaging> shelterInformationStaging =
                    shelterInformationApiService.findByManagementNumber(seoulShelterInformationResultDataDto.getManagementNumber());

            if (shelterInformationStaging.isPresent()) {
                ShelterInformationStaging shelterInformationStagingEntity = shelterInformationStaging.get();

                if (!ShelterInformationStagingComparator.areEqual(seoulShelterInformationResultDataDto, shelterInformationStagingEntity)) {
                    shelterInformationStagingEntity.update(seoulShelterInformationResultDataDto);
                }
            }
            iterator.remove();
        }

        return item;
    }
}
