package com.slcube.shelter_guide.batch.external_api.util;

import com.slcube.shelter_guide.batch.external_api.service.GyeongGiShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.service.JeollaBukDoShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.service.SeoulShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationApiService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.*;

@Component
public class ShelterInformationApiServiceMap {
    private final Map<String , ShelterInformationApiService> serviceMap = new HashMap<>();

    public ShelterInformationApiServiceMap(SeoulShelterInformationApiService seoulShelterInformationApiService,
                                           GyeongGiShelterInformationApiService gyeongGiShelterInformationApiService,
                                           JeollaBukDoShelterInformationApiService jeollaBukDoShelterInformationApiService) {
        serviceMap.put(SEOUL.getRegion(), seoulShelterInformationApiService);
        serviceMap.put(GYEONG_GI.getRegion(), gyeongGiShelterInformationApiService);
        serviceMap.put(JEOLLA_BUK_DO.getRegion(), jeollaBukDoShelterInformationApiService);
    }

    public ShelterInformationApiService getApiService(String region) {

        if (region == null) {
            throw new IllegalArgumentException("Region can not be null");
        }

        return serviceMap.get(region);
    }
}
