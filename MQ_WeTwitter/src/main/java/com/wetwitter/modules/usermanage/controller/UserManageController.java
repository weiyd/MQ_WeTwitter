package com.wetwitter.modules.usermanage.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wetwitter.modules.common.model.News;
import com.wetwitter.modules.common.model.Result;
import com.wetwitter.modules.common.model.User;
import com.wetwitter.modules.common.utils.JsonUtils;
import com.wetwitter.modules.usermanage.service.UserManageService;

@Controller
@RequestMapping(value="/userManageService")
public class UserManageController 
{
	@Autowired
	private UserManageService userManageService;
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mofifyUserInfo.do")
	@ResponseBody
	public Result mofifyUserInfo(@RequestBody(required=false) User user) 
			throws Exception
	{
		return userManageService.mofifyUserInfo(user);
	}
	
	/**
	 * 查找好友
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/searchFriend.do")
	@ResponseBody
	public Result searchFriend(@RequestBody(required=false) User user,HttpServletRequest request) 
			throws Exception
	{
		return userManageService.searchFriend(user,request);
	}
	
	/**
	 * 添加好友
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addFriend.do")
	@ResponseBody
	public Result addFriend(@RequestBody(required=false) User user) 
			throws Exception
	{
		return userManageService.addFriend(user);
	}
	
	/**
	 * 查询用户
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/searchUser.do")
	@ResponseBody
	public Result searchUser(@RequestBody(required=false) User user,HttpServletRequest request) 
			throws Exception
	{
		
		return userManageService.listAllUser(user,request);
	}
	
	/**
	 * 发送好友申请
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sendFriendApplication.do")
	@ResponseBody
	public Result sendFriendApplication(@RequestBody String jsonStr,HttpServletRequest request) 
			throws Exception
	{
		return userManageService.sendFriendApplication(JsonUtils.toMap(jsonStr),request);
	}
	
	/**
	 * 回复好友申请
	 * @param jsonStr
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/replyFriendApplication.do")
	@ResponseBody
	public Result replyFriendApplication(@RequestBody String jsonStr,HttpServletRequest request) 
			throws Exception
	{
		return userManageService.replyFriendApplication(JsonUtils.toMap(jsonStr),request);
	}

}
