package com.mhp.boot.camp.hateoasdemo.security;

import com.mhp.boot.camp.hateoasdemo.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    private final UserRepo userRepo;

    public CustomAuthenticationProvider(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        //TODO: Check against DB

        List<String> roles = userRepo.findById(userName)
                .filter(e -> e.getPassWord()
                        .equals(password))
                .map(e -> e.getRoles())
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("Test"));

        List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        roles.stream().map(e -> new SimpleGrantedAuthority(e)).forEach(authorities::add);

        return new UsernamePasswordAuthenticationToken(userName, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
