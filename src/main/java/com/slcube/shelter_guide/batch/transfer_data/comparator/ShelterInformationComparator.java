package com.slcube.shelter_guide.batch.transfer_data.comparator;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationComparator {

    public static boolean areEqual(ShelterInformationStaging shelterInformationStaging, ShelterInformation shelterInformation) {
        return shelterInformationStaging.getManagementNumber().equals(shelterInformation.getManagementNumber())
                && shelterInformationStaging.getLicenseDate().equals(shelterInformation.getLicenseDate())
                && shelterInformationStaging.getBusinessStatusCode().equals(shelterInformation.getBusinessStatusCode())
                && shelterInformationStaging.getBusinessStatusName().equals(shelterInformation.getBusinessStatusName())
                && shelterInformationStaging.getDetailedBusinessStatusCode().equals(shelterInformation.getDetailedBusinessStatusCode())
                && shelterInformationStaging.getDetailedBusinessStatusName().equals(shelterInformation.getDetailedBusinessStatusName())
                && shelterInformationStaging.getClosingDate().equals(shelterInformation.getClosingDate())
                && shelterInformationStaging.getPositionX().equals(shelterInformation.getPositionX())
                && shelterInformationStaging.getPositionY().equals(shelterInformation.getPositionY())
                && shelterInformationStaging.getLocationArea().equals(shelterInformation.getLocationArea())
                && shelterInformationStaging.getLocationPostalCode().equals(shelterInformation.getLocationPostalCode())
                && shelterInformationStaging.getLandNumberAddress().equals(shelterInformation.getLandNumberAddress())
                && shelterInformationStaging.getRoadNameAddress().equals(shelterInformation.getRoadNameAddress())
                && shelterInformationStaging.getRoadNamePostalCode().equals(shelterInformation.getRoadNamePostalCode())
                && shelterInformationStaging.getLastModifiedDate().equals(shelterInformation.getLastModifiedDate());
    }
}
