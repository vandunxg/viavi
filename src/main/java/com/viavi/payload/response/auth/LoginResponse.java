package com.viavi.payload.response.auth;

import com.viavi.payload.SuccessResponse;
import com.viavi.utils.SuccessCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {

    String accessToken;
    String refreshToken;
    Long userId;

}
