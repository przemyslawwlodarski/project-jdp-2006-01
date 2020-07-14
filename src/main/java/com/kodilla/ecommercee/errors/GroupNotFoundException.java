package com.kodilla.ecommercee.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "group not found")
public class GroupNotFoundException extends Exception {
    public GroupNotFoundException(String message) {
        super(message);
    }

    public GroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
