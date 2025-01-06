package com.nitesh.services;


import com.nitesh.entities.User;
import com.nitesh.exceptions.UserNotFoundException;
import com.nitesh.repositories.UserRepository;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;

import static com.nitesh.constants.Constant.DOES_NOT_EXIST;

@Singleton
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, @NonNull User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format(DOES_NOT_EXIST, id)));

        existingUser.setContact(user.getContact());
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());

        return userRepository.update(existingUser);
    }

    public String deleteUser(Long id) throws UserNotFoundException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format(DOES_NOT_EXIST, id)));
        userRepository.delete(existingUser);
        return String.format("User with ID %d has been deleted successfully", id);
    }

}
