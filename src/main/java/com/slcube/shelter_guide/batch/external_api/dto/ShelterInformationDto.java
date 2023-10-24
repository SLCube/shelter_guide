package com.slcube.shelter_guide.batch.external_api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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

    @Builder
    public ShelterInformationDto(String municipalityCode, String businessStatusCode, String businessStatusName,
                                 String closingDate, String phoneNumber, double locationArea,
                                 String locationPostalCode, String landNumberAddress, String roadNameAddress,
                                 String roadNamePostalCode, String businessEstablishmentName) {
        this.municipalityCode = municipalityCode != null ? municipalityCode : "";
        this.businessStatusCode = businessStatusCode != null ? businessStatusCode : "";
        this.businessStatusName = businessStatusName != null ? businessStatusName : "";
        this.closingDate = closingDate != null ? closingDate : "";
        this.phoneNumber = phoneNumber != null ? phoneNumber : "";
        this.locationArea = locationArea;
        this.locationPostalCode = locationPostalCode != null ? locationPostalCode : "";
        this.landNumberAddress = landNumberAddress != null ? landNumberAddress : "";
        this.roadNameAddress = roadNameAddress != null? roadNameAddress : "";
        this.roadNamePostalCode = roadNamePostalCode != null ? roadNamePostalCode : "";
        this.businessEstablishmentName = businessEstablishmentName != null ? businessEstablishmentName : "";
    }
}
