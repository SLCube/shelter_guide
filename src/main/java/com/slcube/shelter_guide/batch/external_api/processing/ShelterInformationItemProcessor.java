package com.slcube.shelter_guide.batch.external_api.processing;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShelterInformationItemProcessor implements ItemProcessor<List<ShelterInformationDto>, List<ShelterInformationDto>> {

    private final ShelterInformationStagingRepository shelterInformationStagingRepository;

    @Override
    public List<ShelterInformationDto> process(List<ShelterInformationDto> item) throws Exception {

        List<String> establishmentNameList = item.stream()
                .map(ShelterInformationDto::getBusinessEstablishmentName)
                .collect(Collectors.toList());

        List<ShelterInformationStaging> foundShelterInformationStaging = shelterInformationStagingRepository.findByBusinessEstablishmentNameIn(establishmentNameList);

        List<ShelterInformationStaging> sameEntity = foundShelterInformationStaging.stream()
                .filter(shelterInformationStaging -> findByEstablishmentNameFromDto(item, shelterInformationStaging.getBusinessEstablishmentName())
                        .filter(shelterInformationDto -> !shelterInformationStaging.areEqual(shelterInformationDto))
                        .map(dataDto -> {
                            shelterInformationStaging.update(dataDto);
                            return dataDto;
                        }).isPresent()
                ).collect(Collectors.toList());

        return item.stream()
                .filter(dto -> sameEntity.stream()
                        .noneMatch(entity -> entity.getBusinessEstablishmentName().equals(dto.getBusinessEstablishmentName()))
                ).collect(Collectors.toList());
    }

    private Optional<ShelterInformationDto> findByEstablishmentNameFromDto(List<ShelterInformationDto> dtoList, String establishmentName) {
        return dtoList.stream()
                .filter(dto -> dto.getBusinessEstablishmentName().equals(establishmentName))
                .findFirst();
    }
}

