package com.mahdirezaie.enterm_project.controller;

import com.mahdirezaie.enterm_project.model.User;
import com.mahdirezaie.enterm_project.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @PostMapping("/register")
    public User register(@RequestBody User user) { return service.save(user); }
}