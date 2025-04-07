package com.in28minutes.rest.webservice.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeDynamicBeanFilter")
public record SomeDynamicBean(String field1, String field2, String field3) {

}