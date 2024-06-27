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
        // batch 실행 전 추가적으로 필요한 작업이 없기 때문에 해당 메소드의 내용은 없음.
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        publisher.publishShelterInformationFetchApiJobCompletionEvent();
    }
}
