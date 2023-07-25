package com.slcube.shelter_guide.batch.entity;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
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
public class ShelterInformationStaging {

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
    private ShelterInformationStaging(String managementNumber, String licenseDate, String businessStatusCode,
                                      String businessStatusName, String detailedBusinessStatusCode, String detailedBusinessStatusName,
                                      String closingDate, Double positionX, Double positionY, Double locationArea, String locationPostalCode,
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

    public void update(SeoulShelterInformationResultDataDto dto) {
        this.managementNumber = dto.getManagementNumber();
        this.licenseDate = dto.getLicenseDate();
        this.businessStatusCode = dto.getBusinessStatusCode();
        this.businessStatusName = dto.getBusinessStatusName();
        this.detailedBusinessStatusCode = dto.getDetailedBusinessStatusCode();
        this.detailedBusinessStatusName = dto.getDetailedBusinessStatusName();
        this.closingDate = dto.getClosingDate();
        this.positionX = dto.getPositionX();
        this.positionY = dto.getPositionY();
        this.locationArea = dto.getLocationArea();
        this.lastModifiedDate = dto.getLastModifiedDate();
    }
}
