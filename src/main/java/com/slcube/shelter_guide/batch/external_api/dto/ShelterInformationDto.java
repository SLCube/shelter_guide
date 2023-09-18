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

    private String businessStatusCode;

    private String businessStatusName;

    private String closingDate;

    private String phoneNumber;

    private double locationArea;

    private String locationPostalCode;

    private String landNumberAddress;

    private String roadNameAddress;

    private String roadNamePostalCode;

    private String businessEstablishmentName;
}
