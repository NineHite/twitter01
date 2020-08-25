package com.hitenine.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitenine.service.TweetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TweetServiceImplTest {

    @Autowired
    private TweetService tweetService;

    @Test
    public void test() throws JsonProcessingException {
        // tweetService.findAllTweetVO().forEach(System.out::println);
        System.out.println(new ObjectMapper().writeValueAsString(tweetService.findAllTweetVO()));
    }

}