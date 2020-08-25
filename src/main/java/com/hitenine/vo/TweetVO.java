package com.hitenine.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Hitenine
 */
@Data
public class TweetVO {

    private Long tweetId;

    private Long userId;

    private String content;

    private Date updateTime;

    private List<String> pictures;

}
