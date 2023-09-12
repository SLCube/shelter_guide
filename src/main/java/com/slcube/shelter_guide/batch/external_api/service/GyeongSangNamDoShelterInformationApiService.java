package com.slcube.shelter_guide.batch.external_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_nam_do.GyeongSangNamDoShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.mapper.ShelterInformationDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GyeongSangNamDoShelterInformationApiService implements ShelterInformationApiService {

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Value("${external-service.shelter-information.gyeong-sang-nam-do.url}")
    private String externalUrl;

    @Value("${external-service.shelter-information.gyeong-sang-nam-do.api-key}")
    private String apiKey;

    @Override
    public List<ShelterInformationDto> fetchShelterInformation(int pageNo, int pageSize) throws MalformedURLException, URISyntaxException, JsonProcessingException {

        URI uri = new URL(externalUrl.replace("{apiKey}", apiKey)
                .replace("{pageIndex}", String.valueOf(pageNo))
                .replace("{pageSize}", String.valueOf(pageSize)))
                .toURI();

        String gyeongSangNamDoShelterInformationJsonString
                = restTemplate.getForObject(uri, String.class);

        JsonNode shelterInformationJsonNode = objectMapper.readTree(gyeongSangNamDoShelterInformationJsonString)
                .get("gyeongnamdisasterfacilitylist")
                .get("body")
                .get("items")
                .get("item");

        if (shelterInformationJsonNode == null) {
            return Collections.emptyList();
        }

        List<GyeongSangNamDoShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();

        for (JsonNode node : shelterInformationJsonNode) {
            GyeongSangNamDoShelterInformationResultDataDto gyeongSangNamDoShelterInformationResultDataDto = objectMapper.convertValue(node, GyeongSangNamDoShelterInformationResultDataDto.class);
            resultDataDtoList.add(gyeongSangNamDoShelterInformationResultDataDto);
        }

        return resultDataDtoList.stream()
                .map(ShelterInformationDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
