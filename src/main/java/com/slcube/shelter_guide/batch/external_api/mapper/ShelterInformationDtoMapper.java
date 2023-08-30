package com.slcube.shelter_guide.batch.external_api.mapper;

import com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi.GyeongGiShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationDtoMapper {

    public static ShelterInformationDto toDto(SeoulShelterInformationResultDataDto seoulShelterInformationResultDataDto) {
        return ShelterInformationDto.builder()
                .municipalityCode(seoulShelterInformationResultDataDto.getMunicipalityCode())
                .managementNumber(seoulShelterInformationResultDataDto.getManagementNumber())
                .licenseDate(seoulShelterInformationResultDataDto.getLicenseDate())
                .licenseCancellationDate(seoulShelterInformationResultDataDto.getLicenseCancellationDate())
                .businessStatusCode(seoulShelterInformationResultDataDto.getBusinessStatusCode())
                .businessStatusName(seoulShelterInformationResultDataDto.getBusinessStatusName())
                .detailedBusinessStatusCode(seoulShelterInformationResultDataDto.getDetailedBusinessStatusCode())
                .detailedBusinessStatusName(seoulShelterInformationResultDataDto.getDetailedBusinessStatusName())
                .closingDate(seoulShelterInformationResultDataDto.getClosingDate())
                .closedStartDate(seoulShelterInformationResultDataDto.getClosedStartDate())
                .reopeningDate(seoulShelterInformationResultDataDto.getReopeningDate())
                .phoneNumber(seoulShelterInformationResultDataDto.getPhoneNumber())
                .locationArea(seoulShelterInformationResultDataDto.getLocationArea())
                .locationPostalCode(seoulShelterInformationResultDataDto.getLocationPostalCode())
                .landNumberAddress(seoulShelterInformationResultDataDto.getLandNumberAddress())
                .roadNameAddress(seoulShelterInformationResultDataDto.getRoadNameAddress())
                .roadNamePostalCode(seoulShelterInformationResultDataDto.getRoadNamePostalCode())
                .businessEstablishmentName(seoulShelterInformationResultDataDto.getBusinessEstablishmentName())
                .lastModifiedDate(seoulShelterInformationResultDataDto.getLastModifiedDate())
                .dataUpdateCode(seoulShelterInformationResultDataDto.getDataUpdateCode())
                .dataUpdateDate(seoulShelterInformationResultDataDto.getDataUpdateDate())
                .positionX(seoulShelterInformationResultDataDto.getPositionX())
                .positionY(seoulShelterInformationResultDataDto.getPositionY())
                .emergencyFacilityLocation(seoulShelterInformationResultDataDto.getEmergencyFalicityLocation())
                .facilitiesDefinitionName(seoulShelterInformationResultDataDto.getFacilitiesDefinitionName())
                .facilityBuildingName(seoulShelterInformationResultDataDto.getFacilityBuildingName())
                .releaseDate(seoulShelterInformationResultDataDto.getReleaseDate())
                .build();
    }

    public static ShelterInformationDto toDto(GyeongGiShelterInformationResultDataDto gyeongGiShelterInformationResultDataDto) {
        return null;
    }
}
