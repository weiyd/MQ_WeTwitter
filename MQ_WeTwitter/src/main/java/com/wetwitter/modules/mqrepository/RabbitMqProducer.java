package com.wetwitter.modules.mqrepository;

import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wetwitter.modules.common.model.RabbitMqEnum;

/**
 * rabbitmq生产者
 * @author sunwei
 *
 */
@Component
public class RabbitMqProducer implements RabbitTemplate.ConfirmCallback
{
	private static Logger logger = Logger.getLogger(RabbitMqProducer.class);
	
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
    public RabbitMqProducer(RabbitTemplate rabbitTemplate) 
	{
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }

	@Override
	public void confirm(CorrelationData arg0, boolean arg1, String arg2) {
		logger.info("回调id:" + arg0.getId());
		if(arg1)
		{
			logger.info("消息成功消费");
		}
		else
		{
			logger.info("消息消费失败：" + arg2);
		}
	}
	
	/**
     * 发送到 指定routekey的指定queue
     * @param routeKey
     * @param obj
     */
    public void sendRabbitmqDirect(String routeKey,Object obj) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("消息id: " + correlationData.getId());
        logger.info("消息体: " + obj);
        this.rabbitTemplate.convertAndSend(RabbitMqEnum.Exchange.CONTRACT_DIRECT.getCode(), routeKey , obj, correlationData);
    }
    
    /**
     * 所有发送到Topic Exchange的消息被转发到所有关心RouteKey中指定Topic的Queue上
     * @param routeKey
     * @param obj
     */
    public void sendRabbitmqTopic(String routeKey,Object obj) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("消息id: " + correlationData.getId());
        logger.info("消息体: " + obj);
        this.rabbitTemplate.convertAndSend(RabbitMqEnum.Exchange.CONTRACT_TOPIC.getCode(), routeKey , obj, correlationData);
    }
	
}
