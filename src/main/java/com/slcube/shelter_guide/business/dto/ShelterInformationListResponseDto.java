package com.slcube.shelter_guide.business.dto;

import com.slcube.shelter_guide.business.entity.ShelterInformation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ShelterInformationListResponseDto {

    @Schema(description = "아이디")
    private Long shelterInformationId;

    @Schema(description = "관리번호")
    private String managementNumber;

    @Schema(description = "영업상태코드")
    private String businessStatusCode;

    @Schema(description = "영업상태명")
    private String businessStatusName;

    @Schema(description = "상세영업상태코드")
    private String detailedBusinessStatusCode;

    @Schema(description = "상세영업상태명")
    private String detailedBusinessStatusName;

    @Schema(description = "폐업일자")
    private String closingDate;

    @Schema(description = "소재지 우편번호")
    private String locationPostalCode;

    @Schema(description = "지번주소")
    private String landNumberAddress;

    @Schema(description = "도로명주소")
    private String roadNameAddress;

    @Schema(description = "도로명 우편번호")
    private String roadNamePostalCode;

    public ShelterInformationListResponseDto(ShelterInformation shelterInformation) {
        this.shelterInformationId = shelterInformation.getId();
        this.managementNumber = shelterInformation.getManagementNumber();
        this.businessStatusCode = shelterInformation.getBusinessStatusCode();
        this.businessStatusName = shelterInformation.getBusinessStatusName();
        this.detailedBusinessStatusCode = shelterInformation.getDetailedBusinessStatusCode();
        this.detailedBusinessStatusName = shelterInformation.getDetailedBusinessStatusName();
        this.closingDate = shelterInformation.getClosingDate();
        this.locationPostalCode = shelterInformation.getLocationPostalCode();
        this.landNumberAddress = shelterInformation.getLandNumberAddress();
        this.roadNameAddress = shelterInformation.getRoadNameAddress();
        this.roadNamePostalCode = shelterInformation.getRoadNamePostalCode();
    }
}
