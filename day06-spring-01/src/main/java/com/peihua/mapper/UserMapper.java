package com.peihua.mapper;

import com.peihua.pojo.User;

import java.util.List;

public interface UserMapper {
//    添加用户
    void saveUser(User user);

    void delete(Integer id);

    void update(User user);

    User findById(Integer id);

    List<User> all();

}
