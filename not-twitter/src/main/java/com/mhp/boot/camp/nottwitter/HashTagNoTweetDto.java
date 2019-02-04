package com.mhp.boot.camp.nottwitter;

import lombok.Data;

import java.util.List;

@Data
public class HashTagNoTweetDto{
    private String message;
    private String author;
    private String email;
    private List<String> tags;
}