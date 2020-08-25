package com.hitenine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hitenine.entity.Tweet;
import com.hitenine.mapper.TweetMapper;
import com.hitenine.service.TweetService;
import com.hitenine.vo.TweetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hitenine
 */
@Service
public class TweetServiceImpl extends ServiceImpl<TweetMapper, Tweet> implements TweetService {

    private final TweetMapper tweetMapper;

    public TweetServiceImpl(TweetMapper tweetMapper) {
        this.tweetMapper = tweetMapper;
    }

    @Override
    public List<TweetVO> findAllTweetVO() {

        List<TweetVO> tweetVOS = new ArrayList<>();
        List<Tweet> tweets = tweetMapper.selectList(null);
        for (Tweet tweet : tweets) {
            TweetVO tweetVO = new TweetVO();
            List<String> picturesByTweetId = tweetMapper.findPicturesByTweetId(tweet.getTweetId());
            BeanUtils.copyProperties(tweet, tweetVO);
            tweetVO.setPictures(picturesByTweetId);

            tweetVOS.add(tweetVO);
        }



        return tweetVOS;
    }
}
