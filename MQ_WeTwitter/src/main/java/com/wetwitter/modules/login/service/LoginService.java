package com.wetwitter.modules.login.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wetwitter.modules.common.dao.UserDao;
import com.wetwitter.modules.common.model.Result;
import com.wetwitter.modules.common.model.User;
import com.wetwitter.modules.common.utils.MD5Utils;

@Service
public class LoginService 
{
	@Autowired
	private UserDao userDao;
	
	/**
	 * 用户名+密码登录
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Result loginByAll(User user, HttpServletRequest request) throws Exception
	{
		Result loginResult = Result.fail();
		HttpSession session = request.getSession();
		String password = user.getPassword();
		String checkCode = user.getCheckCode();
		Boolean res= this.validateKcaptcha(checkCode, request);
		if(!res) {
			//验证码错误
			loginResult.setResultMsg("验证码错误!");
			return loginResult;
		}
		//验证用户名+密码
		Map<String,Object> userMap = userDao.qryUserByUserName(user);
		if(null == userMap)
		{
			loginResult.setResultMsg("用户名不存在!");
			return loginResult;
		}
		if(MapUtils.getInteger(userMap, "user_active") != 0)
		{
			loginResult.setResultMsg("用户已失效!");
			return loginResult;
		}
		if(!MD5Utils.md5(password).equals(
				MapUtils.getString(userMap, "user_pwd")))
		{
			loginResult.setResultMsg("密码错误!");
			return loginResult;
		}
		session.setAttribute("loginInfo", userMap);
		loginResult = Result.success();
		return loginResult;
	}
	
	/**
	 * 
	* @Title: validateKcaptcha 
	* @Description: TODO
	* @author: peter
	* @date: 2017年10月8日 上午11:45:43
	* @return Boolean
	* @throws
	 */
	public Boolean validateKcaptcha(String checkCode, HttpServletRequest request) throws Exception{
		String sessionCode = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		Boolean isSuccess = false;
		sessionCode = sessionCode.toUpperCase();
		checkCode = checkCode.toUpperCase();
		if (checkCode != null && checkCode.equals(sessionCode)) {
		    isSuccess = true;
		} else {
		    isSuccess = false;
		}
		return isSuccess;
	}

}
