package com.waddwaw.demo.shiro.service.impl;

import com.waddwaw.demo.shiro.dao.UserMapper;
import com.waddwaw.demo.shiro.model.User;
import com.waddwaw.demo.shiro.model.UserExample;
import com.waddwaw.demo.shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户Service实现类
 *
 * @author StarZou
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl  implements UserService {

    @Resource
    private UserMapper userMapper;

    public User authentication(User user) {
        return userMapper.authentication(user);
    }

    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

  
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        final List<User> list = userMapper.selectByExample(example);
        return list.get(0);
    }

}
