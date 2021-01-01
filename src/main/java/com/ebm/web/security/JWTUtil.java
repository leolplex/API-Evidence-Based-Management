package com.ebm.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
    @Value("${ebm.app.jwtSecret}")
    private String KEY;

    JWTUtil(String key) {
        this.KEY = key;
    }

    public String generateToken(UserDetails userDetails, Date dateNow, Date dateExpiration) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(dateNow) // new Date()
                .setExpiration(dateExpiration) // new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        if (!isTokenExpire(token)) {
            return userDetails.getUsername().equals(extractUsername(token));
        } else {
            return false;
        }
    }

    public String extractUsername(String token) {

        return getClaims(token).getSubject();

    }

    public boolean isTokenExpire(String token) {
        try {
            return getClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {

            return new DefaultClaims();
        }

    }
}
