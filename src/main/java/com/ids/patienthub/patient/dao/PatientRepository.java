package com.ids.patienthub.patient.dao;

import com.ids.patienthub.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

//    @Query("select p from Patient p where p.gender = ?1")
    List<Patient> findByGender(Patient.Gender gender);

//    @Query("select p from Patient p where upper(p.profession) like upper(concat('%', ?1, '%'))")
    List<Patient> findByProfessionContainsIgnoreCase(String profession);

}
