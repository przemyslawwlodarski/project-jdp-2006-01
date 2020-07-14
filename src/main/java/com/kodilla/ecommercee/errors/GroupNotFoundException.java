package com.kodilla.ecommercee.errors;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "group not found")
public class GroupNotFoundException extends Exception {
    public GroupNotFoundException(String message) {
        super(message);
    }

    public GroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
