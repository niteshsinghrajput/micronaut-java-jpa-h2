package com.nitesh.controllers;

import com.nitesh.entities.User;
import com.nitesh.exceptions.UserNotFoundException;
import com.nitesh.services.UserService;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller("/users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @Get("/{id}")
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUser(id)
                .orElseThrow(() ->  new UserNotFoundException("User ID does not exist in our database"));
    }

    @Post
    public User createUser(@Body User user) {
        return userService.createUser(user);
    }

    @Put("/{id}")
    public User updateUser(@PathVariable Long id, @Body User user) {
        return userService.updateUser(id, user);
    }

    @Delete("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
