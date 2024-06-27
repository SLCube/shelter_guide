package com.slcube.shelter_guide.repository;

import com.slcube.shelter_guide.domain.ShelterInformationStaging;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShelterInformationStagingRepository extends JpaRepository<ShelterInformationStaging, Long> {

    @Query("select s from ShelterInformationStaging s where s.businessEstablishmentName in :businessEstablishmentNameList")
    List<ShelterInformationStaging> findByBusinessEstablishmentNameIn(@Param("businessEstablishmentNameList") List<String> businessEstablishmentNameList);

    @Query("select s from ShelterInformationStaging s")
    List<ShelterInformationStaging> findAllWithPaging(Pageable pageable);
}
