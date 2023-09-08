package com.slcube.shelter_guide.batch.external_api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionConstant {
    SEOUL("seoul"),
    GYEONG_GI("gyeongGi"),
    JEOLLA_BUK_DO("jeollaBukDo"),
    GYEONG_SANG_NAM_DO("gyeongSangNamDo");

    private final String region;
}
