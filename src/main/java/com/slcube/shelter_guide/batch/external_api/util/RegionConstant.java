package com.slcube.shelter_guide.batch.external_api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionConstant {
    SEOUL("seoul"),
    DAE_JEON("daeJeon"),
    GYEONG_GI("gyeongGi"),
    JEOLLA_BUK_DO("jeollaBukDo"),
    GYEONG_SANG_BUK_DO("gyeongSangBukDo");

    private final String region;
}
