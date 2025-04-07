package com.in28minutes.rest.webservice.restfulwebservices.versioning;

import lombok.Getter;

@Getter
public class PersonV2 extends Person {

    private FullName fullName;

    public PersonV2(FullName fullName, Integer age) {
        super(age);
        this.fullName = fullName;
    }

}
