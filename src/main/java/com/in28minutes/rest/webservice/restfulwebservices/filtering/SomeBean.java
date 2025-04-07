package com.in28minutes.rest.webservice.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("field1")
public record SomeBean(String field1, @JsonIgnore String field2, String field3) {

}
