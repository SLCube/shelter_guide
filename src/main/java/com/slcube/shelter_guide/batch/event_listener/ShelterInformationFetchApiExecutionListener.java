package com.slcube.shelter_guide.batch.event_listener;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShelterInformationFetchApiExecutionListener implements JobExecutionListener {

    private final ShelterInformationFetchApiCompletePublisher publisher;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        publisher.publishShelterInformationFetchApiJobCompletionEvent();
    }
}
