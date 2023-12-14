package com.demolesson.learning.controller;

import com.demolesson.learning.entity.Book;
import com.demolesson.learning.services.abstracts.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getOneBook(@PathVariable int id){
        return ResponseEntity.ok(service.findById(id).get());
    }

    @PostMapping()
    public void createBook(@RequestBody Book theBook){
        service.save(theBook);
    }

    @PutMapping()
    public void updateBook(@RequestBody Book theBook){
        service.update(theBook);
    }

    @DeleteMapping("/{id}")
    public void updateBook(@PathVariable int id){
        service.delete(id);
    }
}
