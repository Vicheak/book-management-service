package com.vicheak.borrow.borrowservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "borrowings")
public class Borrowing {

    //set composite primary key
    @Id
    private BorrowingId borrowingId;
    private Integer amountOfBook;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;

}
