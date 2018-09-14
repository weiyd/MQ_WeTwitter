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
	public Map<String,Object> qryUserByUserName(User user) throws Exception {
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
	public List<Map<String,Object>> qryFriendsByUserName(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" select MU.user_id as userId,MU.user_name as userName,US.status as userState from FRIEND_SHIP FS");
		sb.append(" left join MQ_USER MU on FS.friend_id = MU.user_id ");
		sb.append(" left join USER_STATE US on US.user_id = FS.friend_id ");
		sb.append(" where FS.user_id = :userId ");
		if(null != user.getUserName())
		{
			sb.append(" and MU.user_name like CONCAT('%',:userName,'%') ");
		}
		sb.append(" and MU.user_active=0 ");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", user.getUserId());
		if(null != user.getUserName())
		{
			paramMap.put("userName", user.getUserName());
		}
		return super.queryForList(sb.toString(), paramMap);
	}

	@Override
	public int addUserState(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into USER_STATE(user_id,status)");
		sb.append(" values(:userId,0)");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", user.getUserId());
		return super.update(sb.toString(), paramMap);
	}

	@Override
	public int modifyUserState(User user) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" update USER_STATE set status = :state ");
		sb.append(" where user_id=:userId ");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", user.getUserId());
		paramMap.put("state", user.getUserState());
		return super.update(sb.toString(), paramMap);
	}

	@Override
	public List<Map<String, Object>> listAllUser(User user,String userId) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" select MU.user_id,MU.user_name,MU.user_pwd,MU.user_phone,MU.user_mail,US.status ");
		sb.append(" from MQ_USER MU left join USER_STATE US on US.user_id = MU.user_id where MU.user_id != :userId ");
		if(null != user.getUserName() && !"".equals(user.getUserName()))
		{
			sb.append(" and MU.user_name like CONCAT('%',:userName,'%') ");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		if(null != user.getUserName() && !"".equals(user.getUserName()))
		{
			paramMap.put("userName", user.getUserName());
		}
		return super.queryForList(sb.toString(), paramMap);
	}
}
