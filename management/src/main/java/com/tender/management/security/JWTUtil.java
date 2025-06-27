package com.tender.management.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	private final static String SECRET_KEY = "ThisIsASecretKeyThisIsASecretKeyThisIsASecretKey";
	private final static long EXPIRATION = 24 * 60 * 60 * 1000L;

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getSubject();
	}

	public Date extractExpiration(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getExpiration();
	}

	public String generateToken(String username) {
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY).setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)).compact();
	}

	public boolean validateToken(String token, String username1) {
		// TODO Auto-generated method stub
		String username = extractUsername(token);
		Date expiration = extractExpiration(token);

		return username.equalsIgnoreCase(username1) && expiration.after(new Date(System.currentTimeMillis()));
	}

}
