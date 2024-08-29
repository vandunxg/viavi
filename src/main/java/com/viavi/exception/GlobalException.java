package com.viavi.exception;

import com.viavi.utils.ErrorCode;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
public class GlobalException extends RuntimeException {

    ErrorCode errorCode;

}
