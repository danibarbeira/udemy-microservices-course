package com.in28minutes.rest.webservice.restfulwebservices.versioning;

import lombok.Getter;

@Getter
public class PersonV1 extends Person {

    private final String name;

    public PersonV1(String name, Integer age) {
        super(age);
        this.name = name;
    }
}
