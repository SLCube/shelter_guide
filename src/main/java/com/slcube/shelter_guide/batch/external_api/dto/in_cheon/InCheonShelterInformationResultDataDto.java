package com.slcube.shelter_guide.batch.external_api.dto.in_cheon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class InCheonShelterInformationResultDataDto {

    @JsonProperty("민방위대피시설명칭")
    private String businessEstablishmentName;

    @JsonProperty("대피시설_확보면적(제곱미터)")
    private double locationArea;

    @JsonProperty("지번 주소")
    private String landNumberAddress;

    @JsonProperty("도로명 주소")
    private String roadNameAddress;
}
