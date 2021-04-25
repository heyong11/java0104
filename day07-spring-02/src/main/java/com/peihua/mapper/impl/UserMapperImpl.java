package com.peihua.mapper.impl;

import com.peihua.mapper.UserMapper;
import com.peihua.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper") //在dao层实例化bean，不需要再配置文件中写了
public class UserMapperImpl implements UserMapper {

    //声明一个jdbctemplate
    @Autowired  //自动按照类型注入
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql ="insert into user (name,pwd) values(?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getPwd());

    }

    @Override
    public void delById(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void updateById(User user) {
        String sql  = "update user set name = ? ,pwd = ? where id = ?";
        jdbcTemplate.update(sql,user.getName(),user.getPwd(),user.getId());

    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user where id= ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    @Override
    public List<User> allUser() {
        String sql  = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }
}
