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

    @Value("${jwt.private-key}")
    @NonFinal
    String SECRET_KEY;

    @Value("${jwt.expiration}")
    @NonFinal
    Long EXPIRATION_TIME;

    public String generateAccessToken(User currentUser) {

        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(currentUser.getEmail())
                .issuer("localhost:8080")
                .expirationTime(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .issueTime(new Date())
                .claim("ROLE", "ABC")
                .build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
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
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validToken(String token) {

        Date expiryTime = getExpiryDate(token);

        return expiryTime.after(new Date());

    }

}
