package com.in28minutes.rest.webservice.restfulwebservices.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
