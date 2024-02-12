package com.vicheak.borrow.borrowservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record BorrowBookDto(@NotNull @Positive Integer bookId,
                            @NotNull @Positive Integer amountOfBook) {
}
