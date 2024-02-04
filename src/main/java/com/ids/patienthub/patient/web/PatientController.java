package com.ids.patienthub.patient.web;

import com.ids.patienthub.patient.entity.Patient;
import com.ids.patienthub.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
GET /api/v1/patients : récuperer la liste des patients
GET /api/v1/patients/{id} : récuperer seul élement


POST /api/v1/patients : la création d'un nouvel elt
PUT /api/v1/patients/{id} : la mise a jour d un elt
PATCH /api/v1/patients/{id} : la mise a jour partielle d un elt
DELETE /api/v1/patients/{id} : la suppression d'un elt

 */

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> search() {
        return patientService.search();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return patientService.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient create(@Valid @RequestBody Patient patient) {
        return patientService.create(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @Valid @RequestBody Patient patient) {
        return patientService.update(id, patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        patientService.remove(id);
    }

}
