package com.mahdirezaie.enterm_project.util;

import com.mahdirezaie.enterm_project.model.Book;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Singleton class to handle In-Memory Caching for Books.
 * Follows SOLID principles and layered architecture constraints.
 */
public class BookCache {
    private static BookCache instance;

    // استفاده از ConcurrentHashMap برای امنیت در دسترسی‌های همزمان
    private final ConcurrentHashMap<String, List<Book>> cacheStorage = new ConcurrentHashMap<>();

    // سازنده خصوصی (Private Constructor) برای رعایت الگوی Singleton
    private BookCache() {}

    public static synchronized BookCache getInstance() {
        if (instance == null) {
            instance = new BookCache();
        }
        return instance;
    }

    public void put(String key, List<Book> data) {
        cacheStorage.put(key, data);
    }

    public List<Book> get(String key) {
        return cacheStorage.get(key);
    }

    // متد برای باطل کردن کش (Cache Invalidation)
    public void clear() {
        cacheStorage.clear();
    }
}