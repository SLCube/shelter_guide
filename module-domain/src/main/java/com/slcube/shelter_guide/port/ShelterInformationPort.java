package com.slcube.shelter_guide.port;

import com.slcube.shelter_guide.domain.ShelterInformation;

import java.util.List;
import java.util.Optional;

public interface ShelterInformationPort {
    List<ShelterInformation> findByBusinessEstablishmentNameIn(List<String> businessEstablishmentNameList);
    List<ShelterInformation> findByDistrict(String district);
    Optional<ShelterInformation> findById(Long id);
}
