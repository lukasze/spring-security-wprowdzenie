package com.example.demo.formlogin.model;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class BookRepository {
    private List<Book> books = new CopyOnWriteArrayList<>();

    public BookRepository() {
        books.add(new Book("Prześniona Rewolucja", "Andrzej Leder", "aabbccdd"));
        books.add(new Book("Sapiens. Od zwierząt do bogów", "Yuval Noah Harari", "aabbccee"));
        books.add(new Book("Jak zmienić swój umysł?", "Michael Pollan", "eeddffee"));
    }

    public List<Book> findAll() {
        return Collections.unmodifiableList(books);
    }

    public void persist(Book book) {
        books.add(book);
    }
}
