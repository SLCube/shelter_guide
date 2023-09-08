package com.slcube.shelter_guide.batch.external_api.dto.gyeong_sang_nam_do;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GyeongSangNamDoShelterInformationResultDataDto {

    @JsonProperty("민방위대피시설명칭")
    private String businessEstablishmentName;

    @JsonProperty("대피시설 기본정보(확보면적(㎡) )")
    private double locationArea;

    @JsonProperty("주소  (전체주소 기입, 광역시도+시군구+읍면동+세부주소)(도로명 주소)\"")
    private String roadNameAddress;

    @JsonProperty("주소  (전체주소 기입, 광역시도+시군구+읍면동+세부주소)(지번 주소)\"")
    private String landNumberAddress;
}
