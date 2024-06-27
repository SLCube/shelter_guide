package com.slcube.shelter_guide.batch.event_listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Component
public class ShelterInformationDataTransferJobListener implements ApplicationListener<ShelterInformationFetchApiCompleteEvent> {

    private final JobLauncher jobLauncher;

    @Qualifier("shelterInformationDataTransferJob")
    private final Job shelterInformationDataTransferJob;

    @Override
    public void onApplicationEvent(ShelterInformationFetchApiCompleteEvent event) {
        try {
            log.info(">>> Shelter Information Data Transfer Job Start");

            jobLauncher.run(
                    shelterInformationDataTransferJob,
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .toJobParameters()
            );
            log.info(">>> Successfully complete Shelter Information Data Transfer Job");
        } catch (Exception e) {
            log.error(">>> Shelter Information Data Transfer Job Exception : ", e);
        }
    }
}
