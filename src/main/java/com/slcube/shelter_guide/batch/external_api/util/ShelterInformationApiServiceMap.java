package com.slcube.shelter_guide.batch.external_api.util;

import com.slcube.shelter_guide.batch.external_api.service.GyeongGiShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.service.SeoulShelterInformationApiService;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationApiService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.GYEONG_GI;
import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.SEOUL;

@Component
public class ShelterInformationApiServiceMap {
    private final Map<String, ShelterInformationApiService> serviceMap = new HashMap<>();

    public ShelterInformationApiServiceMap(SeoulShelterInformationApiService seoulShelterInformationApiService,
                                           GyeongGiShelterInformationApiService gyeongGiShelterInformationApiService) {
        serviceMap.put(SEOUL, seoulShelterInformationApiService);
        serviceMap.put(GYEONG_GI, gyeongGiShelterInformationApiService);
    }

    public ShelterInformationApiService getApiService(String region) {

        if (region == null) {
            throw new IllegalArgumentException("Region can not be null");
        }

        return serviceMap.get(region);
    }
}
