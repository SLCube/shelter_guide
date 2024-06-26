package batch.config;

import batch.event_listener.ShelterInformationFetchApiExecutionListener;
import batch.external_api.processing.ShelterInformationItemProcessor;
import batch.external_api.processing.ShelterInformationItemReader;
import batch.external_api.processing.ShelterInformationItemWriter;
import batch.external_api.util.ShelterInformationApiServiceStrategy;
import external_api.dto.ShelterInformationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import repository.ShelterInformationStagingRepository;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ShelterInformationExternalApiJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ShelterInformationApiServiceStrategy apiServiceMap;
    private final ShelterInformationStagingRepository shelterInformationRepository;
    private final ShelterInformationFetchApiExecutionListener listener;
    private static final int CHUNK_SIZE = 1000;

    @Bean
    @Primary
    @Qualifier("shelterInformationExternalApiJob")
    public Job shelterInformationExternalApiJob() {
        return jobBuilderFactory.get("shelterInformationExternalApiJob")
                .start(shelterInformationExternalApiStep())
                .incrementer(new VersionJobParametersIncrementer())
                .listener(listener)
                .build();

    }

    @Bean
    @JobScope
    public Step shelterInformationExternalApiStep() {
        return stepBuilderFactory.get("shelterInformationExternalApiStep")
                .<List<ShelterInformationDto>, List<ShelterInformationDto>>chunk(CHUNK_SIZE)
                .reader(shelterInformationItemReader(null, null))
                .writer(shelterInformationItemWriter())
                .processor(shelterInformationItemProcessor())
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    @StepScope
    public ShelterInformationItemReader shelterInformationItemReader(@Value("#{jobParameters[region]}") String region,
                                                                     @Value("#{jobParameters[datetime]}") String datetime) {
        return new ShelterInformationItemReader(region, apiServiceMap);
    }

    @Bean
    @StepScope
    public ShelterInformationItemWriter shelterInformationItemWriter() {
        return new ShelterInformationItemWriter(shelterInformationRepository);
    }

    @Bean
    @StepScope
    public ShelterInformationItemProcessor shelterInformationItemProcessor() {
        return new ShelterInformationItemProcessor(shelterInformationRepository);
    }
}
