package com.wetwitter.modules.mqrepository;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.wetwitter.modules.common.config.RabbitMqConfig;
import com.wetwitter.modules.common.model.RabbitMqEnum;
import com.wetwitter.modules.mqrepository.business.PersonalQueueBusiness;

@Configuration
@AutoConfigureAfter(RabbitMqConfig.class)
public class RabbitMqConsumer 
{
	private static Logger logger = Logger.getLogger(RabbitMqConsumer.class);
	
	@Autowired
	private PersonalQueueBusiness personalQueueBusiness;
	
	@Autowired
	ConnectionFactory connectionFactory;
	
	@Bean
	public MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(RabbitMqEnum.QueueName.PERSONALQUEUE.getCode());
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(personalQueueBusiness);
        return container;
	}
}
