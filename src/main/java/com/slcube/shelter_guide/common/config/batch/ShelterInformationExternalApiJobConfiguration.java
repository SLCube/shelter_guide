package com.slcube.shelter_guide.common.config.batch;

import com.slcube.shelter_guide.batch.external_api.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.listener.ShelterInformationJobListener;
import com.slcube.shelter_guide.batch.external_api.processing.ShelterInformationItemReader;
import com.slcube.shelter_guide.batch.external_api.processing.ShelterInformationItemWriter;
import com.slcube.shelter_guide.batch.external_api.service.ShelterInformationApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ShelterInformationExternalApiJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ShelterInformationApiService shelterInformationApiService;

    private static final int CHUNK_SIZE = 100;

    @Bean
    public Job shelterInformationExternalApiJob() {
        return jobBuilderFactory.get("shelterInformationExternalApiJob")
                .start(shelterInformationExternalApiStep())
                .build();

    }

    @Bean
    @JobScope
    public Step shelterInformationExternalApiStep() {
        return stepBuilderFactory.get("shelterInformationExternalApiStep")
                .<List<SeoulShelterInformationResultDataDto>, List<SeoulShelterInformationResultDataDto>>chunk(CHUNK_SIZE)
                .listener(shelterInformationJobListener())
                .reader(shelterInformationItemReader())
                .writer(shelterInformationItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public ItemReader<List<SeoulShelterInformationResultDataDto>> shelterInformationItemReader() {
        return new ShelterInformationItemReader(shelterInformationApiService);
    }

    @Bean
    @StepScope
    public ItemWriter<List<SeoulShelterInformationResultDataDto>> shelterInformationItemWriter() {
        return new ShelterInformationItemWriter(shelterInformationApiService);
    }

    @Bean
    public JobExecutionListener shelterInformationJobListener() {
        return new ShelterInformationJobListener();
    }
}
