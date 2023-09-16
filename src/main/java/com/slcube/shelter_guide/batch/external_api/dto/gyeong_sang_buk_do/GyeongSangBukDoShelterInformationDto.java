package com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_buk_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GyeongSangBukDoShelterInformationDto {

    private int currentCount;

    @JsonProperty("data")
    private List<GyeongSangBukDoShelterInformationResultDataDto> resultDtoList = new ArrayList<>();
}
