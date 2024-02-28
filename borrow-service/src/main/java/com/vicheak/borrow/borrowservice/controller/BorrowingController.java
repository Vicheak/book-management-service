package com.vicheak.borrow.borrowservice.controller;

import com.vicheak.borrow.borrowservice.dto.BorrowDto;
import com.vicheak.borrow.borrowservice.dto.BorrowingDto;
import com.vicheak.borrow.borrowservice.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/borrowings")
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewBorrow(@RequestHeader(name = "bookservice-correlation-id", required = false) String correlationId,
                                @RequestBody BorrowDto borrowDto) {

        //log.debug("bookservice-correlation-id found in borrow service : {}", correlationId);

        borrowingService.createNewBorrow(correlationId, borrowDto);
    }

    @GetMapping("/bookBorrowDetail/{bookId}")
    public ResponseEntity<List<BorrowingDto>> loadBorrowingDetailByBookId(@RequestHeader(name = "bookservice-correlation-id", required = false) String correlationId,
                                                                          @PathVariable Integer bookId) {

        //log.debug("bookservice-correlation-id found in borrow service : {}", correlationId);

        log.debug("fetchBorrowingDetailByBookId started!");

        List<BorrowingDto> borrowingDtos =
                borrowingService.loadBorrowingDetailByBookId(correlationId, bookId);

        log.debug("fetchBorrowingDetailByBookId ended!");

        return ResponseEntity.ok(borrowingDtos);
    }

}
