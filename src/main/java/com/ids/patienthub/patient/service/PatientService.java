package com.ids.patienthub.patient.service;

import com.ids.patienthub.patient.dao.PatientRepository;
import com.ids.patienthub.patient.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> search() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Long id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }

    public void remove(Long id) {
        patientRepository.deleteById(id);
    }
}
