package com.slcube.shelter_guide.batch.repository;

import com.slcube.shelter_guide.batch.entity.ShelterInformationStaging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShelterInformationStagingRepository extends JpaRepository<ShelterInformationStaging, Long> {
    Optional<ShelterInformationStaging> findByManagementNumber(String managementNumber);
}
