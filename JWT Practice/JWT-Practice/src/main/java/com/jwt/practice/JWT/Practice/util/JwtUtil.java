package com.jwt.practice.JWT.Practice.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// STEP : 5 - Create JwtUtil Class
// Start of JWT

@Component
@SuppressWarnings("deprecation")
public class JwtUtil {

	// Individual Key-Value pair is called Claim
	// Complete Json Object is called Claims

	// JWT Consists of Header, Payload & Signature
	// We are interested only in Subject and Expiry date

	// JWT Header : {
	// "alg":"HS256",
	// "typ":"JWT"
	// }

	// JWT Payload : {
	// "sub":"1234559458953",
	// "name":"John doe",
	// "ist":1212334455596
	// }

	// JWT Secret Key requires 256 bits & JWT Expiration is 24 hours
	private final static String SECRET_KEY = "ThisIsASecretKeyThisIsASecretKeyThisIsASecretKey";
	private final static long EXPIRATION = 1000l * 60 * 60 * 24;

	// Decoding/Parsing JWT Token
	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getSubject();
	}

	public Date extractExpiration(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getExpiration();
	}

	// Encoding/Generating JWT Token
	public String generateToken(UserDetails user) {
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY).addClaims(new HashMap<>())
				.setSubject(user.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)).compact();
	}

	// Validation JWT Token
	public boolean validateToken(String token, UserDetails user) {
		String username = extractUsername(token);
		Date expiration = extractExpiration(token);
		return (username.equalsIgnoreCase(user.getUsername())
				&& expiration.after(new Date(System.currentTimeMillis())));
	}

//	public static void main(String[] args) {
//		UserDetails userDetails = new User("yash", "user", Set.of(new SimpleGrantedAuthority("ADMIN")));
//		JwtUtil jwtUtil = new JwtUtil();
//		String token = jwtUtil.generateToken(userDetails);
//		String username = jwtUtil.extractUsername(token);
//		Date expiration = jwtUtil.extractExpiration(token);
//		boolean validateToken = jwtUtil.validateToken(token, userDetails);
//
//		System.out.println("TOKEN: " + token);
//		System.out.println("Username: " + username);
//		System.out.println("Expiry: " + expiration);
//		System.out.println("Validate: " + validateToken);
//
//	}
}
