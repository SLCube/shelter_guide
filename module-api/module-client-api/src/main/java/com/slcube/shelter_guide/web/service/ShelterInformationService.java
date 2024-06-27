package com.slcube.shelter_guide.web.service;

import com.slcube.shelter_guide.web.config.exception.NotFoundShelterInformation;
import com.slcube.shelter_guide.domain.ShelterInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.slcube.shelter_guide.port.ShelterInformationPort;
import com.slcube.shelter_guide.web.dto.ShelterInformationListResponseDto;
import com.slcube.shelter_guide.web.dto.ShelterInformationResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShelterInformationService {
    private final ShelterInformationPort shelterInformationPort;

    public List<ShelterInformationListResponseDto> findShelterInformation(String district) {
        return shelterInformationPort.findByDistrict(district)
                .stream().map(ShelterInformationListResponseDto::new)
                .collect(Collectors.toList());
    }

    public ShelterInformationResponseDto findById(Long id) {
        ShelterInformation shelterInformation = shelterInformationPort.findById(id)
                .orElseThrow(NotFoundShelterInformation::new);

        return new ShelterInformationResponseDto(shelterInformation);
    }
}
