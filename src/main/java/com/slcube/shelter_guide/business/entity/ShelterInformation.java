package com.slcube.shelter_guide.business.entity;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ShelterInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String managementNumber;
    private String licenseDate;
    private String businessStatusCode;
    private String businessStatusName;
    private String detailedBusinessStatusCode;
    private String detailedBusinessStatusName;
    private String closingDate;
    private Double positionX;
    private Double positionY;
    private Double locationArea;
    private String locationPostalCode;
    private String landNumberAddress;
    private String roadNameAddress;
    private String roadNamePostalCode;
    private String lastModifiedDate;

    @Builder
    private ShelterInformation(String managementNumber, String licenseDate, String businessStatusCode, String businessStatusName,
                               String detailedBusinessStatusCode, String detailedBusinessStatusName, String closingDate,
                               Double positionX, Double positionY, Double locationArea, String locationPostalCode,
                               String landNumberAddress, String roadNameAddress, String roadNamePostalCode, String lastModifiedDate) {
        this.managementNumber = managementNumber;
        this.licenseDate = licenseDate;
        this.businessStatusCode = businessStatusCode;
        this.businessStatusName = businessStatusName;
        this.detailedBusinessStatusCode = detailedBusinessStatusCode;
        this.detailedBusinessStatusName = detailedBusinessStatusName;
        this.closingDate = closingDate;
        this.positionX = positionX;
        this.positionY = positionY;
        this.locationArea = locationArea;
        this.locationPostalCode = locationPostalCode;
        this.landNumberAddress = landNumberAddress;
        this.roadNameAddress = roadNameAddress;
        this.roadNamePostalCode = roadNamePostalCode;
        this.lastModifiedDate = lastModifiedDate;
    }

    public void update(ShelterInformationStaging shelterInformationStaging) {
        this.managementNumber = shelterInformationStaging.getManagementNumber();
        this.licenseDate = shelterInformationStaging.getLicenseDate();
        this.businessStatusCode = shelterInformationStaging.getBusinessStatusCode();
        this.businessStatusName = shelterInformationStaging.getBusinessStatusName();
        this.detailedBusinessStatusCode = shelterInformationStaging.getDetailedBusinessStatusCode();
        this.detailedBusinessStatusName = shelterInformationStaging.getDetailedBusinessStatusName();
        this.closingDate = shelterInformationStaging.getClosingDate();
        this.positionX = shelterInformationStaging.getPositionX();
        this.positionY = shelterInformationStaging.getPositionY();
        this.locationArea = shelterInformationStaging.getLocationArea();
        this.locationPostalCode = shelterInformationStaging.getLocationPostalCode();
        this.landNumberAddress = shelterInformationStaging.getLandNumberAddress();
        this.roadNameAddress = shelterInformationStaging.getRoadNameAddress();
        this.roadNamePostalCode = shelterInformationStaging.getRoadNamePostalCode();
        this.lastModifiedDate = shelterInformationStaging.getLastModifiedDate();
    }
}