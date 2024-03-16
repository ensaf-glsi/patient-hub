package com.ids.patienthub.patient.dto;

import com.ids.patienthub.patient.entity.Patient;
import lombok.Builder;

@Builder
public record PatientNameDto (Long id, String name, Patient.Gender gender) {
}
