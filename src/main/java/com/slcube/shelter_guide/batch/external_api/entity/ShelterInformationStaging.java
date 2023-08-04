package com.slcube.shelter_guide.batch.external_api.entity;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
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
    private String managementNumber;

    @Column(nullable = false)
    private String licenseDate;

    @Column(nullable = false)
    private String businessStatusCode;

    @Column(nullable = false)
    private String businessStatusName;

    @Column(nullable = false)
    private String detailedBusinessStatusCode;

    @Column(nullable = false)
    private String detailedBusinessStatusName;

    @Column(nullable = false)
    private String closingDate;

    private double positionX;

    private double positionY;

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
    private String lastModifiedDate;

    @Builder
    private ShelterInformationStaging(String managementNumber, String licenseDate, String businessStatusCode,
                                      String businessStatusName, String detailedBusinessStatusCode, String detailedBusinessStatusName,
                                      String closingDate, double positionX, double positionY, double locationArea, String locationPostalCode,
                                      String landNumberAddress, String roadNameAddress, String roadNamePostalCode, String lastModifiedDate) {
        this.managementNumber = managementNumber != null ? managementNumber : "";
        this.licenseDate = licenseDate != null ? licenseDate : "";
        this.businessStatusCode = businessStatusCode != null ? businessStatusCode : "";
        this.businessStatusName = businessStatusName != null ? businessStatusName : "";
        this.detailedBusinessStatusCode = detailedBusinessStatusCode != null ? detailedBusinessStatusCode : "";
        this.detailedBusinessStatusName = detailedBusinessStatusName != null ? detailedBusinessStatusName : "";
        this.closingDate = closingDate != null ? closingDate : "";
        this.positionX = positionX;
        this.positionY = positionY;
        this.locationArea = locationArea;
        this.locationPostalCode = locationPostalCode != null ? locationPostalCode : "";
        this.landNumberAddress = landNumberAddress != null ? landNumberAddress : "";
        this.roadNameAddress = roadNameAddress != null ? roadNameAddress : "";
        this.roadNamePostalCode = roadNamePostalCode != null ? roadNamePostalCode : "";
        this.lastModifiedDate = lastModifiedDate != null ? lastModifiedDate : "";
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
