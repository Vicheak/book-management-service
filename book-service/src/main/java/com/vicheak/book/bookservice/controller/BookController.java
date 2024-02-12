package com.vicheak.book.bookservice.controller;

import com.vicheak.book.bookservice.base.BaseApi;
import com.vicheak.book.bookservice.dto.BookDto;
import com.vicheak.book.bookservice.mapper.BookMapper;
import com.vicheak.book.bookservice.service.BookService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public BaseApi<?> loadAllBooks() {
        return BaseApi.builder()
                .message("successfully loaded!")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .payload(bookService.loadAllBooks().stream()
                        .map(BookMapper::toBookDto)
                        .toList())
                .build();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> loadBookById(@RequestHeader(name = "bookservice-correlation-id", required = false) String correlationId,
                                                @PathVariable Integer bookId) {

        log.debug("bookservice-correlation-id found in book service : {}", correlationId);

        return ResponseEntity.ok(bookService.loadBookById(bookId));
    }

    @CircuitBreaker(name = "bookBorrowDetailSupport", fallbackMethod = "loadBookBorrowDetailDefault")
    //@Retry(name = "bookBorrowDetailRetry", fallbackMethod = "loadBookBorrowDetailDefault")
    //@RateLimiter(name = "bookBorrowDetailRateLimit", fallbackMethod = "loadBookBorrowDetailDefault")
    @GetMapping("/bookBorrowDetail/{bookId}")
    public BaseApi<?> loadBookBorrowDetail(@RequestHeader(name = "bookservice-correlation-id", required = false) String correlationId,
                                           @PathVariable Integer bookId) {

        log.debug("bookservice-correlation-id found in book service : {}", correlationId);

        return BaseApi.builder()
                .message("Book borrow detail successfully loaded!")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .payload(bookService.loadBookBorrowDetail(correlationId, bookId))
                .build();
    }

    //fallback mechanism for resiliency
    public BaseApi<?> loadBookBorrowDetailDefault(@RequestHeader(name = "bookservice-correlation-id", required = false) String correlationId,
                                                  @PathVariable Integer bookId, Throwable ex) {

        log.debug("bookservice-correlation-id found in book service : {}", correlationId);

        return BaseApi.builder()
                .message("Default Book borrow detail successfully loaded!")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .payload(bookService.loadBookBorrowDetail(correlationId, bookId, ex))
                .build();
    }

}
