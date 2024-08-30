package com.viavi.exception;

import com.viavi.payload.ErrorResponse;
import com.viavi.utils.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(value = {PermissionException.class})
    ResponseEntity<ErrorResponse> handlePermissionException(PermissionException exception) {

        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                .code(errorCode.getCode())
                                .message(errorCode.getMessage())
                                .build()
                );

    }

    @ExceptionHandler(value = {RoleException.class})
    ResponseEntity<ErrorResponse> handleRoleException(RoleException exception) {

        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                .code(errorCode.getCode())
                                .message(errorCode.getMessage())
                                .build()
                );

    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        ErrorCode errorCode = ErrorCode.ERROR_INVALID_INPUT;

        int lastIndexOfOpenBracket = exception.getMessage().lastIndexOf('[') + 1;
        int lastIndexOfCloseBracket = exception.getMessage().lastIndexOf(']') - 1;

        String messageDefault = exception.getMessage()
                .substring(lastIndexOfOpenBracket, lastIndexOfCloseBracket);

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                .code(errorCode.getCode())
                                .message(messageDefault)
                                .build()
                );

    }

}
