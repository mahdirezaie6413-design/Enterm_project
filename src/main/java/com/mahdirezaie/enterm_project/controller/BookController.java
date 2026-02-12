package com.mahdirezaie.enterm_project.controller;

import com.mahdirezaie.enterm_project.model.Book;
import com.mahdirezaie.enterm_project.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Book> getAll() { return service.findAll(); }

    @PostMapping("/add")
    public Book add(@RequestBody Book book) { return service.save(book); }

    @PutMapping("/update/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return service.update(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Book deleted successfully!";
    }
}