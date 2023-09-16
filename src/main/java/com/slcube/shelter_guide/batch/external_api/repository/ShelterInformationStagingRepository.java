package com.slcube.shelter_guide.batch.external_api.repository;

import com.slcube.shelter_guide.batch.external_api.entity.ShelterInformationStaging;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShelterInformationStagingRepository extends JpaRepository<ShelterInformationStaging, Long> {

    Optional<ShelterInformationStaging> findByBusinessEstablishmentName(String businessEstablishmentName);

    @Query("select s from ShelterInformationStaging s")
    List<ShelterInformationStaging> findAllWithPaging(Pageable pageable);
}
