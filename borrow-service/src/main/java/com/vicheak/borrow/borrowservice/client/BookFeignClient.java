package com.vicheak.borrow.borrowservice.client;

import com.vicheak.borrow.borrowservice.dto.BookResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "book")
public interface BookFeignClient {

    @GetMapping("/api/books/{bookId}")
    BookResponseDto loadBookById(@RequestHeader(name = "bookservice-correlation-id", required = false) String correlationId,
                                 @PathVariable Integer bookId);

}
