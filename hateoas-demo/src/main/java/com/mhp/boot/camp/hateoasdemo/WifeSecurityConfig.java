package com.mhp.boot.camp.hateoasdemo;

import com.mhp.boot.camp.hateoasdemo.repo.User;
import com.mhp.boot.camp.hateoasdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WifeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void initUsers() {
        userRepo.save(new User("admin", "admin", Arrays.asList("READ", "WRITE")));
        userRepo.save(new User("user", "noadmin", Arrays.asList("READ")));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/*")
                .permitAll();
    }
}
