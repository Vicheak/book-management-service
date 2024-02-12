package com.vicheak.borrow.borrowservice.service;

import com.vicheak.borrow.borrowservice.dto.BorrowDto;
import com.vicheak.borrow.borrowservice.dto.BorrowingDto;

import java.util.List;

public interface BorrowingService {

    void createNewBorrow(String correlationId, BorrowDto borrowDto);

    List<BorrowingDto> loadBorrowingDetailByBookId(String correlationId, Integer bookId);

}
