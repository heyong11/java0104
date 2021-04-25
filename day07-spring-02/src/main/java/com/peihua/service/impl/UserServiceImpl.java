package com.peihua.service.impl;

import com.peihua.mapper.UserMapper;
import com.peihua.pojo.User;
import com.peihua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService") //加入容器
public class    UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.save(user);
    }

    @Override
    public void delByIdService(Integer id) {
        userMapper.delById(id);
    }

    @Override
    public void upService(User user) {
        userMapper.updateById(user);
    }

    @Override
    public User findByIdService(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    @Override
    public List<User> selAllService() {
        List<User> userList = userMapper.allUser();
        return userList;
    }

}
