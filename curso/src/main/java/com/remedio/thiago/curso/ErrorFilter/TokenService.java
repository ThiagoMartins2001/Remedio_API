package com.remedio.thiago.curso.ErrorFilter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.remedio.thiago.curso.User.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
    var algorithm = Algorithm.HMAC256(secret);
    return JWT.create()
        .withIssuer("Remedio_API")
        .withSubject(user.getLogin())
        .withClaim("id", user.getId())
        .withExpiresAt(expirationDate())
        .sign(algorithm);
} catch (JWTCreationException exception){
    throw new RuntimeException("Erro ao Gerar token", exception);
}   
    }
    public String getSubject(String TokenJWT){
        try {
            var algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
            .withIssuer("Remedio_API")
            .build()
            .verify(TokenJWT)
            .getSubject();
            
    } catch (JWTVerificationException exception){
        throw new RuntimeException("Token invalido ou expirado");
    }
    }
    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    
}

