package com.ids.patienthub.document.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class FileNotFoundException extends ResponseStatusException {

    public FileNotFoundException(String reason, Throwable cause) {
        this(404, reason, cause);
    }
    public FileNotFoundException(String reason) {
        this(reason, null);
    }
    public FileNotFoundException() {
        this("The requested file was not found on the server. Please verify the file name and try again.");
    }

    public FileNotFoundException(int rawStatusCode, String reason, Throwable cause) {
        super(HttpStatusCode.valueOf(rawStatusCode), reason, cause);
    }
}
