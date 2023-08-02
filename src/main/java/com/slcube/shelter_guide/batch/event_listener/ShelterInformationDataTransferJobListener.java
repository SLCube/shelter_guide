package com.slcube.shelter_guide.batch.event_listener;

import com.slcube.shelter_guide.common.config.batch.ShelterInformationDataTransferJobConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Component
public class ShelterInformationDataTransferJobListener implements ApplicationListener<ShelterInformationFetchApiCompleteEvent> {

    private final JobLauncher jobLauncher;

//    @Qualifier(value = "shelterInformationDataTransferJob")
//    private final Job shelterInformationDataTransferJob;

    private final ShelterInformationDataTransferJobConfiguration jobConfiguration;

    @Override
    public void onApplicationEvent(ShelterInformationFetchApiCompleteEvent event) {
        try {
            log.info(">>> Shelter Information Data Transfer Job Start");

            jobLauncher.run(
                    jobConfiguration.shelterInformationDataTransferJob(),
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
