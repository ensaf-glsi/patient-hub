package com.ids.patienthub.patient.dao;

import com.ids.patienthub.patient.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>, RevisionRepository<Patient, Long, Long> {

//    @Query("select p from Patient p where p.gender = ?1")
    List<Patient> findByGender(Patient.Gender gender);
    Page<Patient> findByGender(Patient.Gender gender, Pageable pageable);

//    @Query("select p from Patient p where upper(p.profession) like upper(concat('%', ?1, '%'))")
    List<Patient> findByProfessionContainsIgnoreCase(String profession);

}
