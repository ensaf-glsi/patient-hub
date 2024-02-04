package com.ids.patienthub.patient.dao;

import com.ids.patienthub.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
