package com.slcube.shelter_guide.batch.external_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShelterInformationDto {

    private String municipalityCode;

    private String managementNumber;

    private String licenseDate;

    private String licenseCancellationDate;

    private String businessStatusCode;

    private String businessStatusName;

    private String detailedBusinessStatusCode;

    private String detailedBusinessStatusName;

    private String closingDate;

    private String closedStartDate;

    private String closedEndDate;

    private String reopeningDate;

    private String phoneNumber;

    private double locationArea;

    private String locationPostalCode;

    private String landNumberAddress;

    private String roadNameAddress;

    private String roadNamePostalCode;

    private String businessEstablishmentName;

    private String lastModifiedDate;

    private String dataUpdateCode;

    private String dataUpdateDate;

    private double positionX;

    private double positionY;

    private String emergencyFacilityLocation;

    private String facilitiesDefinitionName;

    private String facilityBuildingName;

    private String releaseDate;
}
