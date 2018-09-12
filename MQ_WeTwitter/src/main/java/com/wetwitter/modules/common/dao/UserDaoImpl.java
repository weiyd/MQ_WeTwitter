package com.wetwitter.modules.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Repository;
import com.wetwitter.modules.common.model.User;

@Repository
public class UserDaoImpl extends WeTwitterCommonDao implements UserDao
{

	@Override
	public boolean checkUserExist(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" select count(user_id) as count from MQ_USER where user_name = :userName ");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userName", user.getUserName());
		Map<String,Object> result = super.queryForMap(sb.toString(), paramMap);
		if(MapUtils.getInteger(result, "count") > 0)
		{
			return false;
		}
		return true;
	}

	@Override
	public int addUser(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into MQ_USER(user_id,user_name,user_pwd,user_phone,user_mail,user_active,user_active_date,user_expired_date)");
		sb.append(" values(:userId,:userName,:userPwd,:userPhone,:userMail,'0',SYSDATE(),null)");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", user.getUserId());
		paramMap.put("userName", user.getUserName());
		paramMap.put("userPwd", user.getPassword());
		paramMap.put("userPhone", user.getPhoneNumber());
		paramMap.put("userMail", user.getEmail());
		return super.update(sb.toString(), paramMap);
	}

	@Override
	public Map<String, Object> qryUserByUserName(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" select user_id,user_name,user_pwd,user_phone,user_mail,user_active ");
		sb.append(" from MQ_USER where user_name = :userName ");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userName", user.getUserName());
		return super.queryForMap(sb.toString(), paramMap);
	}

	@Override
	public int modifyUser(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" update MQ_USER set user_name=:userName,user_pwd=:pwd,");
		sb.append(" user_phone=:phoneNumber,user_mail=:mail where user_id=userId ");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userName", user.getUserName());
		paramMap.put("pwd", user.getPassword());
		paramMap.put("phoneNumber", user.getPhoneNumber());
		paramMap.put("mail", user.getEmail());
		paramMap.put("userId", user.getUserId());
		return super.update(sb.toString(), paramMap);
	}

	@Override
	public List<User> qryFriendsByUserName(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" select user_id,user_name,user_phone,user_mail from MQ_USER ");
		sb.append(" where user_name like '%");
		sb.append(":userName");
		sb.append("'%");
		sb.append(" and user_active=0 ");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userName", user.getUserName());
		return super.queryForList(sb.toString(), paramMap, User.class);
	}
	
}
