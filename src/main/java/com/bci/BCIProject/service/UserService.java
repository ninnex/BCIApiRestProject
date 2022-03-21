package com.bci.BCIProject.service;

import com.bci.BCIProject.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User saveUser(User user);
    User getUser(UUID id);

}
