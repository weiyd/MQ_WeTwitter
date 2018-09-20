package com.wetwitter.modules.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.wetwitter.modules.mqrepository.RabbitMqProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMq 
{
	@Autowired
	private RabbitMqProducer rabbitMqProducer;
	
	@Test
	public void topic() throws Exception {
		System.out.println("MQ Test is starting......");
		rabbitMqProducer.sendRabbitmqDirect("personal.sunwei.alun", "alun is sb!");
		System.out.println("MQ Test is ending......");
	}


}
