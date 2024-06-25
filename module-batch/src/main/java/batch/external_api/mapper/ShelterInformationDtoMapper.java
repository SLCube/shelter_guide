package batch.external_api.mapper;

import batch.external_api.dto.chung_cheong_buk_do.ChungCheongBukDoShelterInformationResultDataDto;
import batch.external_api.dto.chung_cheong_nam_do.ChungCheongNamDoShelterInformationResultDataDto;
import batch.external_api.dto.gwang_ju.GwangJuShelterInformationResultDataDto;
import batch.external_api.dto.gyeong_gi.GyeongGiShelterInformationResultDataDto;
import batch.external_api.dto.gyeong_sang_buk_do.GyeongSangBukDoShelterInformationResultDataDto;
import batch.external_api.dto.gyeong_sang_nam_do.GyeongSangNamDoShelterInformationResultDataDto;
import batch.external_api.dto.in_cheon.InCheonShelterInformationResultDataDto;
import batch.external_api.dto.jeju.JejuShelterInformationResultDataDto;
import batch.external_api.dto.jeolla_buk_do.JeollaBukDoShelterInformationResultDataDto;
import batch.external_api.dto.jeolla_nam_do.JeollaNamDoShelterInformationResultDataDto;
import batch.external_api.dto.seoul.SeoulShelterInformationResultDataDto;
import batch.external_api.dto.daejeon.DaeJeonShelterInformationResultDataDto;
import batch.external_api.dto.ShelterInformationDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShelterInformationDtoMapper {

    public static ShelterInformationDto toDto(SeoulShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .municipalityCode(dto.getMunicipalityCode())
                .businessStatusCode(dto.getBusinessStatusCode())
                .businessStatusName(dto.getBusinessStatusName())
                .closingDate(dto.getClosingDate())
                .phoneNumber(dto.getPhoneNumber())
                .locationArea(dto.getLocationArea())
                .locationPostalCode(dto.getLocationPostalCode())
                .landNumberAddress(dto.getLandNumberAddress())
                .roadNameAddress(dto.getRoadNameAddress())
                .roadNamePostalCode(dto.getRoadNamePostalCode())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .build();
    }

    public static ShelterInformationDto toDto(DaeJeonShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .locationArea(dto.getLocationArea())
                .roadNameAddress(dto.getRoadNameAddress())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
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

    public static ShelterInformationDto toDto(JejuShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .locationArea(dto.getLocationArea())
                .roadNameAddress(dto.getRoadNameAddress())
                .build();
    }

    public static ShelterInformationDto toDto(GyeongGiShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessStatusCode(dto.getBusinessStatusCode())
                .businessStatusName(dto.getBusinessStatusName())
                .closingDate(dto.getClosingDate())
                .locationArea(dto.getLocationArea())
                .locationPostalCode(dto.getLocationPostalCode())
                .landNumberAddress(dto.getLandNumberAddress())
                .roadNameAddress(dto.getRoadNameAddress())
                .roadNamePostalCode(dto.getRoadNamePostalCode())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .build();
    }

    public static ShelterInformationDto toDto(ChungCheongBukDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .roadNameAddress(dto.getRoadNameAddress())
                .locationArea(dto.getLocationArea())
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

    public static ShelterInformationDto toDto(JeollaBukDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .locationArea(dto.getLocationArea())
                .roadNameAddress(dto.getRoadNameAddress())
                .landNumberAddress(dto.getLandNumberAddress())
                .build();
    }

    public static ShelterInformationDto toDto(JeollaNamDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .roadNameAddress(dto.getRoadNameAddress())
                .locationArea(dto.getLocationArea())
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

    public static ShelterInformationDto toDto(GyeongSangNamDoShelterInformationResultDataDto dto) {
        return ShelterInformationDto.builder()
                .landNumberAddress(dto.getLandNumberAddress())
                .businessEstablishmentName(dto.getBusinessEstablishmentName())
                .build();
    }
}
