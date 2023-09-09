package com.slcube.shelter_guide.batch.external_api.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.slcube.shelter_guide.batch.external_api.util.RegionConstant.DAE_JEON;

@RequiredArgsConstructor
@Component
public class DaeJeonShelterInformationScheduler implements ShelterInformationScheduler {

    @Qualifier("shelterInformationExternalApiJob")
    private final Job job;

    private final JobLauncher jobLauncher;

    @Override
    public void executeFetchingShelterInformationJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        jobLauncher.run(
                job,
                new JobParametersBuilder()
                        .addString("datetime", LocalDateTime.now().toString())
                        .addString("region", DAE_JEON.getRegion())
                        .toJobParameters()
        );
    }
}