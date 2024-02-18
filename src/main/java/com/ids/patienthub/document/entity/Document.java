package com.ids.patienthub.document.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@SuperBuilder
@RequiredArgsConstructor @AllArgsConstructor
public class Document {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    @Column(length = 100)
    private String filename;
    @Column(length = 100)
    private String contentType;
    private Long size;
}
