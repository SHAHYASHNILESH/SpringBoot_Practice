package com.warehouse.warehouse.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@SuppressWarnings("deprecation")
public class JwtService {

	private final static String SECRET_KEY = "ThisIsASecretKeyThisIsASecretKeyThisIsASecretKey";
	private final static long EXPIRATION_TIME = 24 * 60 * 60 * 1000L;

	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getSubject();

	}

	public Date extractExpiration(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getExpiration();
	}

	public String generateToken(String username) {
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY).addClaims(new HashMap<>())
				.setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).compact();
	}

	public boolean validateToken(String token, UserDetails user) {
		String username = extractUsername(token);
		Date expiration = extractExpiration(token);

		return username.equalsIgnoreCase(user.getUsername()) && expiration.after(new Date(System.currentTimeMillis()));
	}

}
