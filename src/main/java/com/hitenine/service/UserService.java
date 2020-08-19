package com.hitenine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hitenine.entity.User;
import com.hitenine.vo.LoginUserVO;

/**
 * @author Hitenine
 */
public interface UserService extends IService<User> {

    /**
     * 顶部用户信息
     * 查询 id 为 2 的用户
     * @return
     */
    LoginUserVO loginUserVO();

}
