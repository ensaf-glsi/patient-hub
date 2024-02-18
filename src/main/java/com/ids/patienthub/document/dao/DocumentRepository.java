package com.ids.patienthub.document.dao;

import com.ids.patienthub.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DocumentRepository extends JpaRepository<Document, String> {
}
