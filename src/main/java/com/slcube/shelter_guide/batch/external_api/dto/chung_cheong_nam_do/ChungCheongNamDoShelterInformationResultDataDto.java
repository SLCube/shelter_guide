package com.slcube.shelter_guide.batch.external_api.dto.chung_cheong_nam_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ChungCheongNamDoShelterInformationResultDataDto {

    @JsonProperty("민방위대피시설면적")
    private double locationArea;

    @JsonProperty("소재지지번주소")
    private String landNumberAddress;

    @JsonProperty("소재지도로명주소")
    private String roadNameAddress;

    @JsonProperty("민방위대피시설명")
    private String businessEstablishmentName;
}
