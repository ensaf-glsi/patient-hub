package com.ids.patienthub.patient.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@SuperBuilder
@Data
@RequiredArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    @NotBlank @Length(max = 100)
    private String name;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private FamilyStatus familyStatus;
    private String profession;
    @Enumerated(EnumType.STRING)
    private Mutual mutual;


    public static enum Gender {
        MALE, FEMALE
    }
    public static enum FamilyStatus {
        SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED
    }

}
