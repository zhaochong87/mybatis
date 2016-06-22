package com.zhaochong.mybatis.dao;

import com.zhaochong.mybatis.bean.User;

public interface UserDao {
    
	public User selectUserByID(int id);

}
