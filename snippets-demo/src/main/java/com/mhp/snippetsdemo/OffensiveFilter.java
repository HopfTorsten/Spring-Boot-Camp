package com.mhp.snippetsdemo;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class OffensiveFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String header = httpServletRequest.getHeader("X-Payment");
        if (null == header) {
            httpServletResponse.addDateHeader("X-Revenge-Date", LocalDateTime.now().getNano());
        }


        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
