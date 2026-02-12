package com.mahdirezaie.enterm_project.repository;

import com.mahdirezaie.enterm_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}