# udemy-microservices-course

## Introduction

This GitHub repository is for the code created on my journey with the [Udemy SpringBoot Microservices](https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/) course.

The course consists in the construction of a social media web application, implementing the back-end following a microservice architecture approach.

## Tech Stack

* Java 21
* H2 Dataabse Engine
* MySQL
* Maven
* Spring Boot
* Spring Web, Spring Data JPA, Spring Hateoas, Spring Actuators
* Lombok
* Swagger/ OpenAPI
* Docker
* Kubernetes

## Architecture

The service will be implemented as a Spring Boot microservice with an internal structure following a layered architecture.

## Building and deployment

Java 21 and Apache Maven are required to build and deploy the project.  Simply run the following command from the projects root directory to clean any previous compilation files and compile, test and package the project:

```mvn clean install```

The project includes an embedded tomcat web server so running the project is hassle-free. Once built and packaged, it can be run from the project root directory using the following command:

```java -jar target/restful-web-services-0.0.1-SNAPSHOT```