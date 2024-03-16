package com.ids.patienthub.document.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.core.io.Resource;

@Data
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
public class DocumentDto {
    private String filename;
    private String contentType;
    private Long size;
    private Resource resource;
}
