package com.vicheak.borrow.borrowservice.dto;

import lombok.Builder;

@Builder
public record BookResponseDto(String name,
                              String author,
                              String publishDate) {
}
