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
	
	public int addFriendApplication(Map<String,Object> paramMap) throws Exception;
	
	public boolean checkRepeatAddFriendApply(Map<String,Object> paramMap) throws Exception;
	
	public List<Map<String,Object>> listAllToConfirmFriendNews(String receiver_id) throws Exception;
	
	public int updateFriendApplyStatus(Map<String,Object> paramMap) throws Exception;
	
	public int addFriend(Map<String,Object> paramMap) throws Exception;

}
