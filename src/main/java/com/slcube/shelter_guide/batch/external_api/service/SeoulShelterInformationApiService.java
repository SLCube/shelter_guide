package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDto;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.mapper.ShelterInformationDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class SeoulShelterInformationApiService implements ShelterInformationApiService {

    private final RestTemplate restTemplate;

    @Value("${external-service.shelter-information.seoul.url}")
    private String externalUrl;

    @Value("${external-service.shelter-information.seoul.api-key}")
    private String apiKey;

    public List<ShelterInformationDto> fetchShelterInformation(int startIndex, int endIndex) {
        String url = "/" + startIndex + "/" + endIndex;

        try {
            SeoulShelterInformationDto seoulShelterInformationDto = restTemplate.getForObject(url, SeoulShelterInformationDto.class);

            if (seoulShelterInformationDto != null) {
                SeoulShelterInformationResultDto result = seoulShelterInformationDto.getResult();
                if (result != null) {
                    List<SeoulShelterInformationResultDataDto> seoulShelterInformationList = result.getResultDataDtoList();
                    return seoulShelterInformationList.stream()
                            .map(ShelterInformationDtoMapper::toDto)
                            .collect(Collectors.toList());
                }
            }
        } catch (Exception e) {
            log.error("Error while calling REST API : ", e);
        }


        return Collections.emptyList();
    }
}


