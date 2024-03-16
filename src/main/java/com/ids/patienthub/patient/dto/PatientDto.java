package com.ids.patienthub.patient.dto;

import com.ids.patienthub.patient.entity.Mutual;
import com.ids.patienthub.patient.entity.Patient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@SuperBuilder
@Data
@RequiredArgsConstructor
public class PatientDto {
    private Long id;
    @NotBlank
    @Length(max = 100)
    private String name;
    private LocalDate birthDate;
    private Patient.Gender gender;
    private Patient.FamilyStatus status;
    private String profession;
    private Mutual mutual;

}
