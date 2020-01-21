package com.mhp.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/premium")
    public ResponseEntity<List<News>> getPremium() {
        return ResponseEntity.ok(newsService.returnPremiumNews());
    }

    @GetMapping("/free")
    public ResponseEntity<List<News>> getFree() {
        return ResponseEntity.ok(newsService.returnFreeTierNews());
    }

}
