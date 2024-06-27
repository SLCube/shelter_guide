package com.slcube.shelter_guide.repository;

import com.slcube.shelter_guide.domain.ShelterInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.slcube.shelter_guide.port.ShelterInformationPort;

import java.util.List;

public interface ShelterInformationRepository extends JpaRepository<ShelterInformation, Long>, ShelterInformationPort {
    @Query("select s from ShelterInformation s where s.businessEstablishmentName in :businessEstablishmentNameList")
    List<ShelterInformation> findByBusinessEstablishmentNameIn(@Param("businessEstablishmentNameList") List<String> businessEstablishmentNameList);

    @Query("select s from ShelterInformation s where s.roadNameAddress like %:district%")
    List<ShelterInformation> findByDistrict(@Param("district") String district);
}
