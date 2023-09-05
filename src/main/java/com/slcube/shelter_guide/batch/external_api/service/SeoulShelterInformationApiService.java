package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultDto;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.mapper.ShelterInformationDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

    public List<ShelterInformationDto> fetchShelterInformation(int pageNo, int pageSize) throws MalformedURLException, URISyntaxException {

        int startIndex = pageSize * (pageNo - 1) + 1;
        int endIndex = pageSize * pageNo;

        URI uri = new URL(externalUrl.replace("{apiKey}", apiKey)
                .replace("{startIndex}", String.valueOf(startIndex))
                .replace("{endIndex}", String.valueOf(endIndex)))
                .toURI();
        try {
            SeoulShelterInformationDto seoulShelterInformationDto = restTemplate.getForObject(uri, SeoulShelterInformationDto.class);

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
            log.error("Error while calling SEOUL REST API : ", e);
        }

        return Collections.emptyList();
    }
}


