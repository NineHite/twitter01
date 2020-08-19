package com.hitenine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hitenine.entity.User;
import org.springframework.stereotype.Repository;

/**
 * (User)表数据库访问层
 *
 * @author Hitenine
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}