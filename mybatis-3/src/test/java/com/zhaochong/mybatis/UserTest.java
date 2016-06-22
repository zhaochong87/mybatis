package com.zhaochong.mybatis;

import com.zhaochong.mybatis.bean.User;
import com.zhaochong.mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;


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

	/**
	 * 添加用户
	 */
	public void addUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 用户对象
			User user = new User();
			user.setUserAddress("人民广场");
			user.setUserName("飞鸟");
			user.setUserAge(80);

			// 添加用戶
			UserDao userDao = session.getMapper(UserDao.class);
			userDao.addUser(user);

			// 提交事务
			session.commit();

			System.out.println("当前增加的用户 id为:" + user.getId());
		} finally {
			session.close();
		}
	}

	/**
	 * 查询用户列表
	 *
	 * @param userName
	 *            用户名
	 */
	public void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 映射接口
			UserDao userDao = session.getMapper(UserDao.class);
			List<User> users = userDao.selectUsers(userName);
			for (User user : users) {
				System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAddress());
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 更新用户
	 */
	public void updateUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 更新用戶
			UserDao userDao = session.getMapper(UserDao.class);

			User user = userDao.selectUserByID(2);
			user.setUserAddress("xxxxx");
			user.setUserName("yy");
			user.setUserAge(80);

			userDao.updateUser(user);

			// 提交事务
			session.commit();

			// 显示更新后的信息
			System.out.println(userDao.selectUsers(user.getUserName()));
		} finally {
			session.close();
		}
	}

	/**
	 * 删除用户
	 */
	public void deleteUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 删除用戶
			UserDao userDao = session.getMapper(UserDao.class);
			userDao.deleteUser(4);

			// 提交事务
			session.commit();

			// 显示更新后的信息
			userDao.selectUsers("%");
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		UserTest userTest = new UserTest();

		// userTest.getUserById();
//		userTest.getUserById2();
		userTest.addUser();
		userTest.getUserList("%");
//		userTest.updateUser();
		// userTest.deleteUser();

	}


}
