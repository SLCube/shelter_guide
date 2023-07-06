package com.slcube.shelter_guide.batch.service;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
public class ShelterInformationApiService {

    private final RestTemplate restTemplate;

    public SeoulShelterInformationDto fetchShelterInformation(int startIndex, int endIndex) {
        String url = new StringBuilder().append("/")
                .append(startIndex)
                .append("/")
                .append(endIndex)
                .toString();

        return restTemplate.getForObject(url, SeoulShelterInformationDto.class);
    }
}


