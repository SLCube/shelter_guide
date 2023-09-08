package com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_nam_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GyeongSangNamDoShelterInformationDto {

    private int currentCount;

    @JsonProperty("data")
    private List<GyeongSangNamDoShelterInformationResultDataDto> resultDtoList = new ArrayList<>();
}
