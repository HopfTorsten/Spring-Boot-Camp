package com.mhp.boot.camp.hateoasdemo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TokenComponent {

    public static void addAuthentication(HttpServletResponse response, String name, Collection<? extends GrantedAuthority> roles) {

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(name)
                .claim("authorities", roles);
        String jwt = jwtBuilder.signWith(SignatureAlgorithm.HS512, "Stu213324234234234234234532ofvobsdufbhewobfweuobfr2eopugr032urbn").compact();
        response.addHeader("Authorization", "Bearer " + jwt);
    }

    public static Authentication getAuthentication(final HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        if (jwt != null) {
            final Claims body = Jwts
                    .parser()
                    .setSigningKey("Stu213324234234234234234532ofvobsdufbhewobfweuobfr2eopugr032urbn")
                    .parseClaimsJws(jwt.replace("Bearer ", ""))
                    .getBody();

            String userName = body.getSubject();
            Collection<Map<String, Object>> auths = (Collection<Map<String, Object>>) body.get("authorities");
            final List<SimpleGrantedAuthority> authority = auths.stream().map(m -> m.get("authority").toString()).map(a -> new SimpleGrantedAuthority(a)).collect(Collectors.toList());

            return new UsernamePasswordAuthenticationToken(userName, jwt, authority);
        } else {
            throw new AuthenticationCredentialsNotFoundException("FU No credentials man");
        }
    }


}
