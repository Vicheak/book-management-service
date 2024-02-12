package com.vicheak.borrow.borrowservice.dto;

import lombok.Builder;

@Builder
public record BorrowerResponseDto(String id,
                                  String name,
                                  String gender,
                                  String birthDate,
                                  String address,
                                  String joinDate) {
}
