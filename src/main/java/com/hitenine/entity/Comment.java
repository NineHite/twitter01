package com.hitenine.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hitenine.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (Role)实体类
 *
 * @author hitenine
 * @since 2020-04-26 17:54:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(resultMap = "CommentMap")
public class Comment extends BaseEntity {

    @TableId
    private Long commentId;

    private Long tweetId;

    private Long parentCommentId;

}