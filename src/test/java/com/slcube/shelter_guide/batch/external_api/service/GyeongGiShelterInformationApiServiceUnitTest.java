package com.slcube.shelter_guide.batch.external_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slcube.shelter_guide.batch.external_api.dto.ShelterInformationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class GyeongGiShelterInformationApiServiceUnitTest {

    @InjectMocks
    private GyeongGiShelterInformationApiService gyeongGiShelterInformationApiService;

    @Mock
    private RestTemplate restTemplate;

    @Spy
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        setField(gyeongGiShelterInformationApiService, "externalUrl", "https://openapi.gg.go.kr/CivilDefenseEvacuation?type=json&key={apiKey}&pIndex={pageIndex}&pSize={pSize}");
        setField(gyeongGiShelterInformationApiService, "apiKey", "testKey");
    }

    @Test
    void 경기도_민방위_대피소_정보를_갖고오는_메소드_단위_테스트() throws Exception {

        String resultJsonString = "{\"CivilDefenseEvacuation\":[{\"head\":[{\"list_total_count\":5749},{\"RESULT\":{\"CODE\":\"INFO-000\",\"MESSAGE\":\"정상 처리되었습니다.\"}},{\"api_version\":\"1.0\"}]},{\"row\":[{\"BIZPLC_NM\":\"문촌마을 2단지 지하주차장 1층\",\"LOCPLC_LOTNO_ADDR\":\"경기도 고양시 일산서구 주엽동 5번지\",\"MANAGE_ID\":\"4100100-S199400038\",\"LOCPLC_ROADNM_ADDR\":\"경기도 고양시 일산서구 대산로 164-0 (주엽동, 문촌마을2단지아파트)\",\"LICENSG_DE\":\"1994-01-01\",\"BSN_STATE_NM\":\"사용중\",\"LICENSG_CANCL_DE\":null,\"CLSBIZ_DE\":null,\"BSN_STATE_DIV\":\"18\",\"SUSPNBIZ_BEGIN_DE\":null,\"UNITY_BSN_STATE_DIV_CD\":\"01\",\"UNITY_BSN_STATE_NM\":\"영업/정상\",\"SUSPNBIZ_END_DE\":null,\"REOPENBIZ_DE\":null,\"LOCPLC_ZIPNO\":null,\"RLSE_DE\":null,\"LOCPLC_AR_INFO\":\"12401\",\"ROADNM_ZIPNO\":\"10371\",\"LAST_UPD_TM\":\"2023-06-15 10:38:06\",\"DATA_UPDT_DIV_CD\":\"U\",\"DATA_UPDT_TM\":\"2023-06-17 02:40:00\",\"X_CRDNT_VL\":\"178789.574323179    \",\"Y_CRDNT_VL\":\"463860.488340512    \",\"EMGNCY_FACLT_LOC\":\"경기도 고양시 일산서구 주엽동 5번지\",\"FACLT_DIV_NM\":\"공공용시설\",\"FACLT_NM_BULDNG_NM_INFO\":\"문촌마을 2단지 지하주차장 1층\"},{\"BIZPLC_NM\":\"문촌마을 3단지 지하주차장 1층\",\"LOCPLC_LOTNO_ADDR\":\"경기도 고양시 일산서구 주엽동 32번지\",\"MANAGE_ID\":\"4100100-S199400039\",\"LOCPLC_ROADNM_ADDR\":\"경기도 고양시 일산서구 대산로 142-0 (주엽동, 문촌마을3단지아파트)\",\"LICENSG_DE\":\"1994-01-01\",\"BSN_STATE_NM\":\"사용중\",\"LICENSG_CANCL_DE\":null,\"CLSBIZ_DE\":null,\"BSN_STATE_DIV\":\"18\",\"SUSPNBIZ_BEGIN_DE\":null,\"UNITY_BSN_STATE_DIV_CD\":\"01\",\"UNITY_BSN_STATE_NM\":\"영업/정상\",\"SUSPNBIZ_END_DE\":null,\"REOPENBIZ_DE\":null,\"LOCPLC_ZIPNO\":null,\"RLSE_DE\":null,\"LOCPLC_AR_INFO\":\"20611\",\"ROADNM_ZIPNO\":\"10375\",\"LAST_UPD_TM\":\"2023-06-15 10:38:15\",\"DATA_UPDT_DIV_CD\":\"U\",\"DATA_UPDT_TM\":\"2023-06-17 02:40:00\",\"X_CRDNT_VL\":\"179029.735917506    \",\"Y_CRDNT_VL\":\"463749.60585447     \",\"EMGNCY_FACLT_LOC\":\"경기도 고양시 일산서구 주엽동 32번지\",\"FACLT_DIV_NM\":\"공공용시설\",\"FACLT_NM_BULDNG_NM_INFO\":\"문촌마을 3단지 지하주차장 1층\"},{\"BIZPLC_NM\":\"문촌마을 7단지 지하주차장 1층\",\"LOCPLC_LOTNO_ADDR\":\"경기도 고양시 일산서구 주엽동 14번지\",\"MANAGE_ID\":\"4100100-S199400043\",\"LOCPLC_ROADNM_ADDR\":\"경기도 고양시 일산서구 킨텍스로 340-0 (주엽동, 문촌마을7단지아파트)\",\"LICENSG_DE\":\"1994-01-01\",\"BSN_STATE_NM\":\"사용중\",\"LICENSG_CANCL_DE\":null,\"CLSBIZ_DE\":null,\"BSN_STATE_DIV\":\"18\",\"SUSPNBIZ_BEGIN_DE\":null,\"UNITY_BSN_STATE_DIV_CD\":\"01\",\"UNITY_BSN_STATE_NM\":\"영업/정상\",\"SUSPNBIZ_END_DE\":null,\"REOPENBIZ_DE\":null,\"LOCPLC_ZIPNO\":null,\"RLSE_DE\":null,\"LOCPLC_AR_INFO\":\"5919\",\"ROADNM_ZIPNO\":\"10378\",\"LAST_UPD_TM\":\"2023-06-15 10:37:24\",\"DATA_UPDT_DIV_CD\":\"U\",\"DATA_UPDT_TM\":\"2023-06-17 02:40:00\",\"X_CRDNT_VL\":\"178430.303055346    \",\"Y_CRDNT_VL\":\"463611.868784191    \",\"EMGNCY_FACLT_LOC\":\"경기도 고양시 일산서구 주엽동 14번지\",\"FACLT_DIV_NM\":\"공공용시설\",\"FACLT_NM_BULDNG_NM_INFO\":\"문촌마을 7단지 지하주차장 1층\"},{\"BIZPLC_NM\":\"신원당마을 7단지 지하주차장 1층\",\"LOCPLC_LOTNO_ADDR\":\"경기도 고양시 덕양구 성사동 727번지\",\"MANAGE_ID\":\"3950000-S200300018\",\"LOCPLC_ROADNM_ADDR\":\"경기도 고양시 덕양구 호국로 754 (성사동)\",\"LICENSG_DE\":\"2003-03-12\",\"BSN_STATE_NM\":\"사용중\",\"LICENSG_CANCL_DE\":null,\"CLSBIZ_DE\":null,\"BSN_STATE_DIV\":\"18\",\"SUSPNBIZ_BEGIN_DE\":null,\"UNITY_BSN_STATE_DIV_CD\":\"01\",\"UNITY_BSN_STATE_NM\":\"영업/정상\",\"SUSPNBIZ_END_DE\":null,\"REOPENBIZ_DE\":null,\"LOCPLC_ZIPNO\":null,\"RLSE_DE\":null,\"LOCPLC_AR_INFO\":\"5757\",\"ROADNM_ZIPNO\":\"412-713\",\"LAST_UPD_TM\":\"2023-07-05 18:52:34\",\"DATA_UPDT_DIV_CD\":\"U\",\"DATA_UPDT_TM\":\"2023-07-07 02:40:00\",\"X_CRDNT_VL\":\"185312.147788863    \",\"Y_CRDNT_VL\":\"461286.177240797    \",\"EMGNCY_FACLT_LOC\":\"경기도 고양시 덕양구 성사동 727번지\",\"FACLT_DIV_NM\":\"공공용시설\",\"FACLT_NM_BULDNG_NM_INFO\":\"신원당마을 7단지 지하주차장 1층\"},{\"BIZPLC_NM\":\"대화마을 7단지 지하주차장 1층\",\"LOCPLC_LOTNO_ADDR\":\"경기도 고양시 일산서구 대화동 2579번지\",\"MANAGE_ID\":\"4100100-S201000014\",\"LOCPLC_ROADNM_ADDR\":\"경기도 고양시 일산서구 대화1로 70 (대화동, 대화마을7단지아파트)\",\"LICENSG_DE\":\"2010-07-07\",\"BSN_STATE_NM\":\"사용중\",\"LICENSG_CANCL_DE\":null,\"CLSBIZ_DE\":null,\"BSN_STATE_DIV\":\"18\",\"SUSPNBIZ_BEGIN_DE\":null,\"UNITY_BSN_STATE_DIV_CD\":\"01\",\"UNITY_BSN_STATE_NM\":\"영업/정상\",\"SUSPNBIZ_END_DE\":null,\"REOPENBIZ_DE\":null,\"LOCPLC_ZIPNO\":null,\"RLSE_DE\":null,\"LOCPLC_AR_INFO\":\"11809\",\"ROADNM_ZIPNO\":\"10218\",\"LAST_UPD_TM\":\"2023-06-15 15:40:21\",\"DATA_UPDT_DIV_CD\":\"U\",\"DATA_UPDT_TM\":\"2023-06-17 02:40:00\",\"X_CRDNT_VL\":\"176435.291861336    \",\"Y_CRDNT_VL\":\"463186.889390472    \",\"EMGNCY_FACLT_LOC\":\"경기도 고양시 일산서구 대화동 2579번지\",\"FACLT_DIV_NM\":\"공공용시설\",\"FACLT_NM_BULDNG_NM_INFO\":\"대화마을 7단지 지하주차장 1층\"}]}]}";
        int expectedListSize = 5;

        when(restTemplate.getForObject(any(URI.class), Mockito.<Class<String>>any()))
                .thenReturn(resultJsonString);

        List<ShelterInformationDto> shelterInformation = gyeongGiShelterInformationApiService.fetchShelterInformation(1, 5);

        assertThat(shelterInformation).hasSize(expectedListSize);
    }
}