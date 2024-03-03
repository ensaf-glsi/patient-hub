package com.ids.patienthub.patient.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
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

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(updatable = false)
    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @LastModifiedBy
    private String modifiedBy;

    public static enum Gender {
        MALE, FEMALE
    }
    public static enum FamilyStatus {
        SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED
    }

}
