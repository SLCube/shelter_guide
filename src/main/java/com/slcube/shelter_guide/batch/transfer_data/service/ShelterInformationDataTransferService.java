package com.slcube.shelter_guide.batch.transfer_data.service;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.transfer_data.mapper.ShelterInformationMapper;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ShelterInformationDataTransferService {

    private final ShelterInformationRepository shelterInformationRepository;

    public void storeShelterInformation(List<ShelterInformationStaging> shelterInformationStagings) {
        List<ShelterInformation> shelterInformation = shelterInformationStagings.stream()
                .map(ShelterInformationMapper::toEntity).collect(Collectors.toList());

        shelterInformationRepository.saveAll(shelterInformation);
    }
}
