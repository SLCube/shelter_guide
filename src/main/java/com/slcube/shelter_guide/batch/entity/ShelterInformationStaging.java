package com.slcube.shelter_guide.batch.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShelterInformationStaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String managementNumber;
    private LocalDate licenseDate;
    private String businessStatusCode;
    private String businessStatusName;
    private String detailedBusinessStatusCode;
    private String detailedBusinessStatusName;
    private LocalDate closingDate;
    private Double positionX;
    private Double positionY;
    private Double locationArea;
    private String lastModifiedDate;

    @Builder
    private ShelterInformationStaging(String managementNumber, LocalDate licenseDate, String businessStatusCode,
                                      String businessStatusName, String detailedBusinessStatusCode, String detailedBusinessStatusName,
                                      LocalDate closingDate, Double positionX, Double positionY, Double locationArea, String lastModifiedDate) {
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
        this.lastModifiedDate = lastModifiedDate;
    }
}
