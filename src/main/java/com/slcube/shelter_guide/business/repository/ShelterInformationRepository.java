package com.slcube.shelter_guide.business.repository;

import com.slcube.shelter_guide.business.entity.ShelterInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShelterInformationRepository extends JpaRepository<ShelterInformation, Long> {

    @Query("select s from ShelterInformation s where s.businessEstablishmentName in :businessEstablishmentNameList")
    List<ShelterInformation> findByBusinessEstablishmentNameIn(@Param("businessEstablishmentNameList") List<String> businessEstablishmentNameList);

    @Query("select s from ShelterInformation s where s.roadNameAddress like %:district%")
    List<ShelterInformation> findByDistrict(@Param("district") String district);
}
