package com.ids.patienthub.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class IncoherentException extends ResponseStatusException {
    public IncoherentException(HttpStatusCode status) {
        super(status);
    }

    public IncoherentException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public IncoherentException(HttpStatusCode status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public IncoherentException(String reason) {
        this(HttpStatus.BAD_REQUEST, reason);
    }
}
