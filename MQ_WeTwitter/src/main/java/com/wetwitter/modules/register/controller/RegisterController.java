package com.wetwitter.modules.register.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wetwitter.modules.common.model.Result;
import com.wetwitter.modules.common.model.User;
import com.wetwitter.modules.register.service.RegisterService;

@Controller
@RequestMapping(value="/registerService")
public class RegisterController 
{
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 跳转注册页面
	 * @return
	 */
	@RequestMapping(value="/toRegister.do")
	public String toRegister()
	{
		return "/register";
	}
	
	/**
	 * 注册
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/register.do")
	@ResponseBody
	public Result register(@RequestBody Map<String,Object> paramMap,HttpServletRequest request) throws Exception
	{
		return registerService.register(paramMap);
	}

}
