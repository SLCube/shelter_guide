package com.slcube.shelter_guide.batch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SeoulShelterInformationDto {

    @JsonProperty("LOCALDATA_114602")
    private ResultDto result;

    @Getter
    private static class ResultDto {

        @JsonProperty("list_total_count")
        private int listTotalCount;

        @JsonProperty("RESULT")
        private ResultCodeDto resultCodeDto;

        @JsonProperty("row")
        private List<ResultDataDto> resultDataDtoList = new ArrayList<>();
    }

    @Getter
    private static class ResultCodeDto {

        @JsonProperty("CODE")
        private String resultCode;

        @JsonProperty("MESSAGE")
        private String message;
    }

    @Getter
    private static class ResultDataDto {

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
        private String locationArea;

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
        private String lastModifiedDate;

        @JsonProperty("UPDATEGBN")
        private String dataUpdateCode;

        @JsonProperty("UPDATEDT")
        private String dataUpdateDate;

        @JsonProperty("X")
        private String positionX;

        @JsonProperty("Y")
        private String positionY;

        @JsonProperty("EMERFACILLOC")
        private String emergencyFalicityLocation;

        @JsonProperty("FACILSENM")
        private String facilitiesDefinitionName;

        @JsonProperty("FACILNMBDNGNM")
        private String facilityBuildingName;

        @JsonProperty("DSVYMD")
        private String releaseDate;
    }
}
