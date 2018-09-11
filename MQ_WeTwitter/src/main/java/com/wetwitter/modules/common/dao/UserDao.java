package com.wetwitter.modules.common.dao;

import java.util.Map;
import com.wetwitter.modules.common.model.User;

public interface UserDao 
{
	public boolean checkUserExist(User user) throws Exception;
	
	public int addUser(User user) throws Exception;
	
	public Map<String,Object> qryUserByUserName(User user) throws Exception;

}
