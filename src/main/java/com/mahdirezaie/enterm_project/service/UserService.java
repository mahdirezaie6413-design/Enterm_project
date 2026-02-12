package com.mahdirezaie.enterm_project.service;

import com.mahdirezaie.enterm_project.model.User;
import com.mahdirezaie.enterm_project.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) { this.repository = repository; }

    public User save(User user) { return repository.save(user); }
}