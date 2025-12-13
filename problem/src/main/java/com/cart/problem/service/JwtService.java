package com.cart.problem.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class JwtService {

    private final static String SECRETKEY = "ThisIsASecretKeyThisIsASecretKeyThisIsASecretKey";
    private final static Long EXPIRY = 1000L * 24 * 60 * 60;

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRETKEY).build().parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRETKEY).build().parseClaimsJws(token).getBody().getSubject();
    }

    public Date extractExpiry(String token) {
        return Jwts.parser().setSigningKey(SECRETKEY).build().parseClaimsJws(token).getBody().getExpiration();
    }

    public String generateToken(String username) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRETKEY).addClaims(new HashMap<>()).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + EXPIRY)).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        Date expiry = extractExpiry(token);

        return username.equalsIgnoreCase(userDetails.getUsername()) && expiry.after(new Date(System.currentTimeMillis()));

    }
}
