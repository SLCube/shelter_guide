package com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GyeongGiShelterInformationResultDataDto {

    @JsonProperty("MANAGE_ID")
    private String managementNumber;

    @JsonProperty("LICENSG_DE")
    private String licenseDate;

    @JsonProperty("LICENSG_CANCL_DE")
    private String licenseCancellationDate;

    @JsonProperty("UNITY_BSN_STATE_DIV_CD")
    private String businessStatusCode;

    @JsonProperty("UNITY_BSN_STATE_NM")
    private String businessStatusName;

    @JsonProperty("BSN_STATE_DIV")
    private String detailedBusinessStatusCode;

    @JsonProperty("BSN_STATE_NM")
    private String detailedBusinessStatusName;

    @JsonProperty("CLSBIZ_DE")
    private String closingDate;

    @JsonProperty("SUSPNBIZ_BEGIN_DE")
    private String closedStartDate;

    @JsonProperty("SUSPNBIZ_END_DE")
    private String closedEndDate;

    @JsonProperty("REOPENBIZ_DE")
    private String reopeningDate;

    @JsonProperty("LOCPLC_AR_INFO")
    private double locationArea;

    @JsonProperty("LOCPLC_ZIPNO")
    private String locationPostalCode;

    @JsonProperty("LOCPLC_LOTNO_ADDR")
    private String landNumberAddress;

    @JsonProperty("LOCPLC_ROADNM_ADDR")
    private String roadNameAddress;

    @JsonProperty("ROADNM_ZIPNO")
    private String roadNamePostalCode;

    @JsonProperty("BIZPLC_NM")
    private String businessEstablishmentName;

    @JsonProperty("LAST_UPD_TM")
    private String  lastModifiedDate;

    @JsonProperty("DATA_UPDT_DIV_CD")
    private String dataUpdateCode;

    @JsonProperty("DATA_UPDT_TM")
    private String  dataUpdateDate;

    @JsonProperty("X_CRDNT_VL")
    private double positionX;

    @JsonProperty("Y_CRDNT_VL")
    private double positionY;

    @JsonProperty("EMGNCY_FACLT_LOC")
    private String emergencyFalicityLocation;

    @JsonProperty("FACLT_DIV_NM")
    private String facilitiesDefinitionName;

    @JsonProperty("FACLT_NM_BULDNG_NM_INFO")
    private String facilityBuildingName;

    @JsonProperty("RLSE_DE")
    private String releaseDate;
}
