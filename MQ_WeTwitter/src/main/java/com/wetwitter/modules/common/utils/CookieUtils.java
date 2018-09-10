package com.wetwitter.modules.common.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie操作类
 * @author sunwei
 *
 */
public class CookieUtils {
	/**
	 * 设置cookie
	 * 
	 * @param response
	 * @param name
	 *            cookie名字
	 * @param value
	 *            cookie值
	 * @param maxAge
	 *            cookie生命周期 以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, String name,
			String value, int maxAge) {
		try {
			Cookie cookie = new Cookie(URLEncoder.encode(name,"UTF-8"),URLEncoder.encode(value,"UTF-8") );
			if (maxAge > 0) {
				cookie.setMaxAge(maxAge);
			}
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * 
	 * 删除Cookie操作 clearCookie
	 * 
	 * @param request
	 * @param response
	 * @return boolean
	 * @author sunwei
	 */
	public static boolean clearCookie(HttpServletRequest request,
			HttpServletResponse response, String name) {
		boolean bool = false;
	/*	Cookie[] cookies = request.getCookies();
		if(null == cookies || cookies.length == 0) return bool;*/
		try {
			/*for (int i = 0; i < cookies.length; i++) {*/
				Cookie cookie = new Cookie(URLEncoder.encode(name,"UTF-8"),null );
				cookie.setMaxAge(0);
				cookie.setPath("/");// 根据你创建cookie的路径进行填写
				response.addCookie(cookie);
				bool = true;
		/*	}*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bool;
	}
	/**
	 * 删除某个Cookie操作 clearCookie，指定domain
	 * 
	 * @param request
	 * @param response
	 * @return boolean
	 * @author sunwei
	 */
	public static boolean clearCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String domain) {
		boolean bool = false;
	/*	Cookie[] cookies = request.getCookies();
		if(null == cookies || cookies.length == 0) return bool;*/
		try {
		/*	for (int i = 0; i < cookies.length; i++) {*/
				/*Cookie cookie = new Cookie(name, null);*/
				Cookie cookie = new Cookie(URLEncoder.encode(name,"UTF-8"),null );
				cookie.setMaxAge(0);
				cookie.setPath("/");// 根据你创建cookie的路径进行填写
				cookie.setDomain(domain);
				response.addCookie(cookie);
				bool = true;
			/*}*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bool;
	}
	/**
	 * 删除所有Cookie
	 * 
	 * @param request
	 * @param name
	 * @author sunwei
	 */
	public static boolean clearAllCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Boolean bool=false;
		Cookie[] cookies = request.getCookies();
		if(null == cookies || cookies.length == 0) return bool;
		try {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String cname = URLDecoder.decode(cookie.getName(), "UTF-8");
				Cookie cookieToDelete = new Cookie(URLEncoder.encode(cname,"UTF-8"),null );
				cookieToDelete.setMaxAge(0);
				cookieToDelete.setPath("/");// 根据你创建cookie的路径进行填写
				response.addCookie(cookieToDelete);
			}
			bool = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bool;
	}
	
	/**
	 * 获取指定cookies的值 findCookieByName
	 * 
	 * @param request
	 * @param name
	 * @return String
	 * @author sunwei
	 */
	public static String findCookieByName(HttpServletRequest request,
			String name) {
		Cookie[] cookies = request.getCookies();
		if(null == cookies || cookies.length == 0) return null;
		String string = null;
		try {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String cname = URLDecoder.decode(cookie.getName(), "UTF-8");
				if (cname!=null && cname.equals(name)) {
					string = URLDecoder.decode(cookie.getValue(), "UTF-8");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return string;
	}
	
}
