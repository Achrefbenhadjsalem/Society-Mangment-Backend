package com.test.COCONSULT.JWT;

import com.test.COCONSULT.Entity.UserPrinciple;
import com.test.COCONSULT.ServiceIMP.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class JwtAuthTokenFilter implements Filter {

    @Value("${cryptoserver.app.jwtSecret}")
    private String jwtSecret;

    @Value("${cryptoserver.app.jwtExpiration}")
    private int jwtExpiration;
    @Autowired
    private JwtProvider tokenProvider;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);


    public void setAuthentication(String jwt, HttpServletRequest request) {
        String username = tokenProvider.getUserNameFromJwtToken(jwt);
        logger.debug("JWT Token contains username: {}", username);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }



    // Modify JwtAuthTokenFilter to handle refresh tokens from session
    public String getJwt(HttpServletRequest request, HttpSession session) {
    // Check for access token
    String accessToken = extractAccessToken(request);
    if (accessToken != null) {
        return accessToken;
    }

    // Check for refresh token from session
    String refreshToken = (String) session.getAttribute("refreshToken");
    if (refreshToken != null && isValidRefreshToken(refreshToken)) {
        // Issue new access token
        String newAccessToken = issueNewAccessToken(refreshToken);

        // Return new access token
        return newAccessToken;
    }

    return null;
}

    public String issueNewAccessToken(String refreshToken) {
        try {
            // Parse the refresh token to get user details
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(refreshToken).getBody();
            String username = claims.getSubject();

            // Generate a new access token for the user
            //UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
            long ACCESS_TOKEN_VALIDITY_MS =     60 * 1000; // 5 hours
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + ACCESS_TOKEN_VALIDITY_MS))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        } catch (Exception e) {
       //     logger.error("Error issuing new access token: {}", e.getMessage());
            return null;
        }
    }

    public boolean isValidRefreshToken(String refreshToken) {
        try {
            // Validate the refresh token's signature and expiration
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(refreshToken);
            return true;
        } catch (Exception e) {
   //         logger.error("Invalid refresh token: {}", e.getMessage());
            return false;
        }
    }

    public String extractAccessToken(HttpServletRequest request) {
        // Extract the access token from the Authorization header
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);  // "Bearer " is 7 characters
        }
        return null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        try {
            String jwt = extractAccessToken(httpRequest);
            logger.debug("Extracted JWT: {}", jwt);
            if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
                setAuthentication(jwt, httpRequest);
            } else {
                logger.warn("JWT Token is invalid or not present.");
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }

        chain.doFilter(request, response);
    }
    public String extractRefreshToken(HttpServletRequest request) {
        // Retrieve the refresh token from the request attributes or parameters
        String refreshToken = request.getParameter("RefreshToken");
        if (refreshToken != null && !refreshToken.isEmpty()) {
            return refreshToken;
        } else {
            // If the refresh token is not found in parameters, try retrieving it from headers
            refreshToken = request.getHeader("RefreshToken");
            if (refreshToken != null ) {
                // Extract the token from the Authorization header
              //  refreshToken = refreshToken.substring(7);
                return refreshToken;
            }
        }
        return null; // Return null if refresh token is not found in both parameters and headers
    }
}

