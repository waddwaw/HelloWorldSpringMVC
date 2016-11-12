package com.waddwaw.demo.shiro.service.impl;

import com.waddwaw.demo.shiro.dao.UserMapper;
import com.waddwaw.demo.shiro.model.User;
import com.waddwaw.demo.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户Service实现类
 *
 * @author StarZou
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserMapper userMapper;

    public User authentication(String user, String pwd) {
        return userMapper.authentication(user,pwd);
    }

    public User selectByUsername(String user) {
        return userMapper.byUserName(user);
    }
}
