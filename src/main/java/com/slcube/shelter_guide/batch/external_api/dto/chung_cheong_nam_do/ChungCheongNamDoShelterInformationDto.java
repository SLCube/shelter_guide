package com.slcube.shelter_guide.batch.external_api.dto.chung_cheong_nam_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ChungCheongNamDoShelterInformationDto {

    @JsonProperty("data")
    private List<ChungCheongNamDoShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
