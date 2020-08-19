package com.hitenine.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hitenine.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * (User)实体类
 *
 * @author hitenine
 * @since 2020-04-26 17:54:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(resultMap = "UserMap")
public class User extends BaseEntity {

    @TableId
    private Long userId;

    private String username;
    
    private String password;
    
    private String nickname;

    private Integer gender;
    
    private String avatar;
    
    private Integer age;
    
    private Date birth;

    private String address;

    private Long roleId;

    private Integer status;

}