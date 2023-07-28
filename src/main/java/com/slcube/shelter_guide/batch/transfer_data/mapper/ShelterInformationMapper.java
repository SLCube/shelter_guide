package com.slcube.shelter_guide.batch.transfer_data.mapper;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationMapper {

    public static ShelterInformation toEntity(ShelterInformationStaging shelterInformationStaging) {
        return ShelterInformation.builder()
                .managementNumber(shelterInformationStaging.getManagementNumber())
                .licenseDate(shelterInformationStaging.getLicenseDate())
                .businessStatusCode(shelterInformationStaging.getBusinessStatusCode())
                .businessStatusName(shelterInformationStaging.getBusinessStatusName())
                .detailedBusinessStatusCode(shelterInformationStaging.getDetailedBusinessStatusCode())
                .detailedBusinessStatusName(shelterInformationStaging.getDetailedBusinessStatusName())
                .closingDate(shelterInformationStaging.getClosingDate())
                .positionX(shelterInformationStaging.getPositionX())
                .positionY(shelterInformationStaging.getPositionY())
                .locationArea(shelterInformationStaging.getLocationArea())
                .locationPostalCode(shelterInformationStaging.getLocationPostalCode())
                .landNumberAddress(shelterInformationStaging.getLandNumberAddress())
                .roadNameAddress(shelterInformationStaging.getRoadNameAddress())
                .roadNamePostalCode(shelterInformationStaging.getRoadNamePostalCode())
                .lastModifiedDate(shelterInformationStaging.getLastModifiedDate())
                .build();
    }
}
