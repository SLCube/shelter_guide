package com.slcube.shelter_guide.batch.event_listener;

import org.springframework.context.ApplicationEvent;

public class ShelterInformationFetchApiCompleteEvent extends ApplicationEvent {
    public ShelterInformationFetchApiCompleteEvent(Object source) {
        super(source);
    }
}
