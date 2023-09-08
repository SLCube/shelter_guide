package com.slcube.shelter_guide.batch.external_api.dto.daejeon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DaeJeonShelterInformationResultDataDto {

    @JsonProperty("수용가능면적(m²)")
    private double locationArea;

    @JsonProperty("위치")
    private String roadNameAddress;

    @JsonProperty("시설명")
    private String businessEstablishmentName;
}
