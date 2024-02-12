package com.vicheak.borrow.borrowservice.repository;

import com.vicheak.borrow.borrowservice.entity.Borrower;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowerRepository extends MongoRepository<Borrower, String> {



}
