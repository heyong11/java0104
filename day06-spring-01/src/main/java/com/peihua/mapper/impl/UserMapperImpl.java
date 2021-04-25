package com.peihua.mapper.impl;

import com.peihua.mapper.UserMapper;
import com.peihua.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private JdbcTemplate jdbcTemplate;
    @Override
    public void saveUser(User user) {
        String sql = "insert into user (name,pwd) values(?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getPwd());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,pwd = ? where id = ?";
        jdbcTemplate.update(sql,user.getName(),user.getPwd(),user.getId());
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public List<User> all() {
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
    public void setJdbcTemplate (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
