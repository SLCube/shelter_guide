package com.slcube.shelter_guide.batch.external_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SeoulShelterInformationDto {

    @JsonProperty("LOCALDATA_114602")
    private SeoulShelterInformationResultDto result;
}
