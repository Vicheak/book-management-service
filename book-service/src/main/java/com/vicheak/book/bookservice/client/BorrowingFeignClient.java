package com.vicheak.book.bookservice.client;

import com.vicheak.book.bookservice.dto.BorrowingResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "borrow")
public interface BorrowingFeignClient {

    @GetMapping("/api/borrowings/bookBorrowDetail/{bookId}")
    List<BorrowingResponseDto> loadBorrowingDetailByBookId(@RequestHeader(name = "bookservice-correlation-id", required = false) String correlationId,
                                                           @PathVariable Integer bookId);

}
