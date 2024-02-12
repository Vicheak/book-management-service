package com.vicheak.borrow.borrowservice.service.impl;

import com.vicheak.borrow.borrowservice.client.BookFeignClient;
import com.vicheak.borrow.borrowservice.dto.BookResponseDto;
import com.vicheak.borrow.borrowservice.dto.BorrowDto;
import com.vicheak.borrow.borrowservice.dto.BorrowingDto;
import com.vicheak.borrow.borrowservice.entity.Borrowing;
import com.vicheak.borrow.borrowservice.entity.BorrowingId;
import com.vicheak.borrow.borrowservice.mapper.BorrowerMapper;
import com.vicheak.borrow.borrowservice.repository.BorrowerRepository;
import com.vicheak.borrow.borrowservice.repository.BorrowingRepository;
import com.vicheak.borrow.borrowservice.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final BorrowerRepository borrowerRepository;
    private final BorrowerMapper borrowerMapper;
    private final BookFeignClient bookFeignClient;

    @Transactional
    @Override
    public void createNewBorrow(String correlationId, BorrowDto borrowDto) {
        //check if borrower exists
        if (!borrowerRepository.existsById(borrowDto.borrowerId()))
            throw new RuntimeException("Borrower does not exist!");

        borrowDto.borrowings().forEach(borrowBookDto -> {
            //check if book exists
            //call book service via feign client
            BookResponseDto bookResponseDto = bookFeignClient.loadBookById(correlationId, borrowBookDto.bookId());
            if (Objects.isNull(bookResponseDto))
                throw new RuntimeException("Book does not exist!");

            Borrowing borrowing = borrowerMapper.toBorrowing(borrowDto);
            borrowing.setBorrowingId(BorrowingId.builder()
                    .borrowerId(borrowDto.borrowerId())
                    .bookId(borrowBookDto.bookId())
                    .build());
            borrowing.setAmountOfBook(borrowBookDto.amountOfBook());

            borrowingRepository.save(borrowing);
        });
    }

    @Override
    public List<BorrowingDto> loadBorrowingDetailByBookId(String correlationId, Integer bookId) {
        //check if book exists
        //call book service via feign client
        BookResponseDto bookResponseDto = bookFeignClient.loadBookById(correlationId, bookId);
        if (Objects.isNull(bookResponseDto))
            throw new RuntimeException("Book does not exist!");

        List<Borrowing> borrowings = borrowingRepository.findByBorrowingIdBookId(bookId);

        List<BorrowingDto> borrowDetails = new ArrayList<>();

        borrowings.forEach(borrowing -> borrowDetails.add(
                BorrowingDto.builder()
                        .bookId(borrowing.getBorrowingId().getBookId())
                        .borrowerId(borrowing.getBorrowingId().getBorrowerId())
                        .amountOfBook(borrowing.getAmountOfBook())
                        .borrowDate(borrowing.getBorrowDate().toString())
                        .dueDate(borrowing.getDueDate().toString())
                        .build()
        ));

        return borrowDetails;
    }

}
