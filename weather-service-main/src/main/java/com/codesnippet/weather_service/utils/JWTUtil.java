package com.codesnippet.weather_service.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
	private final String SECRET = "my-super-secret-key-that-is-long-enough-1234567890!@#";
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	public String extractUsername(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String username, UserDetails userByUsername, String token) {
		// TODO Auto-generated method stub
		return username.equalsIgnoreCase(userByUsername.getUsername()) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getExpiration()
				.before(new Date());
	}
}
