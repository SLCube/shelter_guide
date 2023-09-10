package com.slcube.shelter_guide.batch.external_api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionConstant {
    SEOUL("seoul"),
    INCHEON("inCheon"),
    DAE_JEON("daeJeon"),
    GYEONG_GI("gyeongGi"),
    JEOLLA_BUK_DO("jeollaBukDo"),
    JEOLLA_NAM_DO("jeollaNamDo"),
    GYEONG_SANG_BUK_DO("gyeongSangBukDo");

    private final String region;
}
