package com.zhaochong.mybatis.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhaochong.mybatis.bean.Article;
import com.zhaochong.mybatis.bean.User;
import com.zhaochong.mybatis.dao.UserDao;



public class MybatisSpringTest {
	
	private static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public static void main(String[] args) {
		UserDao userDao = (UserDao) context.getBean("userMapper");
		
		System.out.println("得到用户id=1的用户信息");
        User user = userDao.selectUserByID(1);
        System.out.println(user.getUserAddress()); 
        
        //得到文章列表测试
        System.out.println("得到用户id为1的所有文章列表");
        List<Article> articles = userDao.getUserArticles(1);
        for(Article article:articles){
            System.out.println(article.getContent()+"--"+article.getTitle());
        }
        
	}
}
