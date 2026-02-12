package com.mahdirezaie.enterm_project.patterns;

import com.mahdirezaie.enterm_project.model.User;

public class UserBuilder {
    private String username;
    private String email;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public User build() {
        User user = new User();
        user.setUsername(this.username);
        user.setEmail(this.email);
        return user;
    }
}