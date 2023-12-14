package com.demolesson.learning.repositories.abstracts;

import com.demolesson.learning.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
