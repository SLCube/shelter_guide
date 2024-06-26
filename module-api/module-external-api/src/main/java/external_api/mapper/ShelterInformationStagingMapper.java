package external_api.mapper;

import domain.ShelterInformationStaging;
import external_api.dto.ShelterInformationDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationStagingMapper {

    public static ShelterInformationStaging toEntity(ShelterInformationDto shelterInformationDto) {
        return ShelterInformationStaging.builder()
                .businessStatusCode(shelterInformationDto.getBusinessStatusCode())
                .businessStatusName(shelterInformationDto.getBusinessStatusName())
                .businessEstablishmentName(shelterInformationDto.getBusinessEstablishmentName())
                .closingDate(shelterInformationDto.getClosingDate())
                .locationArea(shelterInformationDto.getLocationArea())
                .landNumberAddress(shelterInformationDto.getLandNumberAddress())
                .locationPostalCode(shelterInformationDto.getLocationPostalCode())
                .roadNameAddress(shelterInformationDto.getRoadNameAddress())
                .roadNamePostalCode(shelterInformationDto.getRoadNamePostalCode())
                .build();
    }
}
