package com.vicheak.borrow.borrowservice.repository;

import com.vicheak.borrow.borrowservice.entity.Borrowing;
import com.vicheak.borrow.borrowservice.entity.BorrowingId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BorrowingRepository extends MongoRepository<Borrowing, BorrowingId> {

    List<Borrowing> findByBorrowingIdBookId(Integer bookId);

}
