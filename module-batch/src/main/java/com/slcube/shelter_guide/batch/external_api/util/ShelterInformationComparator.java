package com.slcube.shelter_guide.batch.external_api.util;

import com.slcube.shelter_guide.domain.ShelterInformation;
import com.slcube.shelter_guide.domain.ShelterInformationStaging;
import com.slcube.shelter_guide.external_api.dto.ShelterInformationDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationComparator {

    public static boolean compare(ShelterInformationStaging shelterInformationStaging, ShelterInformationDto shelterInformationDto) {
        return shelterInformationStaging.getBusinessStatusCode().equals(shelterInformationDto.getBusinessStatusCode())
                && shelterInformationStaging.getBusinessStatusName().equals(shelterInformationDto.getBusinessStatusName())
                && shelterInformationStaging.getClosingDate().equals(shelterInformationDto.getClosingDate())
                && shelterInformationStaging.getLocationArea() == shelterInformationDto.getLocationArea()
                && shelterInformationStaging.getLocationPostalCode().equals(shelterInformationDto.getLocationPostalCode())
                && shelterInformationStaging.getLandNumberAddress().equals(shelterInformationDto.getLandNumberAddress())
                && shelterInformationStaging.getRoadNameAddress().equals(shelterInformationDto.getRoadNameAddress())
                && shelterInformationStaging.getRoadNamePostalCode().equals(shelterInformationDto.getRoadNamePostalCode())
                && shelterInformationStaging.getBusinessEstablishmentName().equals(shelterInformationDto.getBusinessEstablishmentName());
    }

    public static boolean compare(ShelterInformation shelterInformation, ShelterInformationStaging shelterInformationStaging) {
        return shelterInformation.getBusinessStatusCode().equals(shelterInformationStaging.getBusinessStatusCode())
                && shelterInformation.getBusinessStatusName().equals(shelterInformationStaging.getBusinessStatusName())
                && shelterInformation.getClosingDate().equals(shelterInformationStaging.getClosingDate())
                && shelterInformation.getLocationArea() == shelterInformationStaging.getLocationArea()
                && shelterInformation.getLocationPostalCode().equals(shelterInformationStaging.getLocationPostalCode())
                && shelterInformation.getLandNumberAddress().equals(shelterInformationStaging.getLandNumberAddress())
                && shelterInformation.getRoadNameAddress().equals(shelterInformationStaging.getRoadNameAddress())
                && shelterInformation.getRoadNamePostalCode().equals(shelterInformationStaging.getRoadNamePostalCode())
                && shelterInformation.getBusinessEstablishmentName().equals(shelterInformationStaging.getBusinessEstablishmentName());
    }
}
