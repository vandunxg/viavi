package com.viavi.exception;

import com.viavi.utils.ErrorCode;


public class AuthException extends GlobalException {

    public AuthException(ErrorCode errorCode) {
        super(errorCode);
    }

}
