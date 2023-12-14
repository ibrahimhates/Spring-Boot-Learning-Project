package com.demolesson.learning.services.abstracts;

import com.demolesson.learning.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(Book theBook);
    Optional<Book> findById(int id);
    List<Book> findAll();
    void update(Book theBook);
    void delete(int id);
}
