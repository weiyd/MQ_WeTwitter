package com.wetwitter.modules.newsmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wetwitter.modules.common.dao.UserDao;
import com.wetwitter.modules.common.model.News;
import com.wetwitter.modules.common.utils.MapHelper;

@Service
public class NewsManageService 
{
	@Autowired
	private UserDao userDao;
	
	public List<News> qryToConfirmFriendNews(Map<String,Object> loginInfo) 
			throws Exception
	{
		List<News> newsList = new ArrayList<News>();
		List<Map<String, Object>> newsListTemp = 
				userDao.listAllToConfirmFriendNews(MapUtils.getString(loginInfo, "user_id"));
		for(Map<String, Object> mapInfo : newsListTemp)
		{
			News newInfo = MapHelper.mapToBean(mapInfo, News.class);
			newsList.add(newInfo);
		}
		
		return newsList;
	}

}
