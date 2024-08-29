package com.viavi.service.implement;

import com.viavi.config.JwtToken;
import com.viavi.entity.User;
import com.viavi.exception.AuthException;
import com.viavi.mapper.UserMapper;
import com.viavi.payload.request.auth.LoginRequest;
import com.viavi.payload.request.auth.RegisterRequest;
import com.viavi.payload.response.auth.LoginResponse;
import com.viavi.payload.response.auth.RegisterResponse;
import com.viavi.repository.UserRepository;
import com.viavi.service.AuthService;
import com.viavi.utils.ErrorCode;
import com.viavi.utils.SuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JwtToken jwtToken;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AuthException(ErrorCode.ERROR_EXIST_USER);
        }

        User registerUser = UserMapper.INSTANCE.toUser(request);

        // encode password with password encoder
        registerUser.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(registerUser);

        return new RegisterResponse(SuccessCode.SUCCESS_REGISTER);

    }

    /**
     * @return LoginRequest
     */
    @Override
    public LoginResponse login(LoginRequest request) {

        var userGetByEmail = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new AuthException(ErrorCode.ERROR_USER_NOT_EXIST));

        if (!passwordEncoder.matches(request.getPassword(), userGetByEmail.getPassword())) {
            throw new AuthException(ErrorCode.ERROR_EMAIL_OR_PASSWORD_INCORRECT);
        }

        String token = jwtToken.generateAccessToken(userGetByEmail);

        return LoginResponse.builder()
                .accessToken(token)
                .refreshToken("abc")
                .userId(userGetByEmail.getId())
                .build();

    }

}
