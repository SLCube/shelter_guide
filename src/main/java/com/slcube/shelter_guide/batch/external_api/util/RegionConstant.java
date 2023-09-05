package com.slcube.shelter_guide.batch.external_api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionConstant {
    SEOUL("seoul"),
    GYEONG_GI("gyeong_gi"),
    JEOLLA_BUK_DO("jeolla_buk_do");

    private final String region;
}
