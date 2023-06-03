package com.project.vehiclerental.security.filter;

import com.project.vehiclerental.security.authentication.ApiKeyAuthentication;
import com.project.vehiclerental.security.manager.CustomAuthenticationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String key;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        CustomAuthenticationManager manager = new CustomAuthenticationManager(key);

        String requestKey = request.getHeader("x-api-key");

        if (requestKey == null || "null" .equals(requestKey)) {
            filterChain.doFilter(request, response);
        }

        var apiKeyAuthentication = new ApiKeyAuthentication(requestKey, false);

        try {
            var authentication = manager.authenticate(apiKeyAuthentication);
            if (authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (AuthenticationException exception) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}