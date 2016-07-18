package com.zhaochong.mybatis.dao.test;

import com.zhaochong.mybatis.bean.Article;
import com.zhaochong.mybatis.bean.User;
import com.zhaochong.mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Reader;
import java.util.List;


/**
 * 测试类
 *
 * @author 343451
 *
 */
public class UserTest {

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * getUserById 映射接口
	 */
	public void getUserById() {
		UserDao userDao = (UserDao) context.getBean("userMapper");

		System.out.println("得到用户id=1的用户信息");
		// 映射接口
		User user = userDao.selectUserByID(1);
		System.out.println(user.getUserAddress());
		System.out.println(user.getUserName());
	}

	/**
	 * 添加用户
	 */
	public void addUser() {
		UserDao userDao = (UserDao) context.getBean("userMapper");
		// 用户对象
		User user = new User();
		user.setUserAddress("人民广场");
		user.setUserName("飞鸟");
		user.setUserAge(80);

		// 添加用戶
		userDao.addUser(user);

		System.out.println("当前增加的用户 id为:" + user.getId());
	}

	/**
	 * 查询用户列表
	 *
	 * @param userName
	 *            用户名
	 */
	public void getUserList(String userName) {
		UserDao userDao = (UserDao) context.getBean("userMapper");
			// 映射接口
			List<User> users = userDao.selectUsers(userName);
			for (User user : users) {
				System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAddress());
			}
	}

	/**
	 * 更新用户
	 */
	public void updateUser() {
		UserDao userDao = (UserDao) context.getBean("userMapper");
		// 更新用戶
		User user = userDao.selectUserByID(2);
		user.setUserAddress("xxxxx");
		user.setUserName("yy");
		user.setUserAge(80);

		userDao.updateUser(user);

		// 显示更新后的信息
		System.out.println(userDao.selectUsers(user.getUserName()));
	}

	/**
	 * 删除用户
	 */
	public void deleteUser() {
		UserDao userDao = (UserDao) context.getBean("userMapper");
		// 删除用戶
		userDao.deleteUser(4);

		// 显示更新后的信息
		userDao.selectUsers("%");
	}


	/**
	 * 查询与用户相关的articles
	 *
	 * @param userId
	 */
	public void getUserArticles(int userId) {
		UserDao userDao = (UserDao) context.getBean("userMapper");
		List<Article> articles = userDao.getUserArticles(userId);
		for (Article article : articles) {
			System.out.println(article.getTitle() + ":" + article.getContent() + ":作者是:"
					+ article.getUser().getUserName() + ":地址:" + article.getUser().getUserAddress());
		}
	}

	public static void main(String[] args) {
		UserTest userTest = new UserTest();

		 userTest.getUserById();
//		userTest.addUser();
		userTest.getUserList("%");
//		userTest.updateUser();
		// userTest.deleteUser();

		userTest.getUserArticles(1);

	}


}
