package com.in28minutes.rest.webservice.restfulwebservices.user.service;

import com.in28minutes.rest.webservice.restfulwebservices.exceptions.UserNotFoundException;
import com.in28minutes.rest.webservice.restfulwebservices.posts.repository.entity.Post;
import com.in28minutes.rest.webservice.restfulwebservices.user.repository.entity.User;
import com.in28minutes.rest.webservice.restfulwebservices.user.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) throws UserNotFoundException {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent())
            return userOptional.get();
        else
            throw new UserNotFoundException(String.format("User with id %s does not exist!", id));
    }

    public List<Post> getUserPosts(Integer userId) {
        User user = this.findById(userId);
        return user.getPosts();
    }

    public User createUser(@NotNull User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(@NotNull Integer id) {
        userRepository.deleteById(id);
    }

}
