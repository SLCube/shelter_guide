package com.slcube.shelter_guide.batch.event_listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShelterInformationFetchApiCompletePublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishShelterInformationFetchApiJobCompletionEvent() {
        applicationEventPublisher.publishEvent(new ShelterInformationFetchApiCompleteEvent(this));
    }
}
