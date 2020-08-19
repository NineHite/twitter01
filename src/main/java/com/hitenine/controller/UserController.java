package com.hitenine.controller;

import com.hitenine.entity.User;
import com.hitenine.service.UserService;
import com.hitenine.vo.LoginUserVO;
import com.hitenine.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author hitenine
 * @since 2020-04-26 17:52:37
 */
@RestController
@RequestMapping
@CrossOrigin
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResultVO findAllUser() {

        List<User> list = userService.list();

        return ResultVO.success(list);
    }

    @GetMapping("/user")
    public ResultVO findUser() {
        HashMap<String, LoginUserVO> map = new HashMap<>();
        map.put("user",userService.loginUserVO());
        return ResultVO.success(map);
    }

}
