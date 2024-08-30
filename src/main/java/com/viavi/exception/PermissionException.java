package com.viavi.exception;

import com.viavi.utils.ErrorCode;

public class PermissionException extends GlobalException {

    public PermissionException(ErrorCode errorCode) {
        super(errorCode);
    }

}
