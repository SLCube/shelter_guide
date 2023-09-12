package com.slcube.shelter_guide.batch.external_api.util;

import com.slcube.shelter_guide.batch.external_api.service.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.*;

@Component
public class ShelterInformationApiServiceStrategy {
    private final Map<String , ShelterInformationApiService> serviceMap = new HashMap<>();

    public ShelterInformationApiServiceStrategy(SeoulShelterInformationApiService seoulShelterInformationApiService,
                                                InCheonShelterInformationApiService inCheonShelterInformationApiService,
                                                DaeJeonShelterInformationApiService daeJeonShelterInformationApiService,
                                                GwangJuShelterInformationApiService gwangJuShelterInformationApiService,
                                                JejuShelterInformationApiService jejuShelterInformationApiService,
                                                GyeongGiShelterInformationApiService gyeongGiShelterInformationApiService,
                                                ChungCheongBukDoShelterInformationApiService chungCheongBukDoShelterInformationApiService,
                                                ChungCheongNamDoShelterInformationApiService chungCheongNamDoShelterInformationApiService,
                                                JeollaBukDoShelterInformationApiService jeollaBukDoShelterInformationApiService,
                                                JeollaNamDoShelterInformationApiService jeollaNamDoShelterInformationApiService,
                                                GyeongSangBukDoShelterInformationApiService gyeongSangBukDoShelterInformationApiService,
                                                GyeongSangNamDoShelterInformationApiService gyeongSangNamDoShelterInformationApiService) {

        serviceMap.put(SEOUL.getRegion(), seoulShelterInformationApiService);
        serviceMap.put(INCHEON.getRegion(), inCheonShelterInformationApiService);
        serviceMap.put(DAE_JEON.getRegion(), daeJeonShelterInformationApiService);
        serviceMap.put(GWANG_JU.getRegion(), gwangJuShelterInformationApiService);
        serviceMap.put(JEJU.getRegion(), jejuShelterInformationApiService);
        serviceMap.put(GYEONG_GI.getRegion(), gyeongGiShelterInformationApiService);
        serviceMap.put(CHUNG_CHEONG_BUK_DO.getRegion(), chungCheongBukDoShelterInformationApiService);
        serviceMap.put(CHUNG_CHEONG_NAM_DO.getRegion(), chungCheongNamDoShelterInformationApiService);
        serviceMap.put(JEOLLA_BUK_DO.getRegion(), jeollaBukDoShelterInformationApiService);
        serviceMap.put(JEOLLA_NAM_DO.getRegion(), jeollaNamDoShelterInformationApiService);
        serviceMap.put(GYEONG_SANG_BUK_DO.getRegion(), gyeongSangBukDoShelterInformationApiService);
        serviceMap.put(GYEONG_SANG_NAM_DO.getRegion(), gyeongSangNamDoShelterInformationApiService);
    }

    public ShelterInformationApiService getApiService(String region) {

        if (region == null) {
            throw new IllegalArgumentException("Region can not be null");
        }

        ShelterInformationApiService shelterInformationApiService = serviceMap.get(region);

        if (shelterInformationApiService == null) {
            throw new IllegalArgumentException("ShelterInformation Api Service can not be null");
        }

        return shelterInformationApiService;
    }
}
