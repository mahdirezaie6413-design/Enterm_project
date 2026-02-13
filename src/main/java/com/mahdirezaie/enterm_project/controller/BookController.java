package com.mahdirezaie.enterm_project.controller;

import com.mahdirezaie.enterm_project.model.Book;
import com.mahdirezaie.enterm_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        // نام متد باید با تغییرات جدید در Service هماهنگ باشد
        return bookService.getAll();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}