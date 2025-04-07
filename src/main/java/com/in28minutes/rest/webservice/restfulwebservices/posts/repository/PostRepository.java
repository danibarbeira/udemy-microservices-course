package com.in28minutes.rest.webservice.restfulwebservices.posts.repository;

import com.in28minutes.rest.webservice.restfulwebservices.posts.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
