package com.in28minutes.rest.webservice.restfulwebservices.versioning.api;

import com.in28minutes.rest.webservice.restfulwebservices.versioning.FullName;
import com.in28minutes.rest.webservice.restfulwebservices.versioning.PersonV1;
import com.in28minutes.rest.webservice.restfulwebservices.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonVersion1() {
        return new PersonV1("Bob Charlie", 2);
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonVersion2() {
        return new PersonV2(new FullName("Ryan", "Charlie", "Smith"), 2);
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonVersion1RequestParameter() {
        return new PersonV1("Bob Charlie", 2);
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonVersion2RequestParameter() {
        return new PersonV2(new FullName("Ryan", "Charlie", "Smith"), 2);
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonVersion1RequestHeader() {
        return new PersonV1("Bob Charlie", 2);
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonVersion2RequestHeader() {
        return new PersonV2(new FullName("Ryan", "Charlie", "Smith"), 2);
    }

    @GetMapping(path = "/person/accept", produces = "application/com.in28minutes.person-v1+json")
    public PersonV1 getPersonVersion1AcceptHeader() {
        return new PersonV1("Bob Charlie", 2);
    }

    @GetMapping(path = "/person/accept", produces = "application/com.in28minutes.person-v2+json")
    public PersonV2 getPersonVersion2AcceptHeader() {
        return new PersonV2(new FullName("Ryan", "Charlie", "Smith"), 2);
    }

}
