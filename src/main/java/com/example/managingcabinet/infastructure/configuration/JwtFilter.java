package com.example.managingcabinet.infastructure.configuration;

import com.example.managingcabinet.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @Nullable HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {

        var header = request.getHeader(AUTHORIZATION);

        Optional.ofNullable(header).ifPresent(jwtService::authenticate);

        filterChain.doFilter(request, response);
    }
}
