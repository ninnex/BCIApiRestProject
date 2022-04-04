package com.bci.BCIProject.filter;

import com.bci.BCIProject.service.JwtUtil;
import com.bci.BCIProject.service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    MyUserDetailsService detailsService;
    JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        Optional<String> authorizationHeader = Optional.ofNullable(request.getHeader("Authorization"));

        if(authorizationHeader.isPresent() && authorizationHeader.get().startsWith("Bearer ")){
                String jwt = authorizationHeader.get().substring(7);
                String username = jwtUtil.extractUsername(jwt);

                if(!username.isEmpty() && Objects.isNull(SecurityContextHolder.getContext().getAuthentication() )){
                    UserDetails userDetails = this.detailsService.loadUserByUsername(username);

                    if(jwtUtil.validateToken(jwt, userDetails)){
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }


                }

        }


        filterChain.doFilter(request, response);
    }
}
