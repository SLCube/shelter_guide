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

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.GYEONG_SANG_NAM_DO;

@Slf4j
@RequiredArgsConstructor
@Component
public class GyeongSangNamDoShelterInformationScheduler implements ShelterInformationScheduler {

    @Qualifier("shelterInformationExternalApiJob")
    private final Job job;

    private final JobLauncher jobLauncher;

    @Override
    @Scheduled(cron = "15 0 0 1 * ?")
    public void run() {
        try {
            log.info(">>> GYEONG_SANG_NAM_DO Shelter Information Job Start");

            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .addString("region", GYEONG_SANG_NAM_DO.getRegion())
                            .toJobParameters()
            );
            log.info(">>> Successfully complete GYEONG_SANG_NAM_DO Shelter Information Job");
        } catch (JobExecutionException e) {
            log.error("GYEONG_SANG_NAM_DO Shelter Information JobExecutionException : ", e);
        }
    }
}
