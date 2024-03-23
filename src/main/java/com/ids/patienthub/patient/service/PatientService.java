package com.ids.patienthub.patient.service;

import com.ids.patienthub.commons.exceptions.IncoherentException;
import com.ids.patienthub.patient.dao.PatientRepository;
import com.ids.patienthub.patient.dto.DetailPatientDto;
import com.ids.patienthub.patient.dto.PatientDto;
import com.ids.patienthub.patient.entity.Patient;
import com.ids.patienthub.patient.mappers.PatientMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public List<Patient> search() {
        return patientRepository.findAll();
    }

    public Page<Patient> search(Pageable pageable) {
        // trace
        // debug
        // info
        // warn
        // error
        log.trace("Search patient");
        Sort sort = pageable.getSortOr(Sort.by("name"));
        if (pageable.isPaged()) {
            log.debug("page : {}", pageable.getPageNumber());
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        } else {
            // bug framework ne supporte pas unaged avec un tri
            pageable = Pageable.unpaged(sort);
        }
        return patientRepository.findAll(pageable);
    }

    public Optional<DetailPatientDto> findById(Long id) {
        return patientRepository.findById(id).map(patientMapper::toDto);
    }

    public DetailPatientDto create(PatientDto dto) {
        if (dto.getName().length() <= 2) {
            String reason = "Le nom doit avoir min 3 caractere";
            log.warn(reason);
            throw new IncoherentException(reason);
        }
        return patientMapper.toDto(patientRepository.save(patientMapper.fromDto(dto)));
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
