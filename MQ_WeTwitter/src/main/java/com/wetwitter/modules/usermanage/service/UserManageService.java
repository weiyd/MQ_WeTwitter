package com.wetwitter.modules.usermanage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wetwitter.modules.common.dao.UserDao;
import com.wetwitter.modules.common.model.Result;
import com.wetwitter.modules.common.model.User;

@Service
public class UserManageService 
{
	@Autowired
	private UserDao userDao;
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Result mofifyUserInfo(User user) throws Exception
	{
		Result result = Result.fail();
		int i = userDao.modifyUser(user);
		if(i > 0)
		{
			result = Result.success();
			result.setResultMsg("修改成功!");
		}
		return result;
	}
	
	/**
	 * 添加好友
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Result addFriend(User user) throws Exception
	{
		Result result = Result.fail();
		return result;
	}
	
	/**
	 * 查找好友(模糊查询)
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Result searchFriend(User user,HttpServletRequest request) throws Exception
	{
		Result result = Result.fail();
		HttpSession session = request.getSession();
		Map<String,Object> loginInfo = (Map<String, Object>) session.getAttribute("loginInfo");
		user.setUserId(MapUtils.getString(loginInfo, "user_id"));
		List<Map<String,Object>> friendsList = userDao.qryFriendsByUserName(user);
		if(null == friendsList || friendsList.size() == 0)
		{
			result.setResultMsg("查无此人!");
			return result;
		}
		result = Result.success();
		Map<String,Object> extend = new HashMap<String,Object>();
		extend.put("friendsList", friendsList);
		result.setExtend(extend);
		return result;
	}
	
	/**
	 * 展示所有好友
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> listAllFriends(User user) throws Exception
	{
		return userDao.qryFriendsByUserName(user);
	}
	
	/**
	 * 展示所有用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Result listAllUser(User user,HttpServletRequest request) throws Exception
	{
		Result result = Result.fail();
		Map<String,Object> extend = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		Map<String,Object> loginUser =  (Map<String,Object>) session.getAttribute("loginInfo");
		List<Map<String,Object>> userList = userDao.listAllUser(user,MapUtils.getString(loginUser, "user_id"));
		if(null == userList || userList.size() == 0)
		{
			result.setResultMsg("查无数据");
			return result;
		}
		result = Result.success();
		result.setResultMsg("查询完成!");
		extend.put("allUser", userList);
		result.setExtend(extend);
		return result;
	}
	
	/**
	 * 发送好友申请(入好友申请记录表)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Result sendFriendApplication(Map<String,Object> paramMap,
			HttpServletRequest request) throws Exception
	{
		Result result = Result.fail();
		Map<String,Object> loginUserMap = (Map<String, Object>) request.getSession().getAttribute("loginInfo");
		paramMap.put("sender_id", MapUtils.getString(loginUserMap, "user_id"));
		//校验是否重复发送
		boolean isRepeat = userDao.checkRepeatAddFriendApply(paramMap);
		if(isRepeat)
		{
			result.setResultMsg("不允许重复发送!");
			return result;
		}
		int i = userDao.addFriendApplication(paramMap);
		if(i > 0)
		{
			result = Result.success();
			result.setResultMsg("好友申请已发送!");
		}
		return result;
	}
	
	/**
	 * 回复好友申请(更新好友申请记录表,入好友关系表)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Result replyFriendApplication(Map<String,Object> paramMap,
			HttpServletRequest request) throws Exception
	{
		Result result = Result.fail();
		Map<String,Object> loginUserMap = (Map<String, Object>) request.getSession().getAttribute("loginInfo");
		
		//1.更新好友申请记录表
		updateFARecord(paramMap);
		if("no".equals(MapUtils.getString(paramMap, "status")))
		{
			result.setResultMsg("已拒绝!");
			return result;
		}
		//2.入好友关系表(两条数据)
		addFriend(paramMap,loginUserMap);
		result = Result.success();
		result.setResultMsg("你们已经是好友了，请愉快的聊天吧!");
		return result;
	}
	
	private void addFriend(Map<String,Object> paramMap,Map<String,Object> loginUserMap) 
			throws Exception
	{
		Map<String,Object> requestMap1 = new HashMap<String,Object>();
		Map<String,Object> requestMap2 = new HashMap<String,Object>();
		requestMap1.put("userId", MapUtils.getString(paramMap, "sender_id"));
		requestMap1.put("friendId", MapUtils.getString(loginUserMap, "user_id"));
		requestMap1.put("status", 2);
		userDao.addFriend(requestMap1);
		requestMap2.put("userId", MapUtils.getString(loginUserMap, "user_id"));
		requestMap2.put("friendId", MapUtils.getString(paramMap, "sender_id"));
		requestMap2.put("status", 2);
		userDao.addFriend(requestMap2);
	}
	
	private void updateFARecord(Map<String,Object> paramMap) throws Exception
	{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("id", MapUtils.getInteger(paramMap, "id"));
		if("yes".equals(MapUtils.getString(paramMap, "status")))
		{
			//同意加好友
			requestMap.put("status", 1);
		}
		else
		{
			//拒绝
			requestMap.put("status", 2);
		}
		userDao.updateFriendApplyStatus(requestMap);
	}

}
