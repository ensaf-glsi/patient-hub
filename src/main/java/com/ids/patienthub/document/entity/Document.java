package com.ids.patienthub.document.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.envers.Audited;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(of = "id")
@SuperBuilder
@RequiredArgsConstructor @AllArgsConstructor
public class Document {
    @Id
    @Column(nullable = false, length = 80)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    @Audited
    @Column(length = 100)
    private String filename;
    @Audited
    @Column(length = 200)
    private String contentType;
    private Long size;

}
