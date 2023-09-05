package com.slcube.shelter_guide.batch.external_api.dto.jeolla_buk_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class JeollaBukDoShelterInformationResultDataDto {

    @JsonProperty("지정연도")
    private String licenseDate;

    @JsonProperty("대피시설명")
    private String businessEstablishmentName;

    @JsonProperty("대피시설 면적")
    private double locationArea;

    @JsonProperty("도로명 주소")
    private String roadNameAddress;

    @JsonProperty("지번주소")
    private String landNumberAddress;
}
