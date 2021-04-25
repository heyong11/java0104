package com.peihua.mapper;

import com.peihua.pojo.User;

import java.util.List;

public interface UserMapper {

    void save(User user);
    void delById(Integer id);
    void updateById(User user);

    User findById(Integer id);
    List<User> allUser();
}
