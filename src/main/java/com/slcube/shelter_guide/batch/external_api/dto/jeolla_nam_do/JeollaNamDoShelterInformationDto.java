package com.slcube.shelter_guide.batch.external_api.dto.jeolla_nam_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JeollaNamDoShelterInformationDto {

    private int currentCount;

    @JsonProperty("data")
    private List<JeollaNamDoShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
