package com.wetwitter.modules.usermanage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Result searchFriend(User user) throws Exception
	{
		Result result = Result.fail();
		List<User> friendsList = userDao.qryFriendsByUserName(user);
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

}
