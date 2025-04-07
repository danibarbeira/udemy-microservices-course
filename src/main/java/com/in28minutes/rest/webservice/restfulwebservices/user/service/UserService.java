package com.in28minutes.rest.webservice.restfulwebservices.user.service;

import com.in28minutes.rest.webservice.restfulwebservices.exceptions.UserNotFoundException;
import com.in28minutes.rest.webservice.restfulwebservices.user.repository.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final List<User> users = new ArrayList<>();

    private static Integer userIdGenerator = 0;

    static {
        users.add(new User(userIdGenerator++, "Adam", LocalDate.now().minusYears(30), null));
        users.add(new User(userIdGenerator++, "Eve", LocalDate.now().minusYears(28), null));
        users.add(new User(userIdGenerator++, "Cain", LocalDate.now().minusYears(10), null));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) throws UserNotFoundException {
        Optional<User> userOptional = users.stream().filter(user -> user.getId().equals(id)).findFirst();

        if (userOptional.isPresent())
            return userOptional.get();
        else
            throw new UserNotFoundException(String.format("User with id %s does not exist!", id));
    }

    public User createUser(@NotNull User user) {
        user.setId(userIdGenerator++);
        users.add(user);
        return user;
    }

    public void deleteUserById(@NotNull Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

}
