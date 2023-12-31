package com.slcube.shelter_guide.batch.external_api.dto.jeju;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JejuShelterInformationDto {

    @JsonProperty("data")
    private List<JejuShelterInformationResultDataDto> resultDataDtoList = new ArrayList<>();
}
