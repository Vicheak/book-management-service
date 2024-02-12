package com.vicheak.book.bookservice.dto;

import lombok.Builder;

@Builder
public record BorrowingResponseDto(Integer bookId,
                                   String borrowerId,
                                   Integer amountOfBook,
                                   String borrowDate,
                                   String dueDate) {
}
