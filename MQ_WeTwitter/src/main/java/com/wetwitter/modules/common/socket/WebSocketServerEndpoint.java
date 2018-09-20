package com.wetwitter.modules.common.socket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


@ServerEndpoint("/ws/{userId}")
@Component
public class WebSocketServerEndpoint 
{
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
	
	private static Logger log = Logger.getLogger(WebSocketServerEndpoint.class);
	
	/**
     * 存活的session集合（使用线程安全的map保存）
     */
    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();
 
    /**
     * 建立连接的回调方法
     *
     * @param session 与客户端的WebSocket连接会话
     * @param userId  用户名，WebSocket支持路径参数
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        livingSessions.put(userId, session);
        addOnlineCount();
        log.info(userId + " 进入连接");
    }
 
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("userId") String userId) {
        log.info(userId + " : " + message);
        sendMessageToAll(userId + " : " + message);
    }
 
 
    @OnError
    public void onError(Session session, Throwable error) {
        log.info("发生错误");
        log.error(error.getStackTrace() + "");
    }
 
 
    @OnClose
    public void onClose(Session session, @PathParam("userId") String userId) {
        livingSessions.remove(userId);
        log.info(userId + " 关闭连接");
        subOnlineCount();
    }
 
    /**
     * 单独发送消息
     *
     * @param session
     * @param message
     */
    public void sendMessage(String receiverUserName, String message) 
    {
        try 
        {
        	boolean isLogin = livingSessions.containsKey(receiverUserName);
        	if(livingSessions.containsKey(receiverUserName))
        	{
        		Session session = livingSessions.get(receiverUserName);
        		session.getBasicRemote().sendText(message);;
        		
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 群发消息
     *
     * @param message
     */
    public void sendMessageToAll(String message) 
    {
//    	String receiverId = topic.split(".")[2];
        livingSessions.forEach((sessionId, session) -> {
            //发给指定的接收用户
//            if (userId.equals(receiverId)) {
            sendMessage(sessionId, message);
//            }
        });
    }
    
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
 
    public static synchronized void addOnlineCount() {
    	WebSocketServerEndpoint.onlineCount++;
    }
 
    public static synchronized void subOnlineCount() {
    	WebSocketServerEndpoint.onlineCount--;
    }

}
