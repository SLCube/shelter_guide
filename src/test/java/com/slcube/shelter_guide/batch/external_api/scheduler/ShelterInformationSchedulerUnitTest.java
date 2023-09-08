package com.slcube.shelter_guide.batch.external_api.scheduler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ShelterInformationSchedulerUnitTest {

    @InjectMocks
    private SeoulShelterInformationScheduler shelterInformationScheduler;

    @Mock
    private Job job;

    @Mock
    private JobLauncher jobLauncher;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    void 한달에_한번_대피소_정보를_갖고오는_스케줄러_테스트() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        shelterInformationScheduler.executeFetchingShelterInformationJob();
        Mockito.verify(jobLauncher).run(any(Job.class), any(JobParameters.class));
    }
}
