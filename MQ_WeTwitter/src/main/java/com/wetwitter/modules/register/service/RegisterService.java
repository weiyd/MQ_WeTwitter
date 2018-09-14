package com.wetwitter.modules.register.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wetwitter.modules.common.dao.UserDao;
import com.wetwitter.modules.common.model.Result;
import com.wetwitter.modules.common.model.User;
import com.wetwitter.modules.common.utils.MD5Utils;

@Service
public class RegisterService 
{
	@Autowired
	private UserDao userDao;
	
	/**
	 * 注册
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public Result register(User user) throws Exception
	{
		Result result = Result.fail();
		//校验唯一性,用户名不能重复
		if(!userDao.checkUserExist(user))
		{
			result.setResultMsg("用户名重复!");
			return result;
		}
		
		//插入用户表
		user.setUserId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
		String pwd = user.getPassword();
		user.setPassword(MD5Utils.md5(pwd));
		int i = userDao.addUser(user);
		if(i > 0)
		{
			int j = userDao.addUserState(user);
			if(j > 0)
			{
				result = Result.success();
				result.setResultMsg("注册成功!");
			}
		}
		return result;
	}

}
