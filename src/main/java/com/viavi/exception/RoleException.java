package com.viavi.exception;

import com.viavi.utils.ErrorCode;

public class RoleException extends GlobalException {

    public RoleException(ErrorCode errorCode) {
        super(errorCode);
    }

}
