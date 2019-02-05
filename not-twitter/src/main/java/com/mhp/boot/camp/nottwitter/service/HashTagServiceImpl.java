package com.mhp.boot.camp.nottwitter.service;

import com.mhp.boot.camp.nottwitter.HashTagNoTweetDto;
import com.mhp.boot.camp.nottwitter.dataaccess.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
        /*package*/ class HashTagServiceImpl implements HashTagService {

    private final TweetRepository repository;

    HashTagServiceImpl(@Autowired TweetRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HashTagNoTweetDto> getAllTweets() {
        return repository.getAllTweets();
    }

    @Override
    public void addTweet(HashTagNoTweetDto tweet) {
        repository.addTweet(tweet);
    }

    @Override
    public void deleteAllTweetsByEmail(String email) {
        repository.deleteAllTweets(email);
    }

    @Override
    public List<HashTagNoTweetDto> getAllTweetsOf(String email) {

        return repository.getAllTweets()
                .stream()
                .filter(tweet -> email.equals(tweet.getEmail()))
                .collect(Collectors.toList());
    }
}
