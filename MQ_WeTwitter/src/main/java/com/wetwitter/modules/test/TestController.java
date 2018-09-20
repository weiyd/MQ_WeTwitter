package com.wetwitter.modules.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wetwitter.modules.mqrepository.RabbitMqProducer;

@Controller
@RequestMapping(value="/testMq")
public class TestController 
{
	@Autowired
	private RabbitMqProducer rabbitMqProducer;
	
	@RequestMapping(value="/personalChat")
	@ResponseBody
	public String personalChat(HttpServletRequest request)
	{
		System.out.println("MQ Test is starting......");
		rabbitMqProducer.sendRabbitmqTopic("personal.sunwei2.sunwei1", "alun is sb!");
		System.out.println("MQ Test is ending......");
		return "success";
	}

}
