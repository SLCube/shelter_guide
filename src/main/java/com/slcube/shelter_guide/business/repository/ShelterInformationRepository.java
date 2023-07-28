package com.slcube.shelter_guide.business.repository;

import com.slcube.shelter_guide.business.entity.ShelterInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShelterInformationRepository extends JpaRepository<ShelterInformation, Long> {
    Optional<ShelterInformation> findByManagementNumber(String managementNumber);
}
