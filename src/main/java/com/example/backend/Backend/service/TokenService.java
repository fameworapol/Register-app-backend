package com.example.backend.Backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.backend.Backend.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {
    @Value("${app.token.secret}")
    private String secret;

    @Value("${app.token.issuer}")
    private String issuer;

    //Create Token
    public String tokenize(User user){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,120);
        Date ExpireAt = calendar.getTime();
        String token = JWT.create()
                .withIssuer(issuer)
                .withClaim("principal",user.getId())
                .withClaim("role","USER")
                .withExpiresAt(ExpireAt)
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    public DecodedJWT verify(String token){
        try{
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer(issuer)
                    .build();
            return verifier.verify(token);
        }catch (Exception e){
            return null;
        }
    }
}
