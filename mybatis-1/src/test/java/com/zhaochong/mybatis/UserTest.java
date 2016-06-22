package com.zhaochong.mybatis;

import com.zhaochong.mybatis.bean.User;
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
	 * getUserById 映射实体
	 */
	public void getUserById() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 映射实体
			User user = (User) session.selectOne("com.zhaochong.mybatis.bean.UserMapper.selectUserByID", 1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		UserTest userTest = new UserTest();

		 userTest.getUserById();
	}

}
