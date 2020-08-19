package com.hitenine.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hitenine.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (Say)实体类
 *
 * @author hitenine
 * @since 2020-04-26 17:54:02
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(resultMap = "TweetMap")
public class Tweet extends BaseEntity {

    @TableId
    private Long tweetId;
    
    private Long userId;
    
    private String content;

}