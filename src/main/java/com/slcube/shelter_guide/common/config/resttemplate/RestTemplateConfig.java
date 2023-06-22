package com.slcube.shelter_guide.common.config.resttemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfig {

    @Value("${external-service.shelter-information.seoul.url}")
    private String externalUrl;

    @Value("${external-service.shelter-information.seoul.api-key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate() {
        String uri = externalUrl.replace("{apiKey}", apiKey);

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(uri));
        return restTemplate;
    }
}
