package com.slcube.shelter_guide.batch.mapper;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.entity.ShelterInformationStaging;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationMapper {
    public static ShelterInformationStaging toEntity(SeoulShelterInformationResultDataDto shelterInformationDto) {
        return ShelterInformationStaging.builder()
                .managementNumber(shelterInformationDto.getLandNumberAddress())
                .licenseDate(shelterInformationDto.getLicenseDate())
                .businessStatusCode(shelterInformationDto.getBusinessStatusCode())
                .businessStatusName(shelterInformationDto.getBusinessStatusName())
                .detailedBusinessStatusCode(shelterInformationDto.getDetailedBusinessStatusCode())
                .detailedBusinessStatusName(shelterInformationDto.getDetailedBusinessStatusName())
                .closingDate(shelterInformationDto.getClosingDate())
                .positionX(shelterInformationDto.getPositionX())
                .positionY(shelterInformationDto.getPositionY())
                .lastModifiedDate(shelterInformationDto.getLastModifiedDate())
                .build();
    }
}
