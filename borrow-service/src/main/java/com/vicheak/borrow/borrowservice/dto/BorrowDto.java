package com.vicheak.borrow.borrowservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

@Builder
public record BorrowDto(@NotBlank String borrowerId,
                        @NotNull @Size(min = 1) List<@NotNull BorrowBookDto> borrowings,
                        @NotBlank String borrowDate,
                        @NotBlank String dueDate) {
}
