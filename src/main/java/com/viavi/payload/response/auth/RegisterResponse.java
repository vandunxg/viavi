package com.viavi.payload.response.auth;

import com.viavi.payload.SuccessResponse;
import com.viavi.utils.SuccessCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterResponse extends SuccessResponse {

    public RegisterResponse(SuccessCode successCode){
        super(successCode);
    }

    public RegisterResponse(){
        super();

    }


}
