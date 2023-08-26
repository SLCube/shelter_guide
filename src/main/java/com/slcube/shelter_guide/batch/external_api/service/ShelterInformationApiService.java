package com.slcube.shelter_guide.batch.external_api.service;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;

import java.util.List;

public interface ShelterInformationApiService {
    List<SeoulShelterInformationResultDataDto> fetchShelterInformation(int startIndex, int endIndex);
}
