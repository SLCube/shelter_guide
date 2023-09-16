package com.slcube.shelter_guide.batch.external_api.dto.in_cheon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InCheonShelterInformationDto {

    @JsonProperty("data")
    private List<InCheonShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
