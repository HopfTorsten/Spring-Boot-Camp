package com.mhp.boot.camp.filterdemo;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@Component
public class TraceFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String uuid = HttpServletRequest.class
                .cast(servletRequest).getHeader("X-Trace-Id");

        HttpServletResponse.class.cast(servletResponse).addHeader("X-Trace-Id", uuid == null ? UUID.randomUUID().toString() : uuid);
        filterChain
                .doFilter(servletRequest, servletResponse);

    }
}
