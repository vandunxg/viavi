package com.viavi.exception;

import com.viavi.payload.ErrorResponse;
import com.viavi.utils.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleGlobalException {

    @ExceptionHandler(value = {AuthException.class})
    ResponseEntity<ErrorResponse> handleAuthException(AuthException authException) {

        ErrorCode errorCode = authException.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                .code(errorCode.getCode())
                                .message(errorCode.getMessage())
                                .build()
                );

    }

}
