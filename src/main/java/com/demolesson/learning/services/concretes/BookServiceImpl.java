package com.demolesson.learning.services.concretes;

import com.demolesson.learning.entity.Book;
import com.demolesson.learning.exception.badrequest.BookBadRequestException;
import com.demolesson.learning.exception.notfound.BookNotFoundException;
import com.demolesson.learning.repositories.abstracts.BookRepository;
import com.demolesson.learning.services.abstracts.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Book theBook) {

        Optional.ofNullable(theBook)
                        .orElseThrow(() ->
                                new BookBadRequestException("The Book is cannot be null.")
                        );

        repository.save(theBook);
    }

    @Override
    public Optional<Book> findById(int id) {
        Optional<Book> book = repository.findById(id);

        book.orElseThrow(() ->
                new BookNotFoundException("The book cannot found with id: "+id)
        );

        return  book;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Book theBook) {
        findById(theBook.getId());// todo bu sekilde saglıklı olmaz ortak method yaz
        repository.save(theBook);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
