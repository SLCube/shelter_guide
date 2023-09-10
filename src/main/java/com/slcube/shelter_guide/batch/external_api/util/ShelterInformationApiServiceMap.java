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
                                           InCheonShelterInformationApiService inCheonShelterInformationApiService,
                                           GwangJuShelterInformationApiService gwangJuShelterInformationApiService,
                                           GyeongGiShelterInformationApiService gyeongGiShelterInformationApiService,
                                           JeollaBukDoShelterInformationApiService jeollaBukDoShelterInformationApiService,
                                           JeollaNamDoShelterInformationApiService jeollaNamDoShelterInformationApiService,
                                           GyeongSangBukDoShelterInformationApiService gyeongSangNamDoShelterInformationApiService,
                                           DaeJeonShelterInformationApiService daeJeonShelterInformationApiService) {

        serviceMap.put(SEOUL.getRegion(), seoulShelterInformationApiService);
        serviceMap.put(INCHEON.getRegion(), inCheonShelterInformationApiService);
        serviceMap.put(GWANG_JU.getRegion(), gwangJuShelterInformationApiService);
        serviceMap.put(GYEONG_GI.getRegion(), gyeongGiShelterInformationApiService);
        serviceMap.put(JEOLLA_BUK_DO.getRegion(), jeollaBukDoShelterInformationApiService);
        serviceMap.put(JEOLLA_NAM_DO.getRegion(), jeollaNamDoShelterInformationApiService);
        serviceMap.put(GYEONG_SANG_BUK_DO.getRegion(), gyeongSangNamDoShelterInformationApiService);
        serviceMap.put(DAE_JEON.getRegion(), daeJeonShelterInformationApiService);
    }

    public ShelterInformationApiService getApiService(String region) {

        if (region == null) {
            throw new IllegalArgumentException("Region can not be null");
        }

        return serviceMap.get(region);
    }
}
