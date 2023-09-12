package com.slcube.shelter_guide.batch.external_api.dto.chung_cheong_buk_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ChungCheongBukDoShelterInformationResultDataDto {

    @JsonProperty("FCLTY_NM")
    private String businessEstablishmentName;

    @JsonProperty("DETAIL_ADRES")
    private String roadNameAddress;

    @JsonProperty("FCLTY_AR")
    private double locationArea;

    @JsonProperty("MSFRTNCNTRMSRZONE_SE")
    private String disasterResponseAreaType;
}
