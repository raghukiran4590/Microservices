package com.cbrk.micro.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("User not found in the server");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
