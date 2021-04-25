package com.peihua.service;

import com.peihua.pojo.User;

import java.util.List;

public interface UserService {
    void saveUser (User user);

    void deleteById(Integer id);

    void upUser(User user);

    User findById(Integer id);

    List<User> findAll();

}
