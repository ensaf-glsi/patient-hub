package com.ids.patienthub.commons.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@SuperBuilder
@Getter @Setter
@RequiredArgsConstructor @AllArgsConstructor
public abstract class CustomAbstractFullAuditable<PK extends Serializable> extends CustomAbstractAuditable<PK> {

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @LastModifiedBy
    @Column(length = 100)
    private String modifiedBy;

}
