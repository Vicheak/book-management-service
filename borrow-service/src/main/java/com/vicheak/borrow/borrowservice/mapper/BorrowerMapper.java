package com.vicheak.borrow.borrowservice.mapper;

import com.vicheak.borrow.borrowservice.dto.BorrowDto;
import com.vicheak.borrow.borrowservice.dto.BorrowerDto;
import com.vicheak.borrow.borrowservice.dto.BorrowerResponseDto;
import com.vicheak.borrow.borrowservice.entity.Borrower;
import com.vicheak.borrow.borrowservice.entity.Borrowing;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowerMapper {

    Borrower toBorrower(BorrowerDto borrowerDto);

    BorrowerResponseDto toBorrowerResponseDto(Borrower borrower);

    List<BorrowerResponseDto> toBorrowerResponseDto(List<Borrower> borrowers);

    Borrowing toBorrowing(BorrowDto borrowDto);

}
