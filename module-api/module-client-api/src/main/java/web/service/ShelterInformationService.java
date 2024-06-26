package web.service;

import common.exception.NotFoundShelterInformation;
import domain.ShelterInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ShelterInformationRepository;
import web.dto.ShelterInformationListResponseDto;
import web.dto.ShelterInformationResponseDto;

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
