package com.slcube.shelter_guide.batch.external_api.dto.jeolla_buk_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JeollaBukDoShelterInformationDto {

    private int currentCount;

    @JsonProperty("data")
    private List<JeollaBukDoShelterInformationResultDataDto> resultDtoList = new ArrayList<>();
}
