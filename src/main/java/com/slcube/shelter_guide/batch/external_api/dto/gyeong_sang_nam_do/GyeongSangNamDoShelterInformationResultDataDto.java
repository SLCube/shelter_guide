package com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_nam_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GyeongSangNamDoShelterInformationResultDataDto {

    @JsonProperty("DATA_IDX")
    private String dataIndex;

    @JsonProperty("DATA_TITLE")
    private String businessEstablishmentName;

    @JsonProperty("USER_ADDRESS")
    private String landNumberAddress;
}
