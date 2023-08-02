package com.slcube.shelter_guide.batch.external_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SeoulShelterInformationResultDataDto {

    @JsonProperty("OPNSFTEAMCODE")
    private String municipalityCode;

    @JsonProperty("MGTNO")
    private String managementNumber;

    @JsonProperty("APVPERMYMD")
    private String licenseDate;

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
    private String closingDate;

    @JsonProperty("CLGSTDT")
    private String closedStartDate;

    @JsonProperty("CLGENDDT")
    private String closedEndDate;

    @JsonProperty("ROPNYMD")
    private String reopeningDate;

    @JsonProperty("SITETEL")
    private String phoneNumber;

    @JsonProperty("SITEAREA")
    private double locationArea;

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
    private double positionX;

    @JsonProperty("Y")
    private double positionY;

    @JsonProperty("EMERFACILLOC")
    private String emergencyFalicityLocation;

    @JsonProperty("FACILSENM")
    private String facilitiesDefinitionName;

    @JsonProperty("FACILNMBDNGNM")
    private String facilityBuildingName;

    @JsonProperty("DSVYMD")
    private String releaseDate;
}
