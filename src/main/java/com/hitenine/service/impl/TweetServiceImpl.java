package com.hitenine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hitenine.entity.Tweet;
import com.hitenine.mapper.TweetMapper;
import com.hitenine.service.TweetService;
import org.springframework.stereotype.Service;

/**
 * @author Hitenine
 */
@Service
public class TweetServiceImpl extends ServiceImpl<TweetMapper, Tweet> implements TweetService {

    private final TweetMapper tweetMapper;

    public TweetServiceImpl(TweetMapper tweetMapper) {
        this.tweetMapper = tweetMapper;
    }

}
