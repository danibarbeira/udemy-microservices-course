package com.in28minutes.rest.webservice.restfulwebservices.user.api;

import com.in28minutes.rest.webservice.restfulwebservices.posts.repository.entity.Post;
import com.in28minutes.rest.webservice.restfulwebservices.user.repository.entity.User;
import com.in28minutes.rest.webservice.restfulwebservices.user.service.UserEntityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/jpa")
@RequiredArgsConstructor
public class UserEntityRestController {

    private final UserEntityService userEntityService;

    @GetMapping
    public List<User> retrieveAllUsers() {
        return userEntityService.findAll();
    }

    @GetMapping(path = "/{id}")
    public EntityModel<User> retrieveUserDetails(@PathVariable Integer id) {
        return userToHateoas(userEntityService.findById(id));
    }

    @GetMapping(path = "/{id}/posts")
    public List<Post> getUserPosts(@PathVariable Integer id) {
        return userEntityService.getUserPosts(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User createdUser = userEntityService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userEntityService.deleteUserById(id);
    }

    private EntityModel<User> userToHateoas(User user) {
        EntityModel<User> userEntityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        userEntityModel.add(link.withRel("all-users"));

        return userEntityModel;
    }

}
