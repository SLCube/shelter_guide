package com.slcube.shelter_guide.batch.external_api.mapper;

import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationStagingMapper {

    public static ShelterInformationStaging toEntity(ShelterInformationDto shelterInformationDto) {
        return ShelterInformationStaging.builder()
                .businessStatusCode(shelterInformationDto.getBusinessStatusCode())
                .businessStatusName(shelterInformationDto.getBusinessStatusName())
                .closingDate(shelterInformationDto.getClosingDate())
                .locationArea(shelterInformationDto.getLocationArea())
                .landNumberAddress(shelterInformationDto.getLandNumberAddress())
                .roadNameAddress(shelterInformationDto.getRoadNameAddress())
                .roadNamePostalCode(shelterInformationDto.getRoadNamePostalCode())
                .build();
    }
}
