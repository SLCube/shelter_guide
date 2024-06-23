package batch.transfer_data.mapper;

import domain.ShelterInformation;
import domain.ShelterInformationStaging;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationMapper {

    public static ShelterInformation toEntity(ShelterInformationStaging shelterInformationStaging) {
        return ShelterInformation.builder()
                .businessStatusCode(shelterInformationStaging.getBusinessStatusCode())
                .businessStatusName(shelterInformationStaging.getBusinessStatusName())
                .businessEstablishmentName(shelterInformationStaging.getBusinessEstablishmentName())
                .closingDate(shelterInformationStaging.getClosingDate())
                .locationArea(shelterInformationStaging.getLocationArea())
                .locationPostalCode(shelterInformationStaging.getLocationPostalCode())
                .landNumberAddress(shelterInformationStaging.getLandNumberAddress())
                .roadNameAddress(shelterInformationStaging.getRoadNameAddress())
                .roadNamePostalCode(shelterInformationStaging.getRoadNamePostalCode())
                .build();
    }
}
