package com.vicheak.book.bookservice.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BookBorrowDetailResponseDto(BookDto book,
                                          List<BorrowingResponseDto> borrowings) {
}
