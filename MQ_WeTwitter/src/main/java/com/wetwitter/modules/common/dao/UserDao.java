package com.wetwitter.modules.common.dao;

import java.util.List;
import java.util.Map;
import com.wetwitter.modules.common.model.User;

public interface UserDao 
{
	public boolean checkUserExist(User user) throws Exception;
	
	public int addUser(User user) throws Exception;
	
	public int addUserState(User user) throws Exception;
	
	public Map<String,Object> qryUserByUserName(User user) throws Exception;
	
	public int modifyUser(User user) throws Exception;
	
	public List<Map<String,Object>> qryFriendsByUserName(User user) throws Exception;
	
	public int modifyUserState(User user) throws Exception;
	
	public List<Map<String,Object>> listAllUser(User user,String userId) throws Exception;

}
