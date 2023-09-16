package com.slcube.shelter_guide.batch.external_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeolla_nam_do.JeollaNamDoShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.mapper.ShelterInformationDtoMapper;
import lombok.RequiredArgsConstructor;
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
@Service
public class JeollaNamDoShelterInformationApiService implements ShelterInformationApiService {

    private final RestTemplate restTemplate;

    @Value("${external-service.shelter-information.jeolla-nam-do.url}")
    private String externalUrl;

    @Value("${external-service.shelter-information.jeolla-nam-do.api-key}")
    private String apiKey;

    @Override
    public List<ShelterInformationDto> fetchShelterInformation(int pageNo, int pageSize) throws MalformedURLException, URISyntaxException, JsonProcessingException {

        URI uri = new URL(externalUrl.replace("{apiKey}", apiKey)
                .replace("{pageIndex}", String.valueOf(pageNo))
                .replace("{pageSize}", String.valueOf(pageSize)))
                .toURI();

        JeollaNamDoShelterInformationDto shelterInformationDto = restTemplate.getForObject(uri, JeollaNamDoShelterInformationDto.class);

        if (shelterInformationDto != null) {
            return shelterInformationDto.getResultDataDtoList()
                    .stream()
                    .map(ShelterInformationDtoMapper::toDto)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
