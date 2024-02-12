package com.vicheak.book.bookservice.repository;

import com.vicheak.book.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {



}
