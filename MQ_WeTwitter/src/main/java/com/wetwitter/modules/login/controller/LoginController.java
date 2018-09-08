package com.wetwitter.modules.login.controller;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wetwitter.modules.common.model.Result;
import com.wetwitter.modules.common.model.User;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
@RequestMapping(value="/loginService")
public class LoginController 
{
	@Autowired  
    private DefaultKaptcha captchaProducer;
	
	@RequestMapping(value="/toLogin.do")
	public String toLogin()
	{
		return "/login";
	}
	
	@RequestMapping(value="/login.do")
	@ResponseBody
	public Result login(@RequestBody User user,HttpServletRequest request) throws Exception
	{
		Result loginResult = Result.fail();
		String userName = user.getUserName();
		String password = user.getPassword();
		String checkCode = user.getCheckCode();
		Boolean res= this.validateKcaptcha(checkCode, request);
		if(!res) {
			//验证码错误
			loginResult.setResultMsg("验证码错误!");
			return loginResult;
		}
		return loginResult;
	}
	
	@RequestMapping(value="/toIndex.do")
	public String toIndex(HttpServletRequest request,HttpServletResponse response)
	{
		return "/index.jsp";
	}
	
	/**
	 * 
	* @Title: validateKcaptcha 
	* @Description: TODO
	* @author: peter
	* @date: 2017年10月8日 上午11:45:43
	* @return Boolean
	* @throws
	 */
	public Boolean validateKcaptcha(String checkCode, HttpServletRequest request) throws Exception{
		String sessionCode = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		Boolean isSuccess = false;
		sessionCode = sessionCode.toUpperCase();
		checkCode = checkCode.toUpperCase();
		if (checkCode != null && checkCode.equals(sessionCode)) {
		    isSuccess = true;
		} else {
		    isSuccess = false;
		}
		return isSuccess;
	}
	/**
	 * 
	* @Title: getCaptchaImage 
	* @Description: 验证码
	* @author: peter
	* @date: 2017年10月8日 上午11:59:32
	* @return void
	* @throws
	 */
	@RequestMapping("/kaptcha.jpg")
	public void getCaptchaImage(Model model,HttpServletRequest request, HttpServletResponse response,  
            @RequestParam(value = "timestamp", required = false) String timestamp) throws Exception
	{
		if (StringUtils.isEmpty(timestamp)) 
		{
            model.addAttribute("timestamp", System.currentTimeMillis());  
        } 
		else 
		{
            model.addAttribute("timestamp", timestamp);  
        }  
		response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");  
        
		String codeStr = captchaProducer.createText();
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, codeStr);
		BufferedImage bi = captchaProducer.createImage(codeStr);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try 
		{  
            out.flush();  
        } finally {  
            out.close();  
        }
		
	}

}
