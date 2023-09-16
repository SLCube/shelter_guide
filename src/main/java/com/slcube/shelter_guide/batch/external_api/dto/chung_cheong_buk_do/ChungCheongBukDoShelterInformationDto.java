package com.slcube.shelter_guide.batch.external_api.dto.chung_cheong_buk_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ChungCheongBukDoShelterInformationDto {

    @JsonProperty("body")
    private List<ChungCheongBukDoShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
