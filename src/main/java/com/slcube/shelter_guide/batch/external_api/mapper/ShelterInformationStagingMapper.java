package com.slcube.shelter_guide.batch.external_api.mapper;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationStagingMapper {

    public static ShelterInformationStaging toEntity(ShelterInformationDto shelterInformationDto) {
        return ShelterInformationStaging.builder()
                .managementNumber(shelterInformationDto.getManagementNumber())
                .licenseDate(shelterInformationDto.getLicenseDate())
                .businessStatusCode(shelterInformationDto.getBusinessStatusCode())
                .businessStatusName(shelterInformationDto.getBusinessStatusName())
                .detailedBusinessStatusCode(shelterInformationDto.getDetailedBusinessStatusCode())
                .detailedBusinessStatusName(shelterInformationDto.getDetailedBusinessStatusName())
                .closingDate(shelterInformationDto.getClosingDate())
                .positionX(shelterInformationDto.getPositionX())
                .positionY(shelterInformationDto.getPositionY())
                .locationArea(shelterInformationDto.getLocationArea())
                .landNumberAddress(shelterInformationDto.getLandNumberAddress())
                .roadNameAddress(shelterInformationDto.getRoadNameAddress())
                .roadNamePostalCode(shelterInformationDto.getRoadNamePostalCode())
                .lastModifiedDate(shelterInformationDto.getLastModifiedDate())
                .build();
    }
}
