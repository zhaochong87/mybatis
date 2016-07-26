package com.zhaochong.mybatis.dao;

import com.zhaochong.mybatis.bean.Article;
import com.zhaochong.mybatis.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 单表CRUD操作
 */
public interface UserDao {
    
	public User selectUserByID(int id);

	public List<User> selectUsers(String userName);

	public List<User> selectUsers();

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public List<Article> getUserArticles(int id);

}
