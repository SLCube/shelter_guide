package com.slcube.shelter_guide.batch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SeoulShelterInformationResultCodeDto {

    @JsonProperty("CODE")
    private String resultCode;

    @JsonProperty("MESSAGE")
    private String message;
}
