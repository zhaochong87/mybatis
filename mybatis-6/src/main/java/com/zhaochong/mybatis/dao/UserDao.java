package com.zhaochong.mybatis.dao;

import com.zhaochong.mybatis.bean.Article;
import com.zhaochong.mybatis.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 单表CRUD操作
 */
public interface UserDao {
    
	User selectUserByID(int id);

	List<User> selectUsers(String userName);

	List selectUsers();

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);

	List<Article> getUserArticles(int id);

}
