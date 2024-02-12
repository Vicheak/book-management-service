package com.vicheak.borrow.borrowservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record BorrowerDto(@NotBlank String id,
                          @NotBlank String name,
                          @NotBlank String gender,
                          @NotBlank String birthDate,
                          @NotBlank String address) {
}
