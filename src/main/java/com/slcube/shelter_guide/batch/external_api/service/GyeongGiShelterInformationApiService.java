package com.slcube.shelter_guide.batch.external_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi.GyeongGiShelterInformationResultDataDto;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class GyeongGiShelterInformationApiService implements ShelterInformationApiService {

    private final RestTemplate restTemplate;

    @Value("${external-service.shelter-information.gyeong-gi.url}")
    private String externalUrl;

    @Value("${external-service.shelter-information.gyeong-gi.api-key}")
    private String apiKey;

    private final ObjectMapper objectMapper;

    @Override
    public List<ShelterInformationDto> fetchShelterInformation(int pageNo, int pageSize) throws MalformedURLException, URISyntaxException, JsonProcessingException {

        URI uri = new URL(externalUrl.replace("{apiKey}", apiKey)
                .replace("{pageIndex}", String.valueOf(pageNo))
                .replace("{pSize}", String.valueOf(pageSize)))
                .toURI();

        String gyeongGiShelterInformationJsonString = restTemplate.getForObject(uri, String.class);

        // 외부 api가 반환하는 json형태가 보기좋지않아 method chaining을 이용해 이게 과연 맞는건가..?
        JsonNode civilDefenseEvacuation = objectMapper.readTree(gyeongGiShelterInformationJsonString)
                .get("CivilDefenseEvacuation");

        if (civilDefenseEvacuation == null) {
            return Collections.emptyList();
        }

        JsonNode jsonNode = civilDefenseEvacuation.get(1).get("row");

        List<GyeongGiShelterInformationResultDataDto> gyeongGiShelterInformationResultDataDtoList = new ArrayList<>();

        for (JsonNode node : jsonNode) {
            GyeongGiShelterInformationResultDataDto gyeongGiShelterInformationResultDataDto = objectMapper.convertValue(node, GyeongGiShelterInformationResultDataDto.class);
            gyeongGiShelterInformationResultDataDtoList.add(gyeongGiShelterInformationResultDataDto);
        }

        return gyeongGiShelterInformationResultDataDtoList.stream()
                .map(ShelterInformationDtoMapper::toDto)
                .collect(Collectors.toList());

    }
}
