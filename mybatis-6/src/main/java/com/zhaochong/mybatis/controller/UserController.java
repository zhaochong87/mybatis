package com.zhaochong.mybatis.controller;

import com.zhaochong.mybatis.bean.Article;
import com.zhaochong.mybatis.bean.User;
import com.zhaochong.mybatis.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
//	UserDao userMapper;
	UserDao userDao;

	@RequestMapping("/list")
	public ModelAndView listAll() {
		List<User> users = userDao.selectUsers();
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("users", users);

		System.out.println("xxxx");
		return mav;
	}

}
