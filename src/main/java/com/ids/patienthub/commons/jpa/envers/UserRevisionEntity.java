package com.ids.patienthub.commons.jpa.envers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@Table(name = "revinfo", schema = "history")
@RevisionEntity(UserRevisionListener.class)
@SuperBuilder
@AllArgsConstructor @RequiredArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class UserRevisionEntity {
    @Id
    @GeneratedValue
    @RevisionNumber
    private long id;
    @RevisionTimestamp
    private long timestamp;
    private String editor;

}
