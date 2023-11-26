package com.example.SpringSecurity.JWT.services.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImpl {

    private String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public String extractUserName(String token){
        return extractClaim(token,Claims::getSubject);
    }

    private <T> T extractClaim(String token , Function<Claims ,T> claimsResolvers ){
     final Claims claims = extractAllClaims(token);
     return claimsResolvers.apply(claims);
    }

    private Key getSignKey(){
     byte[] key = Decoders.BASE64.decode("2313ad32131s2dfd23sa132da3hjh3j1a32asd32h1h3j1h3j13j123hj213h123hj131");
     return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaims(String token){
        return  Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }
}