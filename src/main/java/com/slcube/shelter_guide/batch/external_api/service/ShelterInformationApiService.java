package com.slcube.shelter_guide.batch.external_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public interface ShelterInformationApiService {
    List<ShelterInformationDto> fetchShelterInformation(int pageNo, int pageSize) throws MalformedURLException, URISyntaxException, JsonProcessingException;
}
