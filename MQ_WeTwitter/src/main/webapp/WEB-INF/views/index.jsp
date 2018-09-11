<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>聊天云平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/index.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/index.js"></script>
</head>
<body>
<div class="all">
    <div class="chat_index">
        <!--banner-->
        <div class="chat_banner">
 
        </div>
 
        <div class="chat_body">
            <!--在线列表-->
            <div class="chat_online">
                <!--搜索-->
                <div class="search_online">
                    <form>
                        <input type="text" placeholder="搜索联系人">
                    </form>
                </div>
                <div class="online_friend">
                    <ul>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">
 
                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>
 
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">
 
                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>
 
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">
 
                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>
 
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">
 
                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>
 
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
 
            </div>
            <!--聊天界面-->
            <div class="chat_main">
                <div class="chat_div">
                    <ul id="chat_ul" class="chat_content">
 
                    </ul>
 
                </div>
 
                <div class="send_message">
                    <form>
                        <input type="text" placeholder="请输入消息" id="send_txt">
                        <input type="button" value="发送" id="send_btn">
                    </form>
                </div>
            </div>
            <!--名片-->
            <div class="chat_namecard">
 
            </div>
        </div>
 
    </div>
</div>
</body>
</html>

