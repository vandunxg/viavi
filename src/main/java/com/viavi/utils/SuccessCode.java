package com.viavi.utils;

import com.viavi.constant.SuccessStringConstant;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(makeFinal = true)
public enum SuccessCode {

    SUCCESS_REGISTER("SCC1", SuccessStringConstant.REGISTER_SUCCESS_MASSAGE, HttpStatus.OK);

    String code;
    String message;
    HttpStatus httpStatus;

    SuccessCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}