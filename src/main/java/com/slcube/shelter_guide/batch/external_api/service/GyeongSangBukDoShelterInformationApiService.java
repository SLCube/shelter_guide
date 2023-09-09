package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_buk_do.GyeongSangBukDoShelterInformationDto;
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
public class GyeongSangBukDoShelterInformationApiService implements ShelterInformationApiService {

    private final RestTemplate restTemplate;

    @Value("${external-service.shelter-information.gyeong-sang-nam-do.url}")
    private String externalUrl;

    @Value("${external-service.shelter-information.gyeong-sang-nam-do.api-key}")
    private String apiKey;

    @Override
    public List<ShelterInformationDto> fetchShelterInformation(int pageNo, int pageSize) throws MalformedURLException, URISyntaxException {

        URI uri = new URL(externalUrl.replace("{pageIndex}", String.valueOf(pageNo))
                .replace("{pageSize}", String.valueOf(pageSize))
                .replace("{apiKey}", apiKey))
                .toURI();

        GyeongSangBukDoShelterInformationDto shelterInformationDto = restTemplate.getForObject(uri, GyeongSangBukDoShelterInformationDto.class);

        if (shelterInformationDto != null) {
            return shelterInformationDto.getResultDtoList()
                    .stream()
                    .map(ShelterInformationDtoMapper::toDto)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
