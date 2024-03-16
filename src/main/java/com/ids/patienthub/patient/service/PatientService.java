package com.ids.patienthub.patient.service;

import com.ids.patienthub.patient.dao.PatientRepository;
import com.ids.patienthub.patient.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Patient> search(Pageable pageable) {
//        System.out.println("page : " + pageable.getPageNumber());
//        System.out.println("size : " + pageable.getPageSize());
        Sort sort = pageable.getSortOr(Sort.by("name"));
        if (pageable.isPaged()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        } else {
            // bug framework ne supporte pas unaged avec un tri
            pageable = Pageable.unpaged(sort);
        }
        return patientRepository.findAll(pageable);
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


    public List<Patient> findByGender(Patient.Gender gender) {
        return patientRepository.findByGender(gender);
    }

    public Page<Patient> findByGender(Patient.Gender gender, Pageable pageable) {
        return patientRepository.findByGender(gender, pageable);
    }

    public Object findRevisions(Long id, Pageable pageable) {
        return patientRepository.findRevisions(id, pageable);
    }

    public Object findRevision(Long id, Long revisionNumber) {
        return patientRepository.findRevision(id, revisionNumber);
    }

}
