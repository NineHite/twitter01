package com.hitenine.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TweetMapperTest {

    @Autowired
    private TweetMapper tweetMapper;

    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(tweetMapper.findPicturesByTweetId(1L)));
        // System.out.println(tweetMapper.findPicturesByTweetId(1L));
        // System.out.println(tweetMapper.selectList(null));
    }
}