package com.slcube.shelter_guide.batch.external_api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionConstant {
    SEOUL("seoul"),
    INCHEON("inCheon"),
    DAE_JEON("daeJeon"),
    GWANG_JU("gwangJu"),
    JEJU("jeju"),
    GYEONG_GI("gyeongGi"),
    CHUNG_CHEONG_BUK_DO("chungCheongBukDo"),
    CHUNG_CHEONG_NAM_DO("chungCheongNamDo"),
    JEOLLA_BUK_DO("jeollaBukDo"),
    JEOLLA_NAM_DO("jeollaNamDo"),
    GYEONG_SANG_BUK_DO("gyeongSangBukDo"),
    GYEONG_SANG_NAM_DO("gyeongSangNamDo");

    private final String region;
}
