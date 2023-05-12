package com.doan.QLCSVC.security;

import com.doan.QLCSVC.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;



@Component
@RequiredArgsConstructor
public class JwtProvider {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;
    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;


    public String generateToken(Authentication authenticate) {
        User user= (User) authenticate.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(Date.from(Instant.now()))
                .claim("roles",user.getAuthorities().toString())
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();

    }
    public String generateTokenWithUserName(String username,ArrayList<Role> roles) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(Date.from(Instant.now()))
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .claim("roles",roles.toString())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }
    public boolean validateToken(String jwt){
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt);


        return true;

    }
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }
}
