package com.slcube.shelter_guide.common.config.batch;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.external_api.repository.ShelterInformationStagingRepository;
import com.slcube.shelter_guide.batch.transfer_data.processing.ShelterInformationDataTransferItemProcessor;
import com.slcube.shelter_guide.batch.transfer_data.processing.ShelterInformationDataTransferItemReader;
import com.slcube.shelter_guide.batch.transfer_data.processing.ShelterInformationDataTransferItemWriter;
import com.slcube.shelter_guide.business.repository.ShelterInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ShelterInformationDataTransferJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ShelterInformationRepository shelterInformationRepository;
    private final ShelterInformationStagingRepository shelterInformationStagingRepository;
    private static final int CHUNK_SIZE = 1000;

    @Bean
    @Qualifier("shelterInformationDataTransferJob")
    public Job shelterInformationDataTransferJob() {
        return jobBuilderFactory.get("shelterInformationDataTransferJob")
                .start(shelterInformationDataTransferStep())
                .build();
    }

    @Bean
    @JobScope
    public Step shelterInformationDataTransferStep() {
        return stepBuilderFactory.get("shelterInformationDataTransferStep")
                .<List<ShelterInformationStaging>, List<ShelterInformationStaging>>chunk(CHUNK_SIZE)
                .reader(shelterInformationDataTransferItemReader())
                .writer(shelterInformationDataTransferItemWriter())
                .processor(shelterInformationDataTransferItemProcessor())
                .build();
    }

    @Bean
    @StepScope
    public ShelterInformationDataTransferItemReader shelterInformationDataTransferItemReader() {
        return new ShelterInformationDataTransferItemReader(shelterInformationStagingRepository);
    }

    @Bean
    @StepScope
    public ShelterInformationDataTransferItemWriter shelterInformationDataTransferItemWriter() {
        return new ShelterInformationDataTransferItemWriter(shelterInformationRepository);
    }

    @Bean
    @StepScope
    public ShelterInformationDataTransferItemProcessor shelterInformationDataTransferItemProcessor() {
        return new ShelterInformationDataTransferItemProcessor(shelterInformationRepository);
    }
}
