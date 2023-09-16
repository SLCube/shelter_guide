package com.slcube.shelter_guide.batch.external_api.dto.gwang_ju;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GwangJuShelterInformationResultDataDto {

    @JsonProperty("확보면적(제곱미터)")
    private double locationArea;

    @JsonProperty("소재지지번주소")
    private String landNumberAddress;

    @JsonProperty("소재지도로명주소")
    private String roadNameAddress;

    @JsonProperty("민방위대피시설명칭")
    private String businessEstablishmentName;
}
