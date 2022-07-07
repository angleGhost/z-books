package com.zbooks.controller.user;

import com.zbooks.pojo.User;
import com.zbooks.service.user.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TBH
 * @version 1.0
 * date 2022/07/07 10:50
 * desc : 用户接口
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户模块")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "根据id获取用户")
    @GetMapping("getUser/{id}")
    public User getUserById(@PathVariable("id") Integer userId) {
        return userService.getById(userId);
    }
}