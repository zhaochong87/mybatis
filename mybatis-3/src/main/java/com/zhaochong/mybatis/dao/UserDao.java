package com.zhaochong.mybatis.dao;

import com.zhaochong.mybatis.bean.User;

import java.util.List;

/**
 * 单表CRUD操作
 */
public interface UserDao {
    
	User selectUserByID(int id);

	List<User> selectUsers(String userName);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);

}
