package com.slcube.shelter_guide.batch.external_api.dto.jeju;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class JejuShelterInformationResultDataDto {

    @JsonProperty("건물명")
    private String businessEstablishmentName;

    @JsonProperty("수용가능면적(㎡)")
    private double locationArea;

    @JsonProperty("위치")
    private String roadNameAddress;
}
