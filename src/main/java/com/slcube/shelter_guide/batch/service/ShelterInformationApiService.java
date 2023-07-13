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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class ShelterInformationApiService {

    private final RestTemplate restTemplate;
    private final ShelterInformationStagingRepository shelterInformationStagingRepository;

    public List<SeoulShelterInformationResultDataDto> fetchShelterInformation(int startIndex, int endIndex) {
        String url = "/";

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .pathSegment(String.valueOf(startIndex), String.valueOf(endIndex))
                .build()
                .toUri();

        try {
            SeoulShelterInformationDto seoulShelterInformationDto = restTemplate.getForObject(uri, SeoulShelterInformationDto.class);

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


