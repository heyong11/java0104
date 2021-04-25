package com.peihua.service;

import com.peihua.pojo.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void delByIdService(Integer id);

    void upService(User user);

    User findByIdService(Integer id);

    List<User> selAllService();
}
