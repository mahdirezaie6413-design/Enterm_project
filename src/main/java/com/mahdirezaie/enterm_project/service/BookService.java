package com.mahdirezaie.enterm_project.service;

import com.mahdirezaie.enterm_project.model.Book;
import com.mahdirezaie.enterm_project.repository.BookRepository;
import com.mahdirezaie.enterm_project.util.BookCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    // دریافت نمونه تکی کش (Singleton Instance)
    private final BookCache bookCache = BookCache.getInstance();

    /**
     * Retrieves all books. Uses cache if available to reduce DB hits.
     */
    public List<Book> getAll() {
        String key = "ALL_BOOKS_LIST";

        // چک کردن وجود داده در کش
        List<Book> cachedBooks = bookCache.get(key);
        if (cachedBooks != null) {
            System.out.println(">>> Cache Hit: Returning books from Memory.");
            return cachedBooks;
        }

        // اگر در کش نبود، از دیتابیس بخوان و کش را پر کن
        System.out.println(">>> Cache Miss: Fetching from Database.");
        List<Book> dbBooks = repository.findAll();
        bookCache.put(key, dbBooks);
        return dbBooks;
    }

    public void add(Book book) {
        repository.save(book);
        invalidateCache(); // باطل کردن کش بعد از اضافه کردن
    }

    public Book update(Long id, Book bookDetails) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setBookType(bookDetails.getBookType());
        book.setNumberOfPages(bookDetails.getNumberOfPages());

        Book updatedBook = repository.save(book);
        invalidateCache(); // باطل کردن کش بعد از ویرایش
        return updatedBook;
    }

    public void delete(Long id) {
        repository.deleteById(id);
        invalidateCache(); // باطل کردن کش بعد از حذف
    }

    // متد کمکی برای رعایت اصول SOLID و جلوگیری از تکرار کد
    private void invalidateCache() {
        System.out.println(">>> Invalidating Cache due to data change.");
        bookCache.clear();
    }
}