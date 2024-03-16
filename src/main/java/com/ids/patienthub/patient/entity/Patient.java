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
