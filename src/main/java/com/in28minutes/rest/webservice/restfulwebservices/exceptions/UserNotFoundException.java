package com.in28minutes.rest.webservice.restfulwebservices.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
