package com.slcube.shelter_guide.common.config.batch;

import com.slcube.shelter_guide.batch.dto.SeoulShelterInformationResultDataDto;
import com.slcube.shelter_guide.batch.processing.ShelterInformationItemReader;
import com.slcube.shelter_guide.batch.processing.ShelterInformationItemWriter;
import com.slcube.shelter_guide.batch.service.ShelterInformationApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
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
public class ShelterInformationJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ShelterInformationApiService shelterInformationApiService;

    private static final int CHUNK_SIZE = 100;

    @Bean
    public Job shelterInformationJob() {
        return jobBuilderFactory.get("shelterInformationJob")
                .start(shelterInformationStep())
                .build();

    }

    @Bean
    @JobScope
    public Step shelterInformationStep() {
        return stepBuilderFactory.get("shelterInformationStep")
                .<List<SeoulShelterInformationResultDataDto>, List<SeoulShelterInformationResultDataDto>>chunk(CHUNK_SIZE)
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
        return new ShelterInformationItemWriter();
    }
}
