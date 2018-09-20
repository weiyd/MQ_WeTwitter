package com.wetwitter;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableRabbit
public class MqWeTwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqWeTwitterApplication.class, args);
	}
}
