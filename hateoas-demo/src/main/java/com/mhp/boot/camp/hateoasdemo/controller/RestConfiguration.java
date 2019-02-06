package com.mhp.boot.camp.hateoasdemo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Configuration
public class RestConfiguration {

    @Bean
    public TraceFilter traceFilter() {
        return new TraceFilter();
    }


    protected static class TraceFilter implements Filter {

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            String uuid = HttpServletRequest.class.cast(servletRequest).getHeader("X-Trace-Id");

            if (uuid == null || uuid.isEmpty()) {
                uuid = UUID.randomUUID().toString();
            }
            HttpServletResponse.class.cast(servletResponse).setHeader("X-Trace-Id", uuid);
            filterChain.doFilter(servletRequest, servletResponse);


        }
    }

}
