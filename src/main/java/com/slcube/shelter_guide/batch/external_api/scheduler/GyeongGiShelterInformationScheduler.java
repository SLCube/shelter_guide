package com.slcube.shelter_guide.batch.external_api.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class GyeongGiShelterInformationScheduler implements ShelterInformationScheduler{

    @Qualifier("shelterInformationExternalApiJob")
    private final Job job;

    private final JobLauncher jobLauncher;


    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void run() {

    }
}
