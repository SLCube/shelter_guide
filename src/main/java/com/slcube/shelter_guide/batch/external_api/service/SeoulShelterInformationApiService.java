package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDto;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class SeoulShelterInformationApiService {

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
}


