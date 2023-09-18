package com.slcube.shelter_guide.batch.external_api.entity;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ShelterInformationStaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessStatusCode;

    @Column(nullable = false)
    private String businessStatusName;

    @Column(nullable = false)
    private String closingDate;

    private double locationArea;

    @Column(nullable = false)
    private String locationPostalCode;

    @Column(nullable = false)
    private String landNumberAddress;

    @Column(nullable = false)
    private String roadNameAddress;

    @Column(nullable = false)
    private String roadNamePostalCode;

    @Column(nullable = false)
    private String businessEstablishmentName;

    @Builder
    private ShelterInformationStaging(String businessStatusCode, String businessStatusName, String closingDate,
                                      double locationArea, String locationPostalCode, String landNumberAddress,
                                      String roadNameAddress, String roadNamePostalCode, String businessEstablishmentName) {
        this.businessStatusCode = businessStatusCode != null ? businessStatusCode : "";
        this.businessStatusName = businessStatusName != null ? businessStatusName : "";
        this.closingDate = closingDate != null ? closingDate : "";
        this.locationArea = locationArea;
        this.locationPostalCode = locationPostalCode != null ? locationPostalCode : "";
        this.landNumberAddress = landNumberAddress != null ? landNumberAddress : "";
        this.roadNameAddress = roadNameAddress != null ? roadNameAddress : "";
        this.roadNamePostalCode = roadNamePostalCode != null ? roadNamePostalCode : "";
        this.businessEstablishmentName = businessEstablishmentName != null ? businessEstablishmentName : "";
    }

    public void update(ShelterInformationDto dto) {
        this.businessStatusCode = dto.getBusinessStatusCode();
        this.businessStatusName = dto.getBusinessStatusName();
        this.closingDate = dto.getClosingDate();
        this.locationArea = dto.getLocationArea();
        this.locationPostalCode = dto.getLocationPostalCode();
        this.landNumberAddress = dto.getLandNumberAddress();
        this.roadNameAddress = dto.getRoadNameAddress();
        this.roadNamePostalCode = dto.getRoadNamePostalCode();
        this.businessEstablishmentName = dto.getBusinessEstablishmentName();
    }

    public boolean areEqual(ShelterInformationDto dto) {
        return this.businessStatusCode.equals(dto.getBusinessStatusCode())
                && this.businessStatusName.equals(dto.getBusinessStatusName())
                && this.closingDate.equals(dto.getClosingDate())
                && this.locationArea == dto.getLocationArea()
                && this.locationPostalCode.equals(dto.getLocationPostalCode())
                && this.landNumberAddress.equals(dto.getLandNumberAddress())
                && this.roadNameAddress.equals(dto.getRoadNameAddress())
                && this.roadNamePostalCode.equals(dto.getRoadNamePostalCode());
    }
}
