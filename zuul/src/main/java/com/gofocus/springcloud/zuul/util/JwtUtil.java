package com.gofocus.springcloud.zuul.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.ES256);

    public static String createJWS(String subject, Date issueDate) {

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static Claims parseJWS(String jws) {
        Claims payLoad = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(jws)
                .getBody();
        return payLoad;
    }

    public static void main(String[] args) {
        String jws = "sdfsdfwerwerSFDAFASD"; // 乱写的，举例
        Claims claims = parseJWS(jws);
        String subject = claims.getSubject();
        if (subject.equals("gofocus")) {
            //
        }
    }
}
