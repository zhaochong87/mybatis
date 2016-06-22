package com.zhaochong.mybatis;

import com.zhaochong.mybatis.bean.User;
import com.zhaochong.mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;


/**
 * 测试类
 * 
 * @author 343451
 *
 */
public class UserTest {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	/**
	 * getUserById 映射接口
	 */
	public void getUserById2() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 映射接口
			UserDao userDao = session.getMapper(UserDao.class);
			User user = userDao.selectUserByID(1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		UserTest userTest = new UserTest();

		userTest.getUserById2();

	}


}
