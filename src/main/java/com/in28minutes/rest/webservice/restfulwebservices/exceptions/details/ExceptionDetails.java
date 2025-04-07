package com.in28minutes.rest.webservice.restfulwebservices.exceptions.details;

import java.time.LocalDateTime;

public record ExceptionDetails(LocalDateTime timestamp, String message, String details) {

}
