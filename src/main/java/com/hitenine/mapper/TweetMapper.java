package com.hitenine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hitenine.entity.Tweet;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hitenine
 */
@Repository
public interface TweetMapper extends BaseMapper<Tweet> {

    /**
     * 根据tweetId查找对应的图片
     * @param tweetId 推文的Id
     * @return 图片集合
     */
    List<String> findPicturesByTweetId(Long tweetId);

}
