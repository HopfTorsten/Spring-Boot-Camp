package com.mhp.boot.camp.nottwitter.service;

import com.mhp.boot.camp.nottwitter.HashTagNoTweetDto;

import java.util.List;

public interface HashTagService {

    public List<HashTagNoTweetDto> getAllTweets();

    public void addTweet(HashTagNoTweetDto tweet);

    public void deleteAllTweetsByEmail(String email);

    public List<HashTagNoTweetDto> getAllTweetsOf(String email);

}
