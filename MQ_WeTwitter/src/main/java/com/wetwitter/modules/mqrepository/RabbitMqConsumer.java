package com.wetwitter.modules.mqrepository;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rabbitmq.client.Channel;
import com.wetwitter.modules.common.model.RabbitMqEnum;

@Configuration
public class RabbitMqConsumer 
{
	private static Logger logger = Logger.getLogger(RabbitMqConsumer.class);
	
	@Bean
	public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(RabbitMqEnum.QueueName.PERSONALQUEUE.getCode());
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(
			new ChannelAwareMessageListener() 
			{
	            @Override
	            public void onMessage(Message message, Channel channel) throws Exception {
	            	System.out.println("消费开始....");
	            	logger.info(
							"消费端接收到消息:" + message.getMessageProperties() + ":" + new String(message.getBody()));
	            	logger.info("topic:"+message.getMessageProperties().getReceivedRoutingKey());
					channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); // false只确认当前一个消息收到，true确认所有consumer获得的消息
					System.out.println("消费结束....");
            }
        });
        return container;
	}
	
	/*@Bean
    public ChannelAwareMessageListener exampleListener() {
        return new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
            	logger.info(
						"消费端接收到消息:" + message.getMessageProperties() + ":" + new String(message.getBody()));
            	logger.info("topic:"+message.getMessageProperties().getReceivedRoutingKey());
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); // false只确认当前一个消息收到，true确认所有consumer获得的消息

            }
        };
    }*/

}
