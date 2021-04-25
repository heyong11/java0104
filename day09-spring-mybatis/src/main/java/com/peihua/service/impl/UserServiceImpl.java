package com.peihua.service.impl;

import com.peihua.mapper.UserMapper1;
import com.peihua.pojo.User;
import com.peihua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper1 userMapper1;


    @Override
    public void saveUser(User user) {
        userMapper1.saveUser(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper1.deleteById(id);
    }

    @Override
    public void upUser(User user) {
        userMapper1.upUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper1.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper1.findAll();
    }
}
