package com.mhp.boot.camp.nottwitter.dataaccess;

import com.mhp.boot.camp.nottwitter.HashTagNoTweetDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
class InMemoryTweetRepository implements TweetRepository {

    final Map<String, List<HashTagNoTweetDto>> tweets = new HashMap<>();

    @PostConstruct
    public void init() {
        addTweet(
                new HashTagNoTweetDto(
                        "Hey all! Just learned some Spring Basics.",
                        "Alex", "alex.sturm@mhp.com",
                        Arrays.asList("Spring", "Boot")));
        addTweet(
                new HashTagNoTweetDto(
                        "I like salty food",
                        "Mrs. Unbekannt", "do-not-reply@küche.com",
                        Arrays.asList("Fisch", "Salz")));
    }

    @Override
    public List<HashTagNoTweetDto> getAllTweets() {
        return tweets.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllTweets(String email) {
        tweets.remove(email);
    }

    @Override
    public void addTweet(HashTagNoTweetDto dto) {
        if (!tweets.containsKey(dto.getEmail())) {
            tweets.put(dto.getEmail(), new LinkedList<>());
        }
        tweets.get(dto.getEmail()).add(dto);
        System.out.println("Added" + dto);
    }
}
