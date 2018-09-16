package com.wetwitter.modules.newsmanage.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wetwitter.modules.common.model.News;
import com.wetwitter.modules.newsmanage.service.NewsManageService;

@Controller
@RequestMapping(value="/newsManageService")
public class NewsManageController 
{
	@Autowired
	private NewsManageService newsManageService;
	
	@RequestMapping(value="/toConfirmList.do")
	public ModelAndView toConfirmList(HttpServletRequest request) 
			throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Map<String,Object> loginInfo = (Map<String, Object>) session.getAttribute("loginInfo");
		List<News> newsList = newsManageService.qryToConfirmFriendNews(loginInfo);
		modelAndView.addObject("newsList", newsList);
		modelAndView.setViewName("/newsList");
		return modelAndView;
	}

}
