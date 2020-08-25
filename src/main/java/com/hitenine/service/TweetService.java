package com.hitenine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hitenine.entity.Tweet;
import com.hitenine.vo.TweetVO;

import java.util.List;

/**
 * @author Hitenine
 */
public interface TweetService extends IService<Tweet> {

    public List<TweetVO> findAllTweetVO();
}
