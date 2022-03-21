package com.bci.BCIProject.service;

import com.bci.BCIProject.exception.ItemNotFoundException;
import com.bci.BCIProject.model.User;
import com.bci.BCIProject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public User saveUser(User user) {
        user.setCreatedTime(OffsetDateTime.now().now());
        user.setModifiedTime(OffsetDateTime.now());
        user.setLastLogin(OffsetDateTime.now());
        System.out.println("user = " + user);
        return repository.save(user);
    }

    @Override
    public User getUser(UUID id) {
        return repository.findById(id).orElseThrow(ItemNotFoundException::new);
    }
}
