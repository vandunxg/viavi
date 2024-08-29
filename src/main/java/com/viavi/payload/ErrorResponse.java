package com.viavi.payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    String code;
    String message;
    final LocalDateTime errorAt = LocalDateTime.now();

}
