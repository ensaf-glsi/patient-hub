package com.ids.patienthub.document.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class StorageException extends ResponseStatusException {

    public StorageException(String reason, Throwable cause) {
        this(400, reason, cause);
    }
    public StorageException(String reason) {
        this(reason, null);
    }

    public StorageException() {
        this("There was an error processing your file. Please ensure the file meets the requirements and try again.");
    }

    public StorageException(int rawStatusCode, String reason, Throwable cause) {
        super(HttpStatusCode.valueOf(rawStatusCode), reason, cause);
    }
}
