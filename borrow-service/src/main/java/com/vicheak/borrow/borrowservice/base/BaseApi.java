package com.vicheak.borrow.borrowservice.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BaseApi<T>(String message,
                         Boolean status,
                         Integer code,
                         LocalDateTime timestamp,
                         T payload) {
}
