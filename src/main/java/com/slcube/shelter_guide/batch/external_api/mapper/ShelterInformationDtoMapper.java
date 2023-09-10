package com.slcube.shelter_guide.batch.external_api.mapper;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.dto.chung_cheong_nam_do.ChungCheongNamDoShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.daejeon.DaeJeonShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.gwang_ju.GwangJuShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.gyeong_gi.GyeongGiShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_buk_do.GyeongSangBukDoShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.in_cheon.InCheonShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeolla_buk_do.JeollaBukDoShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.jeolla_nam_do.JeollaNamDoShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.external_api.dto.seoul.SeoulShelterInformationResultDataDto;
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

    public static ShelterInformationDto toDto(JeollaBukDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .licenseDate(dto.getLicenseDate())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .locationArea(dto.getLocationArea())
                .roadNameAddress(dto.getRoadNameAddress())
                .landNumberAddress(dto.getLandNumberAddress())
                .build();
    }

    public static ShelterInformationDto toDto(GyeongSangBukDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .locationArea(dto.getLocationArea())
                .roadNameAddress(dto.getRoadNameAddress())
                .landNumberAddress(dto.getLandNumberAddress())
                .build();
    }

    public static ShelterInformationDto toDto(DaeJeonShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .locationArea(dto.getLocationArea())
                .roadNameAddress(dto.getRoadNameAddress())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .build();
    }

    public static ShelterInformationDto toDto(JeollaNamDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .roadNameAddress(dto.getRoadNameAddress())
                .locationArea(dto.getLocationArea())
                .build();
    }

    public static ShelterInformationDto toDto(InCheonShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .locationArea(dto.getLocationArea())
                .landNumberAddress(dto.getLandNumberAddress())
                .roadNameAddress(dto.getRoadNameAddress())
                .build();
    }

    public static ShelterInformationDto toDto(GwangJuShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .locationArea(dto.getLocationArea())
                .landNumberAddress(dto.getLandNumberAddress())
                .roadNameAddress(dto.getRoadNameAddress())
                .build();
    }

    public static ShelterInformationDto toDto(ChungCheongNamDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .landNumberAddress(dto.getLandNumberAddress())
                .roadNameAddress(dto.getRoadNameAddress())
                .locationArea(dto.getLocationArea())
                .build();
    }
}
