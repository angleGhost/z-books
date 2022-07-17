package com.zbooks.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbooks.mapper.user.UserMapper;
import com.zbooks.model.entity.User;
import com.zbooks.service.user.UserService;
import org.springframework.stereotype.Service;

/**
 * @author TBH
 * @version 1.0
 * date 2022/07/07 10:53
 * desc : 用户相关接口实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}