package com.vicheak.borrow.borrowservice.dto;

import lombok.Builder;

@Builder
public record BorrowingDto(Integer bookId,
                           String borrowerId,
                           Integer amountOfBook,
                           String borrowDate,
                           String dueDate) {
}
