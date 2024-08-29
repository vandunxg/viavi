package com.viavi.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;

import javax.crypto.spec.SecretKeySpec;
import java.util.Objects;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomJwtDecoder implements JwtDecoder {

    @NonFinal
    @Value("${jwt.private-key.access-token}")
    String ACCESS_TOKEN_KEY;

    JwtToken jwtToken;

    @NonFinal
    NimbusJwtDecoder jwtDecoder = null;

    @Override
    public Jwt decode(String token) throws JwtException {

        if (!jwtToken.validToken(token)) {
            throw new JwtException("Token invalid");
        }

        if (Objects.isNull(jwtDecoder)) {
            jwtDecoder = NimbusJwtDecoder
                    .withSecretKey(new SecretKeySpec(ACCESS_TOKEN_KEY.getBytes(), "HS256"))
                    .macAlgorithm(MacAlgorithm.HS256)
                    .build();
        }

        return jwtDecoder.decode(token);

    }
}
