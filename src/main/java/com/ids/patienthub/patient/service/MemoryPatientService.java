package com.ids.patienthub.patient.service;

import com.ids.patienthub.patient.entity.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemoryPatientService {
    private List<Patient> patientList = new ArrayList<>();

    private static AtomicLong counter = new AtomicLong();

    MemoryPatientService() {
        patientList.add(
                Patient.builder()
                        .id(counter.incrementAndGet())
                        .name("Miss Jody Kilback")
                        .birthDate(LocalDate.of(1990, 1, 1))
                        .build()
        );
        patientList.add(
                Patient.builder()
                        .id(counter.incrementAndGet())
                        .name("Mrs. Guadalupe Klein")
                        .birthDate(LocalDate.of(1995, 1, 1))
                        .build()
        );
    }

    public List<Patient> search() {
        return patientList;
    }

    public Optional<Patient> findById(Long id) {
        return patientList.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
    }

    public Patient create(Patient patient) {
        patient.setId(counter.incrementAndGet());
        patientList.add(patient);
        return patient;
    }

    public Patient update(Long id, Patient patient) {
        patient.setId(id);
        Integer index = patientList.indexOf(patient);
        if (index == -1) {
            throw new NoSuchElementException("No Patient with id : " + id);
        } else {
            patientList.set(index, patient);
            return patient;
        }
    }

    public void remove(Long id) {
        if (!patientList.remove(Patient.builder().id(id).build())) {
            throw new NoSuchElementException("No Patient with id : " + id);
        }
    }
}
