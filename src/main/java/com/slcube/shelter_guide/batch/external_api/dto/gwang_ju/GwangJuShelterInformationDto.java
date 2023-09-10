package com.slcube.shelter_guide.batch.external_api.dto.gwang_ju;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GwangJuShelterInformationDto {

    @JsonProperty("data")
    private List<GwangJuShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
