package com.bci.BCIProject.services;

import com.bci.BCIProject.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUser(UUID id);

}
