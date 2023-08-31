package com.slcube.shelter_guide.batch.external_api.mapper;

import com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi.GyeongGiShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationDtoMapper {

    public static ShelterInformationDto toDto(SeoulShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .municipalityCode(dto.getMunicipalityCode())
                .managementNumber(dto.getManagementNumber())
                .licenseDate(dto.getLicenseDate())
                .licenseCancellationDate(dto.getLicenseCancellationDate())
                .businessStatusCode(dto.getBusinessStatusCode())
                .businessStatusName(dto.getBusinessStatusName())
                .detailedBusinessStatusCode(dto.getDetailedBusinessStatusCode())
                .detailedBusinessStatusName(dto.getDetailedBusinessStatusName())
                .closingDate(dto.getClosingDate())
                .closedStartDate(dto.getClosedStartDate())
                .reopeningDate(dto.getReopeningDate())
                .phoneNumber(dto.getPhoneNumber())
                .locationArea(dto.getLocationArea())
                .locationPostalCode(dto.getLocationPostalCode())
                .landNumberAddress(dto.getLandNumberAddress())
                .roadNameAddress(dto.getRoadNameAddress())
                .roadNamePostalCode(dto.getRoadNamePostalCode())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .lastModifiedDate(dto.getLastModifiedDate())
                .dataUpdateCode(dto.getDataUpdateCode())
                .dataUpdateDate(dto.getDataUpdateDate())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .emergencyFacilityLocation(dto.getEmergencyFalicityLocation())
                .facilitiesDefinitionName(dto.getFacilitiesDefinitionName())
                .facilityBuildingName(dto.getFacilityBuildingName())
                .releaseDate(dto.getReleaseDate())
                .build();
    }

    public static ShelterInformationDto toDto(GyeongGiShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .managementNumber(dto.getManagementNumber())
                .licenseDate(dto.getLicenseDate())
                .licenseCancellationDate(dto.getLicenseCancellationDate())
                .businessStatusCode(dto.getBusinessStatusCode())
                .businessStatusName(dto.getBusinessStatusName())
                .detailedBusinessStatusCode(dto.getDetailedBusinessStatusCode())
                .detailedBusinessStatusName(dto.getDetailedBusinessStatusName())
                .closingDate(dto.getClosingDate())
                .closedStartDate(dto.getClosedStartDate())
                .closedEndDate(dto.getClosedEndDate())
                .reopeningDate(dto.getReopeningDate())
                .locationArea(dto.getLocationArea())
                .locationPostalCode(dto.getLocationPostalCode())
                .landNumberAddress(dto.getLandNumberAddress())
                .roadNameAddress(dto.getRoadNameAddress())
                .roadNamePostalCode(dto.getRoadNamePostalCode())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .lastModifiedDate(dto.getLastModifiedDate())
                .dataUpdateCode(dto.getDataUpdateCode())
                .dataUpdateDate(dto.getDataUpdateDate())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .emergencyFacilityLocation(dto.getEmergencyFalicityLocation())
                .facilitiesDefinitionName(dto.getFacilitiesDefinitionName())
                .facilityBuildingName(dto.getFacilityBuildingName())
                .releaseDate(dto.getReleaseDate())
                .build();
    }
}
