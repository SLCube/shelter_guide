package com.slcube.shelter_guide.business.dto;

import com.slcube.shelter_guide.business.entity.ShelterInformation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ShelterInformationResponseDto {

    @Schema(description = "아이디")
    private Long shelterInformationId;

    @Schema(description = "영업상태코드")
    private String businessStatusCode;

    @Schema(description = "영업상태명")
    private String businessStatusName;

    @Schema(description = "폐업일자")
    private String closingDate;

    @Schema(description = "소재지면적")
    private double locationArea;

    @Schema(description = "소재지 우편번호")
    private String locationPostalCode;

    @Schema(description = "지번주소")
    private String landNumberAddress;

    @Schema(description = "도로명주소")
    private String roadNameAddress;

    @Schema(description = "도로명우편번호")
    private String roadNamePostalCode;

    public ShelterInformationResponseDto(ShelterInformation shelterInformation) {
        this.shelterInformationId = shelterInformation.getId();
        this.businessStatusCode = shelterInformation.getBusinessStatusCode();
        this.businessStatusName = shelterInformation.getBusinessStatusName();
        this.closingDate = shelterInformation.getClosingDate();
        this.locationArea = shelterInformation.getLocationArea();
        this.locationPostalCode = shelterInformation.getLocationPostalCode();
        this.landNumberAddress = shelterInformation.getLandNumberAddress();
        this.roadNameAddress = shelterInformation.getRoadNameAddress();
        this.roadNamePostalCode = shelterInformation.getRoadNamePostalCode();
    }
}
