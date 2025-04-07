package com.in28minutes.rest.webservice.restfulwebservices.posts.api;

import com.in28minutes.rest.webservice.restfulwebservices.posts.repository.entity.Post;
import com.in28minutes.rest.webservice.restfulwebservices.posts.service.PostEntityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostEntityRestController {

    private final PostEntityService postEntityService;

    @GetMapping(path = "/{userId}/{postId}")
    public Post getUserPostById(@PathVariable Integer userId, @PathVariable Integer postId) {
        return postEntityService.getPostById(postId);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Post> createPostForUser(@PathVariable Integer id, @RequestBody @Valid Post post) {
        Post createdPost = this.postEntityService.createPostForUser(id, post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPost.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
