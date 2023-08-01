package com.slcube.shelter_guide.business.repository;

import com.slcube.shelter_guide.business.entity.ShelterInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShelterInformationRepository extends JpaRepository<ShelterInformation, Long> {
    Optional<ShelterInformation> findByManagementNumber(String managementNumber);

    @Query("select s from ShelterInformation s where s.landNumberAddress like :address")
    List<ShelterInformation> findByAddress(String address);
}
