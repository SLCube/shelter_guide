package com.slcube.shelter_guide.business.service;

import com.slcube.shelter_guide.business.dto.ShelterInformationListResponseDto;
import com.slcube.shelter_guide.business.dto.ShelterInformationResponseDto;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import com.slcube.shelter_guide.common.exception.NotFoundShelterInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShelterInformationService {

    private final ShelterInformationRepository shelterInformationRepository;

    public List<ShelterInformationListResponseDto> findShelterInformation(String district) {
        return shelterInformationRepository.findByDistrict(district)
                .stream().map(ShelterInformationListResponseDto::new)
                .collect(Collectors.toList());
    }

    public ShelterInformationResponseDto findById(Long id) {
        ShelterInformation shelterInformation = shelterInformationRepository.findById(id)
                .orElseThrow(NotFoundShelterInformation::new);

        return new ShelterInformationResponseDto(shelterInformation);
    }
}
