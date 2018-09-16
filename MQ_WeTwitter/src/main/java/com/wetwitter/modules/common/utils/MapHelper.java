package com.wetwitter.modules.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.Logger;

public class MapHelper 
{
	private static Logger log = Logger.getLogger(MapHelper.class);
	
	/**
	 * 使用Introspector，map集合成javabean
	 *
	 * @param map       map
	 * @param beanClass bean的Class类
	 * @return bean对象
	 */
	public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) {
	 
	    if (MapUtils.isEmpty(map)) {
	        return null;
	    }
	 
	    try {
	        T t = beanClass.newInstance();
	        BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(t, value);
                }
            }
	        return t;
	    } catch (Exception ex) {
	        log.error("########map集合转javabean出错######，错误信息:" + ex.getMessage());
	        throw new RuntimeException();
	    }
	 
	}
	 
	/**
	 * 使用Introspector，对象转换为map集合
	 *
	 * @param beanObj javabean对象
	 * @return map集合
	 */
	public static Map<String, Object> beanToMap(Object beanObj) {
	 
	    if (null == beanObj) {
	        return null;
	    }
	 
	    Map<String, Object> map = new HashMap<>();
	 
	    try {
	        BeanInfo beanInfo = Introspector.getBeanInfo(beanObj.getClass());
	        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
	        for (PropertyDescriptor property : propertyDescriptors) {
	            String key = property.getName();
	            if (key.compareToIgnoreCase("class") == 0) {
	                continue;
	            }
	            Method getter = property.getReadMethod();
	            Object value = getter != null ? getter.invoke(beanObj) : null;
	            map.put(key, value);
	        }
	 
	        return map;
	    } catch (Exception ex) {
	        log.error("########javabean集合转map出错######，错误信息:" + ex.getMessage());
	        throw new RuntimeException();
	    }
	}


}
