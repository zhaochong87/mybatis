package com.zhaochong.mybatis.dao;

import com.zhaochong.mybatis.bean.User;

import java.util.List;

public interface UserDao {
    
	User selectUserByID(int id);

}
