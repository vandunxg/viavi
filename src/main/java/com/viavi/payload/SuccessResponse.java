package com.viavi.payload;

import com.viavi.utils.SuccessCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class SuccessResponse {

    String code;
    String message;
    LocalDateTime issueAt = LocalDateTime.now();

    protected SuccessResponse(SuccessCode successCode) {
        this.code = successCode.getCode();
        this.message = successCode.getMessage();
    }

}
