package com.slcube.shelter_guide.batch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SeoulShelterInformationResultDataDto {

    @JsonProperty("OPNSFTEAMCODE")
    private String municipalityCode;

    @JsonProperty("MGTNO")
    private String managementNumber;

    @JsonProperty("APVPERMYMD")
    private LocalDate licenseDate;

    @JsonProperty("APVCANCELYMD")
    private String licenseCancellationDate;

    @JsonProperty("TRDSTATEGBN")
    private String businessStatusCode;

    @JsonProperty("TRDSTATENM")
    private String businessStatusName;

    @JsonProperty("DTLSTATEGBN")
    private String detailedBusinessStatusCode;

    @JsonProperty("DTLSTATENM")
    private String detailedBusinessStatusName;

    @JsonProperty("DCBYMD")
    private LocalDate closingDate;

    @JsonProperty("CLGSTDT")
    private String closedStartDate;

    @JsonProperty("CLGENDDT")
    private String closedEndDate;

    @JsonProperty("ROPNYMD")
    private String reopeningDate;

    @JsonProperty("SITETEL")
    private String phoneNumber;

    @JsonProperty("SITEAREA")
    private Double locationArea;

    @JsonProperty("SITEPOSTNO")
    private String locationPostalCode;

    @JsonProperty("SITEWHLADDR")
    private String landNumberAddress;

    @JsonProperty("RDNWHLADDR")
    private String roadNameAddress;

    @JsonProperty("RDNPOSTNO")
    private String roadNamePostalCode;

    @JsonProperty("BPLCNM")
    private String businessEstablishmentName;

    @JsonProperty("LASTMODTS")
    private String  lastModifiedDate;

    @JsonProperty("UPDATEGBN")
    private String dataUpdateCode;

    @JsonProperty("UPDATEDT")
    private String  dataUpdateDate;

    @JsonProperty("X")
    private Double positionX;

    @JsonProperty("Y")
    private Double positionY;

    @JsonProperty("EMERFACILLOC")
    private String emergencyFalicityLocation;

    @JsonProperty("FACILSENM")
    private String facilitiesDefinitionName;

    @JsonProperty("FACILNMBDNGNM")
    private String facilityBuildingName;

    @JsonProperty("DSVYMD")
    private String releaseDate;
}
