package com.mahdirezaie.enterm_project.patterns;
import com.mahdirezaie.enterm_project.model.*;

public class BookFactory {
    public static Book createBook(String type) {
        if ("ebook".equalsIgnoreCase(type)) return new EBook();
        return new PrintedBook();
    }
}