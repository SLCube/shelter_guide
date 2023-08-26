package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;

import java.util.List;

public interface ShelterInformationApiService {
    List<ShelterInformationDto> fetchShelterInformation(int startIndex, int endIndex);
}
