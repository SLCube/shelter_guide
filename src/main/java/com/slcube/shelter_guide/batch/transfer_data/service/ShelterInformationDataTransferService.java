package com.slcube.shelter_guide.batch.transfer_data.service;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import com.slcube.shelter_guide.batch.transfer_data.mapper.ShelterInformationMapper;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ShelterInformationDataTransferService {

    private final ShelterInformationRepository shelterInformationRepository;
    private final ShelterInformationStagingRepository shelterInformationStagingRepository;
    private static final int PAGE_SIZE = 100;

    public void storeShelterInformation(List<ShelterInformationStaging> shelterInformationStagings) {
        List<ShelterInformation> shelterInformation = shelterInformationStagings.stream()
                .map(ShelterInformationMapper::toEntity).collect(Collectors.toList());

        shelterInformationRepository.saveAll(shelterInformation);
    }

    public List<ShelterInformationStaging> findShelterInformationStagings(int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE);
        return shelterInformationStagingRepository.findAllWithPaging(pageRequest);
    }

    public Optional<ShelterInformation> findByManagementNumber(String managementNumber) {
        return shelterInformationRepository.findByManagementNumber(managementNumber);
    }
}
