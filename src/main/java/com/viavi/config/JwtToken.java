package com.viavi.config;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.viavi.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class JwtToken {

    @NonFinal
    @Value("${jwt.private-key.access-token}")
    String ACCESS_TOKEN_KEY;

    @Value("${jwt.expiration.access-token}")
    @NonFinal
    Long EXPIRATION_ACCESS_TOKEN;

    public String generateAccessToken(User currentUser) {

        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(currentUser.getEmail())
                .issuer("localhost:8080")
                .expirationTime(new Date(System.currentTimeMillis() + 1000 * EXPIRATION_ACCESS_TOKEN))
                .issueTime(new Date())
                .claim("ROLE", "ABC")
                .build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(ACCESS_TOKEN_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new RuntimeException(exception);
        }

    }

    String getEmailFromClaim(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    Date getExpiryDate(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validToken(String token) {

        Date expiryTime = getExpiryDate(token);

        return expiryTime.after(new Date());

    }

}
