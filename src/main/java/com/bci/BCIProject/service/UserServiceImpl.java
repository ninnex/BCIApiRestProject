package com.bci.BCIProject.service;

import com.bci.BCIProject.model.User;
import com.bci.BCIProject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return repository.findById(id);
    }
}
