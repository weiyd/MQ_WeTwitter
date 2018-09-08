package com.wetwitter.modules.common.model;

import java.io.Serializable;

public class User implements Serializable
{
	/**
	 * 登录名
	 */
	private String userName;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * 验证码
	 */
	private String checkCode;
	
	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
}
