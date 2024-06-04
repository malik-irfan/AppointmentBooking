package com.spolight.appointment.appointment_booking.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtDecoder jwtDecoder;

    private final JwtToPrincipalConverter jwtToPrincipalConverter;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        extractTokenFromRequest(request) /* extracting token from request header */
                .map(jwtDecoder::decode)/* decoding string token in jwt */
                .map(jwtToPrincipalConverter::convert) /*converting decoded token into a principal */
                .map(UserPrincipalAuthenticationToken::new) /*principal wrapped into a AuthenticationToken */
                .ifPresent(authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));

        filterChain.doFilter(request,response);
    }

    /*
    * Extract the token from authorization header from request
    * Authorization: Bearer erefdhfhddg34545.dsfe535345dfdy35
    * */
    private Optional<String> extractTokenFromRequest(HttpServletRequest request){
        var token  = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")){
            return Optional.of(token.substring(7));
        }
        return Optional.empty();
    }
}
