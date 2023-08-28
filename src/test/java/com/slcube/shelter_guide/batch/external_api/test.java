package com.slcube.shelter_guide.batch.external_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
public class test {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
        Map<Object, Object> forObject = restTemplate.getForObject("https://openapi.gg.go.kr/CivilDefenseEvacuation?type=json&key=4744334c1e8e47dfba47f5a770b2512f", Map.class);

    }

}
