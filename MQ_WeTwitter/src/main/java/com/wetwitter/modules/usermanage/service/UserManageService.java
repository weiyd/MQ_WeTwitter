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

}
