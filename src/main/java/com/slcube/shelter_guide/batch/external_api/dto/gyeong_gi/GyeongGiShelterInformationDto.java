package com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GyeongGiShelterInformationDto {

    @JsonProperty("CivilDefenseEvacuation")
    private GyeongGiShelterInformationResultDto gyeongGiShelterInformationResultDto;
}
