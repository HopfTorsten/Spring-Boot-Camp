package com.mhp.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PremiumContent
    @GetMapping("/premium")
    public ResponseEntity<List<News>> getPremium() {
        return ResponseEntity.ok(newsService.returnPremiumNews());
    }

    @FreeContent
    @GetMapping("/free")
    public ResponseEntity<List<News>> getFree() {
        return ResponseEntity.ok(newsService.returnFreeTierNews());
    }

    @GetMapping("/info")
    public ResponseEntity<List<String>> getInfo() {
        return ResponseEntity.ok(newsService.returnFreeTierNews().stream().map(News::getCategory).collect(toList()));
    }

}
