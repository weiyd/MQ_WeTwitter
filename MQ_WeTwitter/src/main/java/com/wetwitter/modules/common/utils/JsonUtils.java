package com.wetwitter.modules.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils 
{
	public static Map<String, Object> toMap(String jsonString) throws JSONException  
	{  
        JSONObject jsonObject = new JSONObject(jsonString);  
        Map<String, Object> result = new HashMap<String, Object>();  
        Iterator<?> iterator = jsonObject.keys();  
        String key = null;  
        String value = null;  
        while (iterator.hasNext()) 
        {  
            key = (String) iterator.next();  
            value = jsonObject.getString(key);  
            result.put(key, value);  
        }  
        return result;  
    } 
}
