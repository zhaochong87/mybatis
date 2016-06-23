package com.zhaochong.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhaochong.mybatis.bean.Article;
import com.zhaochong.mybatis.dao.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDao userDao;

	@RequestMapping("/list")
	public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
		List<Article> articles = userDao.getUserArticles(1);
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("articles", articles);
		return mav;
	}

}
