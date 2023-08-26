package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.mapper.ShelterInformationStagingMapper;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShelterInformationStagingService {

    private final ShelterInformationStagingRepository shelterInformationStagingRepository;

    @Transactional
    public void storeShelterInformation(List<ShelterInformationDto> shelterInformation) {
        validationShelterInformation(shelterInformation);
        List<ShelterInformationStaging> shelterInformationStagings = shelterInformation
                .stream()
                .map(ShelterInformationStagingMapper::toEntity)
                .collect(Collectors.toList());

        shelterInformationStagingRepository.saveAll(shelterInformationStagings);
    }

    private void validationShelterInformation(List<ShelterInformationDto>  shelterInformation) {
        if (shelterInformation == null) {
            throw new IllegalArgumentException("Shelter Information can not be null");
        }
    }



    public Optional<ShelterInformationStaging> findByManagementNumber(String managementNumber) {
        return shelterInformationStagingRepository.findByManagementNumber(managementNumber);
    }
}
