package com.slcube.shelter_guide.batch.service;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationDto;
import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ShelterInformationApiService {

    private final RestTemplate restTemplate;

    public List<SeoulShelterInformationResultDataDto> fetchShelterInformation(int startIndex, int endIndex) {
        String url = new StringBuilder().append("/")
                .append(startIndex)
                .append("/")
                .append(endIndex)
                .toString();

        return restTemplate.getForObject(url, SeoulShelterInformationDto.class).getResult().getResultDataDtoList();
    }
}


