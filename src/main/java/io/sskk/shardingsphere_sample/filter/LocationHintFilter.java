package io.sskk.shardingsphere_sample.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LocationHintFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        Object principal = SecurityContextHolder.getContext().getAuthentication();

        if (principal instanceof JwtAuthenticationToken jwtAuth) {
            Jwt jwt = jwtAuth.getToken();
            String location = jwt.getClaimAsString("location");

            // 힌트를 등록 (자동으로 해당 DB로 라우팅)
            if (location == null) {
                throw new IllegalStateException("Invalid or missing location in JWT");
            } else {
                try (HintManager hintManager = HintManager.getInstance()) {
                    hintManager.setDatabaseShardingValue(location);
                    filterChain.doFilter(request, response);
                    return; // 정상 흐름으로 처리
                }
            }
        }

        // location이 없거나 인증 정보가 없으면 그대로 진행
        filterChain.doFilter(request, response);
    }
}