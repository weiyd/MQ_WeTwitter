package com.wetwitter.modules.common.model;

public class RabbitMqEnum 
{
	/**
     * @param
     * @Description:定义数据交换方式
     * @return
     */
    public enum Exchange 
    {
        CONTRACT_FANOUT("CONTRACT_FANOUT", "消息分发"),
        CONTRACT_TOPIC("CONTRACT_TOPIC", "消息订阅"),
        CONTRACT_DIRECT("CONTRACT_DIRECT", "点对点");

        private String code;
        private String name;

        Exchange(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * describe: 定义队列名称
     **/
    public enum QueueName 
    {
        PERSONALQUEUE("personal_queue", "私聊队列"),
        GROUPQUEUE("group_queue", "群聊队列");

        private String code;
        private String name;

        QueueName(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * describe: 定义routing_key
     **/
    public enum QueueEnum 
    {
    	PERSONALQUEUE("personal.*.*", "私聊"),//格式：personal.发送者Id.接受者Id
        GROUPQUEUE("group.*.*", "群聊");//格式：group.发送者Id.群Id

        private String code;
        private String name;

        QueueEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

}
