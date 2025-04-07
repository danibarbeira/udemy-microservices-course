package com.in28minutes.rest.webservice.restfulwebservices.user.repository;

import com.in28minutes.rest.webservice.restfulwebservices.user.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
