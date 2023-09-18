package com.slcube.shelter_guide.batch.external_api.scheduler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GyeongGiShelterInformationSchedulerTest {

    @InjectMocks
    GyeongGiShelterInformationScheduler gyeongGiShelterInformationScheduler;

    @Mock
    private Job job;

    @Mock
    private JobLauncher jobLauncher;

    @Test
    void 경기도_대피소_정보_스케줄러_테스트() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        gyeongGiShelterInformationScheduler.executeFetchingShelterInformationJob();
        verify(jobLauncher).run(any(Job.class), any(JobParameters.class));
    }
}