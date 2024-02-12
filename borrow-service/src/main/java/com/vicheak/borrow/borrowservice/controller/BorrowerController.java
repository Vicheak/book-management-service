package com.vicheak.borrow.borrowservice.controller;

import com.vicheak.borrow.borrowservice.base.BaseApi;
import com.vicheak.borrow.borrowservice.dto.BorrowerDto;
import com.vicheak.borrow.borrowservice.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/borrowers")
@RequiredArgsConstructor
public class BorrowerController {

    private final BorrowerService borrowerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public BaseApi<?> loadAllBorrowers() {
        return BaseApi.builder()
                .message("successfully loaded!")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .payload(borrowerService.loadAllBorrowers())
                .build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewBorrower(@RequestBody BorrowerDto borrowerDto){
        borrowerService.createNewBorrower(borrowerDto);
    }

}
