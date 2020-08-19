package com.hitenine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hitenine.entity.User;
import com.hitenine.mapper.UserMapper;
import com.hitenine.service.UserService;
import com.hitenine.vo.LoginUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Hitenine
 */
@Service
public class UserSerImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public LoginUserVO loginUserVO() {
        LoginUserVO loginUserVO = new LoginUserVO();
        User user = baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserId, 2L));
        BeanUtils.copyProperties(user, loginUserVO);
        return loginUserVO;
    }
}
