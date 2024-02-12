package com.vicheak.book.bookservice.service.impl;

import com.vicheak.book.bookservice.client.BorrowingFeignClient;
import com.vicheak.book.bookservice.dto.BookBorrowDetailResponseDto;
import com.vicheak.book.bookservice.dto.BookDto;
import com.vicheak.book.bookservice.dto.BorrowingResponseDto;
import com.vicheak.book.bookservice.entity.Book;
import com.vicheak.book.bookservice.mapper.BookMapper;
import com.vicheak.book.bookservice.repository.BookRepository;
import com.vicheak.book.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BorrowingFeignClient borrowingFeignClient;

    @Override
    public List<Book> loadAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookDto loadBookById(Integer bookId) {
        return BookMapper.toBookDto(bookRepository.findById(bookId)
                .orElseThrow(
                        () -> new RuntimeException("Book does not exist!")
                ));
    }

    @Override
    public BookBorrowDetailResponseDto loadBookBorrowDetail(String correlationId, Integer bookId) {
        BookDto bookDto = loadBookById(bookId);
        List<BorrowingResponseDto> borrowingResponseDtoList =
                borrowingFeignClient.loadBorrowingDetailByBookId(correlationId, bookId);

        return BookBorrowDetailResponseDto.builder()
                .book(bookDto)
                .borrowings(borrowingResponseDtoList)
                .build();
    }

    @Override
    public BookBorrowDetailResponseDto loadBookBorrowDetail(String correlationId, Integer bookId, Throwable ex) {
        BookDto bookDto = loadBookById(bookId);
        return BookBorrowDetailResponseDto.builder()
                .book(bookDto)
                .build();
    }

}
