package com.slcube.shelter_guide.batch.external_api.dto.jeolla_nam_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class JeollaNamDoShelterInformationResultDataDto {

    @JsonProperty("민방위 주민대피시설 명칭")
    private String businessEstablishmentName;

    @JsonProperty("도로명 주소")
    private String roadNameAddress;

    @JsonProperty("확보면적(제곱미터)")
    private double locationArea;
}
