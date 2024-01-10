package com.example.managingcabinet.service.impl;

import com.example.managingcabinet.dto.auth.AuthRespDto;
import com.example.managingcabinet.enums.Role;
import com.example.managingcabinet.model.User;
import com.example.managingcabinet.repo.UserRepository;
import com.example.managingcabinet.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.access}")
    private String accessDuration;
    @Value("${jwt.refresh}")
    private String refreshDuration;

    private final UserRepository userRepository;

    @Override
    public AuthRespDto generateToken(User user) {
        var access = Jwts
                .builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(accessDuration)))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
        var refresh = Jwts
                .builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(refreshDuration)))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
        return new AuthRespDto(access, refresh);
    }

    private String extractUsername(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void authenticate(String header) {

        var userId = extractUsername(header.substring(8));

        if (userId != null) {

            var user = userRepository.getAuthById(userId);

            Authentication auth = new UsernamePasswordAuthenticationToken(
                    user.getUserId(),
                    null,
                    getAuthorities(user.getRole())
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.name());
        return Collections.singletonList(authority);
    }
}
