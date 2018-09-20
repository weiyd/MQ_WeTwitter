package com.wetwitter.modules.common.config;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.wetwitter.modules.common.model.RabbitMqEnum;

/**
 * 用于配置交换机和队列对应关系
 * 新增消息队列应该按照如下步骤
 * 1、增加queue bean，参见queueXXXX方法
 * 2、增加queue和exchange的binding
 **/

@Configuration
@AutoConfigureAfter(RabbitMqConfig.class)
public class RabbitMqExchangeConfig 
{
	private static Logger logger = Logger.getLogger(RabbitMqExchangeConfig.class);
	
	/**
     * @Description: 主题型交换机
     * @param
     * @return
     */
    @Bean
    TopicExchange contractTopicExchangeDurable(RabbitAdmin rabbitAdmin){
        TopicExchange contractTopicExchange = new TopicExchange(RabbitMqEnum.Exchange.CONTRACT_TOPIC.getCode());
        rabbitAdmin.declareExchange(contractTopicExchange);
        logger.debug("完成主题型交换机bean实例化");
        return contractTopicExchange;
    }
    
    /**
     * @Description: 直连型交换机
     * @param
     * @return
     */
    @Bean
    DirectExchange contractDirectExchange(RabbitAdmin rabbitAdmin) {
        DirectExchange contractDirectExchange = new DirectExchange(RabbitMqEnum.Exchange.CONTRACT_DIRECT.getCode());
        rabbitAdmin.declareExchange(contractDirectExchange);
        logger.debug("完成直连型交换机bean实例化");
        return contractDirectExchange;
    }
    
    /**
     * 私聊队列定义
     */
    @Bean
    Queue personalQueue(RabbitAdmin rabbitAdmin) {
    	Queue queue = new Queue(RabbitMqEnum.QueueName.PERSONALQUEUE.getCode());
    	rabbitAdmin.declareQueue(queue);
    	logger.info("私聊队列实例化完成");
    	return queue;
    }
    
    /**
     * 群聊队列定义
     */
    @Bean
    Queue groupQueue(RabbitAdmin rabbitAdmin) {
    	Queue queue = new Queue(RabbitMqEnum.QueueName.GROUPQUEUE.getCode());
    	rabbitAdmin.declareQueue(queue);
    	logger.info("群聊队列实例化完成");
    	return queue;
    }
    
    /**
     * 交换机和队列绑定
     */
   /* @Bean
    Binding bindingPersonalQueue(DirectExchange exchange, 
    		RabbitAdmin rabbitAdmin) {
    	Binding binding = BindingBuilder.bind(personalQueue(rabbitAdmin)).to(exchange).with(RabbitMqEnum.
    			QueueEnum.PERSONALQUEUE.getCode());
    	rabbitAdmin.declareBinding(binding);
    	logger.info("私聊队列routingKey和直连型交换机绑定完成");
    	return binding;
    }
    
    @Bean
    Binding bindingGroupQueue(DirectExchange exchange, 
    		RabbitAdmin rabbitAdmin) {
    	Binding binding = BindingBuilder.bind(groupQueue(rabbitAdmin)).to(exchange).with(RabbitMqEnum
    			.QueueEnum.GROUPQUEUE.getCode());
    	rabbitAdmin.declareBinding(binding);
    	logger.info("群聊队列routingKey和直连型交换机绑定完成");
    	return binding;
    }*/
    
    @Bean
    Binding bindingPersonalQueue(TopicExchange exchange, 
    		RabbitAdmin rabbitAdmin) {
    	Binding binding = BindingBuilder.bind(personalQueue(rabbitAdmin)).to(exchange).with(RabbitMqEnum.
    			QueueEnum.PERSONALQUEUE.getCode());
    	rabbitAdmin.declareBinding(binding);
    	logger.info("私聊队列routingKey和直连型交换机绑定完成");
    	return binding;
    }
    
    @Bean
    Binding bindingGroupQueue(TopicExchange exchange, 
    		RabbitAdmin rabbitAdmin) {
    	Binding binding = BindingBuilder.bind(groupQueue(rabbitAdmin)).to(exchange).with(RabbitMqEnum
    			.QueueEnum.GROUPQUEUE.getCode());
    	rabbitAdmin.declareBinding(binding);
    	logger.info("群聊队列routingKey和直连型交换机绑定完成");
    	return binding;
    }
    
}
