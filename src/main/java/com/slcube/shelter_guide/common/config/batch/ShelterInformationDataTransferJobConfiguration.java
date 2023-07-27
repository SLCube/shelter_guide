package com.slcube.shelter_guide.common.config.batch;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import com.slcube.shelter_guide.batch.transfer_data.processing.ShelterInformationDataTransferItemReader;
import com.slcube.shelter_guide.batch.transfer_data.processing.ShelterInformationDataTransferItemWriter;
import com.slcube.shelter_guide.batch.transfer_data.service.ShelterInformationDataTransferService;
import com.slcube.shelter_guide.business.entity.ShelterInformation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
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

    private final ShelterInformationDataTransferService shelterInformationDataTransferService;

    private static final int CHUNK_SIZE = 100;

    @Bean
    @Qualifier(value = "shelterInformationDataTransferJob")
    public Job shelterInformationDataTransferJob() {
        return jobBuilderFactory.get("shelterInformationDataTransferJob")
                .start(shelterInformationDataTransferStep())
                .build();
    }

    @Bean
    @JobScope
    public Step shelterInformationDataTransferStep() {
        return stepBuilderFactory.get("shelterInformationDataTransferStep")
                .<List<ShelterInformationStaging>, ShelterInformation>chunk(CHUNK_SIZE)
                .reader(shelterInformationDataTransferItemReader())
                .writer(shelterInformationDataTransferItemWriter())
                .build();
    }

    @Bean
    @JobScope
    public ItemReader<List<ShelterInformationStaging>> shelterInformationDataTransferItemReader() {
        return new ShelterInformationDataTransferItemReader(shelterInformationDataTransferService);
    }

    @Bean
    @JobScope
    public ItemWriter<ShelterInformation> shelterInformationDataTransferItemWriter() {
        return new ShelterInformationDataTransferItemWriter(shelterInformationDataTransferService);
    }
}
