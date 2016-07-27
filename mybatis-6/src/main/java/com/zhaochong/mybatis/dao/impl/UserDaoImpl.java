package com.zhaochong.mybatis.dao.impl;

import com.zhaochong.mybatis.bean.Article;
import com.zhaochong.mybatis.bean.User;
import com.zhaochong.mybatis.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 343451 on 2016/7/26.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
//    NamedParameterJdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplate;


    public User selectUserByID(int id) {
        return null;
    }

    public List<User> selectUsers(String userName) {
        String sql = "select * from article ";
        return jdbcTemplate.queryForList(sql, User.class);
//        return jdbcTemplate.queryForList(sql);
    }

    public List selectUsers() {
        String sql = "select * from USER ";
//        List<User> users = jdbcTemplate.queryForList(sql, User.class);
        return jdbcTemplate.queryForList(sql);
    }

    public void addUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(int id) {

    }

    public List<Article> getUserArticles(int id) {
        return null;
    }
}
