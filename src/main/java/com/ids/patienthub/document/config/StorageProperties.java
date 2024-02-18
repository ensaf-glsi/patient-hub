package com.ids.patienthub.document.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("storage")
@Data
public class StorageProperties {
	private String location = "upload-dir";
}
