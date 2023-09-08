package com.slcube.shelter_guide.batch.external_api.util;

import com.slcube.shelter_guide.batch.external_api.service.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.*;

@Component
public class ShelterInformationApiServiceMap {
    private final Map<String , ShelterInformationApiService> serviceMap = new HashMap<>();

    public ShelterInformationApiServiceMap(SeoulShelterInformationApiService seoulShelterInformationApiService,
                                           GyeongGiShelterInformationApiService gyeongGiShelterInformationApiService,
                                           JeollaBukDoShelterInformationApiService jeollaBukDoShelterInformationApiService,
                                           GyeongSangNamDoShelterInformationApiService gyeongSangNamDoShelterInformationApiService) {
        serviceMap.put(SEOUL.getRegion(), seoulShelterInformationApiService);
        serviceMap.put(GYEONG_GI.getRegion(), gyeongGiShelterInformationApiService);
        serviceMap.put(JEOLLA_BUK_DO.getRegion(), jeollaBukDoShelterInformationApiService);
        serviceMap.put(GYEONG_SANG_NAM_DO.getRegion(), gyeongSangNamDoShelterInformationApiService);
    }

    public ShelterInformationApiService getApiService(String region) {

        if (region == null) {
            throw new IllegalArgumentException("Region can not be null");
        }

        return serviceMap.get(region);
    }
}
