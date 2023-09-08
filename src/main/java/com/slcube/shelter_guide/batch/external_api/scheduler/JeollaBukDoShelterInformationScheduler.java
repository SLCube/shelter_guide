package com.slcube.shelter_guide.batch.external_api.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.JEOLLA_BUK_DO;

@Slf4j
@RequiredArgsConstructor
@Component
public class JeollaBukDoShelterInformationScheduler implements ShelterInformationScheduler {

    @Qualifier("shelterInformationExternalApiJob")
    private final Job job;

    private final JobLauncher jobLauncher;

    @Override
    @Scheduled(cron = "10 0 0 1 * ?")
    public void run() {
        try {
            log.info(">>> JEOLLA_BUK_DO Shelter Information Job Start");

            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .addString("region", JEOLLA_BUK_DO.getRegion())
                            .toJobParameters()
            );
            log.info(">>> Successfully complete JEOLLA_BUK_DO Shelter Information Job");
        } catch (JobExecutionException e) {
            log.error("JEOLLA_BUK_DO Shelter Information JobExecutionException : ", e);
        }
    }
}
