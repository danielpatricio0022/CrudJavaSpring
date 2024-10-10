package com.app.controller;

import com.app.entity.User;
import com.app.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {

    @Autowired
    private UserRepositoryInterface userRepository;

    public void createUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        userRepository.save(user);
    }

}
