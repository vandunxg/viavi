package com.viavi.exception;

import com.viavi.utils.ErrorCode;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class GlobalException extends RuntimeException {

    ErrorCode errorCode;

}
