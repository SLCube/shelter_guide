package com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GyeongGiShelterInformationResultDataDto {

    @JsonProperty("MANAGE_ID")
    private String managementNumber;


}
