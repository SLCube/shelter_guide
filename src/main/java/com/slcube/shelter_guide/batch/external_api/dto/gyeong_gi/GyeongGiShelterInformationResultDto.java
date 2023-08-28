package com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class GyeongGiShelterInformationResultDto {

    @JsonProperty("head")
    private GyeongGiShelterInformationResultCodeDto gyeongGiShelterInformationResultCodeDto;

    @JsonProperty("row")
    private List<GyeongGiShelterInformationResultDataDto> gyeongGiShelterInformationResultDataDto;
}
