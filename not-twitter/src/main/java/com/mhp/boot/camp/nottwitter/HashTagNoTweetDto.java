package com.mhp.boot.camp.nottwitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HashTagNoTweetDto {
    private String message;
    private String author;
    private String email;
    private List<String> tags;
}