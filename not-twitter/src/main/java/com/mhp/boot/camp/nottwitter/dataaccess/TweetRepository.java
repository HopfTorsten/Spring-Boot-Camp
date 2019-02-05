package com.mhp.boot.camp.nottwitter.dataaccess;

import com.mhp.boot.camp.nottwitter.HashTagNoTweetDto;

import java.util.List;

public interface TweetRepository {

    public List<HashTagNoTweetDto> getAllTweets();

    public void deleteAllTweets(String email);

    public void addTweet(HashTagNoTweetDto dto);


}
