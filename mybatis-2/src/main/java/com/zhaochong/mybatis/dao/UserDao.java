package com.zhaochong.mybatis.dao;

import com.zhaochong.mybatis.bean.User;

import java.util.List;

public interface UserDao {
    
	public User selectUserByID(int id);

	public List<User> selectUsers(String userName);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

}
