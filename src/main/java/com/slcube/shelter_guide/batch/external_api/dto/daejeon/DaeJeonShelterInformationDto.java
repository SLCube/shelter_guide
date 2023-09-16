package com.slcube.shelter_guide.batch.external_api.dto.daejeon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DaeJeonShelterInformationDto {

    private int currentCount;

    @JsonProperty("data")
    private List<DaeJeonShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
