package com.slcube.shelter_guide.batch.external_api.comparator;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationStagingComparator {

    public static boolean areEqual(SeoulShelterInformationResultDataDto dto, ShelterInformationStaging shelterInformationStaging) {
        return dto.getManagementNumber().equals(shelterInformationStaging.getManagementNumber())
                && dto.getLicenseDate().equals(shelterInformationStaging.getLicenseDate())
                && dto.getBusinessStatusCode().equals(shelterInformationStaging.getBusinessStatusCode())
                && dto.getBusinessStatusName().equals(shelterInformationStaging.getBusinessStatusName())
                && dto.getDetailedBusinessStatusCode().equals(shelterInformationStaging.getDetailedBusinessStatusCode())
                && dto.getDetailedBusinessStatusName().equals(shelterInformationStaging.getDetailedBusinessStatusName())
                && dto.getClosingDate().equals(shelterInformationStaging.getClosingDate())
                && dto.getPositionX() == shelterInformationStaging.getPositionX()
                && dto.getPositionY() == shelterInformationStaging.getPositionY()
                && dto.getLocationArea() == shelterInformationStaging.getLocationArea()
                && dto.getLocationPostalCode().equals(shelterInformationStaging.getLocationPostalCode())
                && dto.getLandNumberAddress().equals(shelterInformationStaging.getLandNumberAddress())
                && dto.getRoadNameAddress().equals(shelterInformationStaging.getRoadNameAddress())
                && dto.getRoadNamePostalCode().equals(shelterInformationStaging.getRoadNamePostalCode())
                && dto.getLastModifiedDate().equals(shelterInformationStaging.getLastModifiedDate());
    }
}
