package com.slcube.shelter_guide.batch.external_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SeoulShelterInformationResultDto {

    @JsonProperty("list_total_count")
    private int listTotalCount;

    @JsonProperty("RESULT")
    private SeoulShelterInformationResultCodeDto resultCodeDto;

    @JsonProperty("row")
    private List<SeoulShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
