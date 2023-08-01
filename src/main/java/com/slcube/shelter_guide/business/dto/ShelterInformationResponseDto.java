package com.slcube.shelter_guide.business.dto;

import com.slcube.shelter_guide.business.entity.ShelterInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShelterInformationResponseDto {

    private Long shelterInformationId;
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

    public ShelterInformationResponseDto(ShelterInformation shelterInformation) {
        this.shelterInformationId = shelterInformation.getId();
        this.managementNumber = shelterInformation.getManagementNumber();
        this.licenseDate = shelterInformation.getLicenseDate();
        this.businessStatusCode = shelterInformation.getBusinessStatusCode();
        this.businessStatusName = shelterInformation.getBusinessStatusName();
        this.detailedBusinessStatusCode = shelterInformation.getDetailedBusinessStatusCode();
        this.detailedBusinessStatusName = shelterInformation.getDetailedBusinessStatusName();
        this.closingDate = shelterInformation.getClosingDate();
        this.positionX = shelterInformation.getPositionX();
        this.positionY = shelterInformation.getPositionY();
        this.locationArea = shelterInformation.getLocationArea();
        this.locationPostalCode = shelterInformation.getLocationPostalCode();
        this.landNumberAddress = shelterInformation.getLandNumberAddress();
        this.roadNameAddress = shelterInformation.getRoadNameAddress();
        this.roadNamePostalCode = shelterInformation.getRoadNamePostalCode();
    }
}
