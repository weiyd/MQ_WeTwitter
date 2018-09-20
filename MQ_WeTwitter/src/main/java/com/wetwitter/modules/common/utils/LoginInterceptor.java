package com.wetwitter.modules.common.utils;
 
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
/**
 * 登录验证拦截
 *
 */
@Controller
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter 
{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String basePath = request.getContextPath();
		String path = request.getRequestURI();
		
		if(!doLoginInterceptor(path, basePath) ){//是否进行登陆拦截
			return true;
		}
		
		//如果登录了，会把用户信息存进session
		HttpSession session = request.getSession();
		Map<String,Object> user =  (Map<String,Object>) session.getAttribute("loginInfo");
		if(null != user){
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		return false;
	}
	
	/**
	 * 是否进行登陆过滤
	 * @param path
	 * @param basePath
	 * @return
	 */
	private boolean doLoginInterceptor(String path,String basePath)
	{
		path = path.substring(basePath.length());
		Set<String> notLoginPaths = new HashSet<>();
		//设置不进行登录拦截的路径：登录注册和验证码
		notLoginPaths.add("/loginService/toLogin.do");
		notLoginPaths.add("/registerService/toRegister.do");
		notLoginPaths.add("/loginService/kaptcha.jpg");
		notLoginPaths.add("/loginService/login.do");
		notLoginPaths.add("/registerService/register.do");
		notLoginPaths.add("/testMq/personalChat");
		if(notLoginPaths.contains(path)) return false;
		return true;
	}
}
