package com.ids.patienthub.patient.entity;

import com.ids.patienthub.commons.jpa.entity.CustomAbstractFullAuditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Audited
@Entity
@SuperBuilder
@Getter @Setter
@ToString
@RequiredArgsConstructor @AllArgsConstructor
public class Patient extends CustomAbstractFullAuditable<Long> {

    @Column(length = 100)
    @NotBlank @Length(max = 100)
    private String name;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private FamilyStatus familyStatus;
    @Column(length = 120)
    private String profession;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Mutual mutual;


    public enum Gender {
        MALE, FEMALE
    }
    public enum FamilyStatus {
        SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED
    }

}
