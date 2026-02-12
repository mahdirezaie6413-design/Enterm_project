package com.mahdirezaie.enterm_project.service;

import com.mahdirezaie.enterm_project.model.Book;
import com.mahdirezaie.enterm_project.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() { return repository.findAll(); }

    public Book save(Book book) { return repository.save(book); }

    public Book update(Long id, Book details) {
        Book book = repository.findById(id).orElseThrow();
        book.setTitle(details.getTitle());
        book.setAuthor(details.getAuthor());
        book.setBookType(details.getBookType());
        book.setNumberOfPages(details.getNumberOfPages());
        return repository.save(book);
    }

    public void delete(Long id) { repository.deleteById(id); }
}