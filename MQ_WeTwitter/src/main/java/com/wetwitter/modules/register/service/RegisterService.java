package com.wetwitter.modules.register.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wetwitter.modules.common.dao.UserDao;
import com.wetwitter.modules.common.model.Result;
import com.wetwitter.modules.common.model.User;

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
		
		//插入用户
		user.setUserId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
		int i = userDao.addUser(user);
		if(i > 0)
		{
			result = Result.success();
			result.setResultMsg("注册成功!");
		}
		return result;
	}

}
