package com.slcube.shelter_guide.business.controller;

import com.slcube.shelter_guide.business.service.ShelterInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShelterInformationController {

    private final ShelterInformationService shelterInformationService;
}
