package com.slcube.shelter_guide.batch.transfer_data.mapper;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationMapper {

    public static ShelterInformation toEntity(ShelterInformationStaging shelterInformationStaging) {
        return ShelterInformation.builder()
                .businessStatusCode(shelterInformationStaging.getBusinessStatusCode())
                .businessStatusName(shelterInformationStaging.getBusinessStatusName())
                .closingDate(shelterInformationStaging.getClosingDate())
                .locationArea(shelterInformationStaging.getLocationArea())
                .locationPostalCode(shelterInformationStaging.getLocationPostalCode())
                .landNumberAddress(shelterInformationStaging.getLandNumberAddress())
                .roadNameAddress(shelterInformationStaging.getRoadNameAddress())
                .roadNamePostalCode(shelterInformationStaging.getRoadNamePostalCode())
                .build();
    }
}
