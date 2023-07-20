package com.slcube.shelter_guide.batch.service;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDto;
import com.slcube.shelter_guide.batch.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.mapper.ShelterInformationMapper;
import com.slcube.shelter_guide.batch.repository.ShelterInformationStagingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class ShelterInformationApiService {

    private final RestTemplate restTemplate;
    private final ShelterInformationStagingRepository shelterInformationStagingRepository;

    public List<SeoulShelterInformationResultDataDto> fetchShelterInformation(int startIndex, int endIndex) {
        String url = "/" + startIndex + "/" + endIndex;

        try {
            SeoulShelterInformationDto seoulShelterInformationDto = restTemplate.getForObject(url, SeoulShelterInformationDto.class);

            if (seoulShelterInformationDto != null) {
                SeoulShelterInformationResultDto result = seoulShelterInformationDto.getResult();
                if (result != null) {
                    return result.getResultDataDtoList();
                }
            }
        } catch (Exception e) {
            log.error("Error while calling REST API : ", e);
        }


        return Collections.emptyList();
    }


    @Transactional
    public void storeShelterInformation(List<SeoulShelterInformationResultDataDto> shelterInformations) {

        List<ShelterInformationStaging> shelterInformationStagings = shelterInformations
                .stream()
                .map(ShelterInformationMapper::toEntity)
                .collect(Collectors.toList());

        shelterInformationStagingRepository.saveAll(shelterInformationStagings);
    }



    public Optional<ShelterInformationStaging> findByManagementNumber(String managementNumber) {
        return shelterInformationStagingRepository.findByManagementNumber(managementNumber);
    }
}


