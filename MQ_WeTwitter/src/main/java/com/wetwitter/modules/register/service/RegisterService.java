package com.wetwitter.modules.register.service;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections4.MapUtils;
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
	public Result register(Map<String,Object> paramMap) throws Exception
	{
		Result result = Result.fail();
		User user = new User();
		user.setUserName(MapUtils.getString(paramMap, "userName"));
		user.setPassword(MapUtils.getString(paramMap, "password"));
		user.setPhoneNumber(MapUtils.getString(paramMap, "phoneNumber"));
		user.setEmail(MapUtils.getString(paramMap, "email"));
		//校验唯一性,用户名不能重复
		
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
