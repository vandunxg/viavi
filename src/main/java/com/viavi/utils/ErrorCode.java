package com.viavi.utils;

import com.viavi.constant.ErrorStringConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public enum ErrorCode {

    ERROR_EXIST_USER("ERR1", ErrorStringConstant.EXIST_USER_ERROR_MASSAGE, HttpStatus.BAD_REQUEST),
    ERROR_USER_NOT_EXIST("ERR2", ErrorStringConstant.USER_NOT_EXIST_ERROR_MASSAGE, HttpStatus.BAD_REQUEST),
    ERROR_EMAIL_OR_PASSWORD_INCORRECT("ERR3", ErrorStringConstant.EMAIL_OR_PASSWORD_INCORRECT_ERROR_MASSAGE, HttpStatus.BAD_REQUEST),
    ERROR_PERMISSION_EXIST("ERR4", ErrorStringConstant.PERMISSION_EXISTED_ERROR_MASSAGE, HttpStatus.BAD_REQUEST),
    ERROR_PERMISSION_NOT_EXIST("ERR5", ErrorStringConstant.PERMISSION_NOT_EXISTED_ERROR_MASSAGE, HttpStatus.BAD_REQUEST),
    ERROR_ROLE_EXIST("ERR6", ErrorStringConstant.ROLE_EXISTED_ERROR_MASSAGE, HttpStatus.BAD_REQUEST),
    ERROR_INVALID_INPUT("ERR6", null, HttpStatus.BAD_REQUEST),
    ;

    String code;
    String message;
    HttpStatus httpStatus;

}
