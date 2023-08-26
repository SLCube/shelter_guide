package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class GyeongGiShelterInformationApiService implements ShelterInformationApiService {

    private final RestTemplate restTemplate;

    @Value("${external-service.shelter-information.gyeong-gi.url}")
    private String externalUrl;

    @Value("${external-service.shelter-information.gyeong-gi.api-key}")
    private String apiKey;

    @Override
    public List<ShelterInformationDto> fetchShelterInformation(int startIndex, int endIndex) {
        return null;
    }
}
