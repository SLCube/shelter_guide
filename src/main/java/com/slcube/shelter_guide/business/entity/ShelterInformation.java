package com.slcube.shelter_guide.business.entity;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ShelterInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessStatusCode;

    private String businessStatusName;

    private String closingDate;

    private double locationArea;

    private String locationPostalCode;

    private String landNumberAddress;

    private String roadNameAddress;

    private String roadNamePostalCode;

    private String businessEstablishmentName;

    @Builder
    private ShelterInformation(String businessStatusCode, String businessStatusName, String closingDate,
                               double locationArea, String locationPostalCode, String landNumberAddress,
                               String roadNameAddress, String roadNamePostalCode, String businessEstablishmentName) {
        this.businessStatusCode = businessStatusCode;
        this.businessStatusName = businessStatusName;
        this.closingDate = closingDate;
        this.locationArea = locationArea;
        this.locationPostalCode = locationPostalCode;
        this.landNumberAddress = landNumberAddress;
        this.roadNameAddress = roadNameAddress;
        this.roadNamePostalCode = roadNamePostalCode;
        this.businessEstablishmentName = businessEstablishmentName;
    }

    public void update(ShelterInformationStaging shelterInformationStaging) {
        this.businessStatusCode = shelterInformationStaging.getBusinessStatusCode();
        this.businessStatusName = shelterInformationStaging.getBusinessStatusName();
        this.closingDate = shelterInformationStaging.getClosingDate();
        this.locationArea = shelterInformationStaging.getLocationArea();
        this.locationPostalCode = shelterInformationStaging.getLocationPostalCode();
        this.landNumberAddress = shelterInformationStaging.getLandNumberAddress();
        this.roadNameAddress = shelterInformationStaging.getRoadNameAddress();
        this.roadNamePostalCode = shelterInformationStaging.getRoadNamePostalCode();
        this.businessEstablishmentName = shelterInformationStaging.getBusinessEstablishmentName();
    }

    public boolean areEqual(ShelterInformationStaging shelterInformationStaging) {
        return this.businessStatusCode.equals(shelterInformationStaging.getBusinessStatusCode())
                && this.businessStatusName.equals(shelterInformationStaging.getBusinessStatusName())
                && this.closingDate.equals(shelterInformationStaging.getClosingDate())
                && this.locationArea == shelterInformationStaging.getLocationArea()
                && this.locationPostalCode.equals(shelterInformationStaging.getLocationPostalCode())
                && this.landNumberAddress.equals(shelterInformationStaging.getLandNumberAddress())
                && this.roadNameAddress.equals(shelterInformationStaging.getRoadNameAddress())
                && this.roadNamePostalCode.equals(shelterInformationStaging.getRoadNameAddress());
    }
}
