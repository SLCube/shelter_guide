package com.slcube.shelter_guide.batch.external_api.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class SeoulShelterInformationScheduler implements ShelterInformationScheduler {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void run() {
        try {
            log.info(">>> Seoul Shelter Information Job Start");

            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .toJobParameters()
            );
            log.info(">>> Successfully complete Seoul Shelter Information Job");
        } catch (JobExecutionException e) {
            log.error("Seoul Shelter Information JobExecutionException : ", e);
        }
    }
}
