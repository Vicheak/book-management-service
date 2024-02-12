package com.vicheak.borrow.borrowservice.service;

import com.vicheak.borrow.borrowservice.dto.BorrowerDto;
import com.vicheak.borrow.borrowservice.dto.BorrowerResponseDto;

import java.util.List;

public interface BorrowerService {

     List<BorrowerResponseDto> loadAllBorrowers();

     void createNewBorrower(BorrowerDto borrowerDto);

}
