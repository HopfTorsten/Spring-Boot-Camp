package com.mhp.boot.camp.nottwitter.controller;

import com.mhp.boot.camp.nottwitter.HashTagNoTweetDto;
import com.mhp.boot.camp.nottwitter.service.HashTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetController {

    private final HashTagService hashTagService;

    public TweetController(@Autowired HashTagService hashTagService) {

        this.hashTagService = hashTagService;

    }

    @GetMapping("/tweet")
    public ResponseEntity<List<HashTagNoTweetDto>> getAllTweets() {
        List<HashTagNoTweetDto> tweets = hashTagService.getAllTweets();

        return ResponseEntity
                .status(HttpStatus.PAYMENT_REQUIRED)
                .header("X-Message", "Lappen")
                .body(tweets);
    }

    @PostMapping("/tweet")
    public ResponseEntity<String> addTweet(@RequestBody HashTagNoTweetDto tweet) {

        hashTagService.addTweet(tweet);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK!");

    }


}
