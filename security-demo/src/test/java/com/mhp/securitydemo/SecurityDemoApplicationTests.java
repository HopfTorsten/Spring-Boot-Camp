package com.mhp.securitydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Autowired
    private NewsController newsController;

    @Test
    void contextLoads() {
    }

    @Test
    void callFreeText() {
        try {
            final ResponseEntity<List<News>> free = newsController.getFree();
            fail();
        } catch (AuthenticationCredentialsNotFoundException ex) {
            return;
        }
        fail();
    }

    @Test
    @WithMockUser(username = "john-rambo", authorities = "FREE")
    void callFreeTextSuccess() {
        try {
            final ResponseEntity<List<News>> free = newsController.getFree();
        } catch (Throwable ex) {
            fail();
        }
    }

    @Test
    @WithMockUser(username = "john-rambo", authorities = "FREE")
    void callPremiumTextFail() {
        try {
            final ResponseEntity<List<News>> premium = newsController.getPremium();
        } catch (Throwable ex) {
            return;
        }
        fail();
    }

}
