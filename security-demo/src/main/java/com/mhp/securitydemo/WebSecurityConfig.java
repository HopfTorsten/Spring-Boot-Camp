package com.mhp.securitydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/info").permitAll()
//                .antMatchers("/free").hasAuthority("FREE")
//                .antMatchers("/premium").hasAuthority("PREMIUM")
                .anyRequest().authenticated()
                .and()
                .httpBasic() // this leads to a prompt

        ;
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("john-premium")
                        .password("nothing-cheap")
                        .authorities(new SimpleGrantedAuthority("PREMIUM"))
                        .build();

        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("just-a-student")
                        .password("ICH_L1E8E_70SENBIER")
                        .authorities(new SimpleGrantedAuthority("FREE"))
                        .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}