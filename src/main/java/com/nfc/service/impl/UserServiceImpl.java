package com.nfc.service.impl;

import com.nfc.dao.UserMapper;
import com.nfc.pojo.User;
import com.nfc.pojo.UserExample;
import com.nfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ms-zk on 2017-03-15.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByEmail(String email) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        User user = userMapper.selectByExample(userExample).get(0);
        return user;
    }
}
