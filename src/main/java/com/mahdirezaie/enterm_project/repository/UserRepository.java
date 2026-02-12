package com.mahdirezaie.enterm_project.repository;

import com.mahdirezaie.enterm_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}