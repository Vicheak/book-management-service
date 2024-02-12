package com.vicheak.book.bookservice.service;

import com.vicheak.book.bookservice.dto.BookBorrowDetailResponseDto;
import com.vicheak.book.bookservice.dto.BookDto;
import com.vicheak.book.bookservice.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> loadAllBooks();

    BookDto loadBookById(Integer bookId);

    BookBorrowDetailResponseDto loadBookBorrowDetail(String correlationId, Integer bookId);

    BookBorrowDetailResponseDto loadBookBorrowDetail(String correlationId, Integer bookId, Throwable ex);

}
