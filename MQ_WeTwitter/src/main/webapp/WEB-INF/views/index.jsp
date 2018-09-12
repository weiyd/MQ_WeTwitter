<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>叽叽喳喳</title>
    <meta name="keywords" content="叽叽喳喳聊天平台">
    <meta name="description" content="叽叽喳喳聊天平台">
    <link rel="shortcut icon" href="../statics/img/favicon.ico"> <link href="../statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="../statics/css/font-awesome.min.css" rel="stylesheet">
    <link href="../statics/css/plugins/jsTree/style.min.css" rel="stylesheet">
    <link href="../statics/css/animate.min.css" rel="stylesheet">
    <link href="../statics/css/style.min.css" rel="stylesheet">
    <link href="../statics/css/index.css" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">

        <div class="row">
            <div class="col-sm-12">

                <div class="ibox chat-view">

                    <div class="ibox-title">
                        <!-- <small class="pull-right text-muted">最新消息：2015-02-02 18:39:23</small> 聊天窗口 -->
	                    	<button type="button" class="indexSearchBtn btn btn-default btn-sm" id="friendSearchBtn" onclick="javascript:;">
	                                        	搜索 <i class="fa fa-search"></i> </button>
	                    	<input type="text" class="indexSearchContent form-control" name="userName" placeholder="请输入账号">
	                    	<a class="indexAdd btn btn-primary pull-right btn-sm" href="#"  role="button" onclick="showAddFrindBox()"><i class="fa fa-plus"></i>好友</a>
	                     	<a class="indexAdd btn btn-primary pull-right btn-sm" href="#"  role="button" onclick="showAddGroupBox()"><i class="fa fa-plus"></i>群组</a>                        
	                                             聊天窗口
                    </div>


                    <div class="ibox-content">

                        <div class="row">

                            <div class="col-md-9 ">
                                <div class="chat-discussion">

                                    <div class="chat-message">
                                        <img class="message-avatar" src="../statics/img/a1.jpg" alt="">
                                        <div class="message">
                                            <a class="message-author" href="#"> 颜文字君</a>
                                            <span class="message-date"> 2015-02-02 18:39:23 </span>
                                            <span class="message-content">
											H+ 是个好框架
                                            </span>
                                        </div>
                                    </div>
                                    <div class="chat-message">
                                        <img class="message-avatar" src="../statics/img/a4.jpg" alt="">
                                        <div class="message">
                                            <a class="message-author" href="#"> 林依晨Ariel </a>
                                            <span class="message-date">  2015-02-02 11:12:36 </span>
                                            <span class="message-content">
											jQuery表单验证插件 - 让表单验证变得更容易
                                            </span>
                                        </div>
                                    </div>
                                    <div class="chat-message">
                                        <img class="message-avatar" src="../statics/img/a2.jpg" alt="">
                                        <div class="message">
                                            <a class="message-author" href="#"> 谨斯里 </a>
                                            <span class="message-date">  2015-02-02 11:12:36 </span>
                                            <span class="message-content">
											验证日期格式(类似30/30/2008的格式,不验证日期准确性只验证格式
                                            </span>
                                        </div>
                                    </div>
                                    <div class="chat-message">
                                        <img class="message-avatar" src="../statics/img/a5.jpg" alt="">
                                        <div class="message">
                                            <a class="message-author" href="#"> 林依晨Ariel </a>
                                            <span class="message-date">  2015-02-02 - 11:12:36 </span>
                                            <span class="message-content">
											还有约79842492229个Bug需要修复
                                            </span>
                                        </div>
                                    </div>
                                    <div class="chat-message">
                                        <img class="message-avatar" src="../statics/img/a6.jpg" alt="">
                                        <div class="message">
                                            <a class="message-author" href="#"> 林依晨Ariel </a>
                                            <span class="message-date">  2015-02-02 11:12:36 </span>
                                            <span class="message-content">
											九部令人拍案叫绝的惊悚悬疑剧情佳作】如果你喜欢《迷雾》《致命ID》《电锯惊魂》《孤儿》《恐怖游轮》这些好片，那么接下来推荐的9部同类题材并同样出色的的电影，绝对不可错过哦~

                                            </span>
                                        </div>
                                    </div>

                                </div>

                            </div>
                            <div class="col-md-3">
                                <div class="chat-users">


                                    <div class="users-list">
                                        <div class="chat-user">
                                            <img class="chat-avatar" src="../statics/img/a4.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">伤城Simple</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <img class="chat-avatar" src="../statics/img/a1.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">从未出现过的风景__</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <span class="pull-right label label-primary">在线</span>
                                            <img class="chat-avatar" src="../statics/img/a2.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">冬伴花暖</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <span class="pull-right label label-primary">在线</span>
                                            <img class="chat-avatar" src="../statics/img/a3.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">ZM敏姑娘	</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <img class="chat-avatar" src="../statics/img/a5.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">才越越</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <img class="chat-avatar" src="../statics/img/a6.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">时光十年TENSHI</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <img class="chat-avatar" src="../statics/img/a2.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">刘顰颖</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <span class="pull-right label label-primary">在线</span>
                                            <img class="chat-avatar" src="../statics/img/a3.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="#">陈泳儿SccBaby</a>
                                            </div>
                                        </div>


                                    </div>

                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="chat-message-form">

                                    <div class="form-group">

                                        <textarea class="form-control message-input" name="message" placeholder="输入消息内容，按回车键发送"></textarea>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 隐藏添加好友div -->
    <div class="search-box-msg" id="addFriend" style="display:none">
	   <form class="form-inline">
		  <div class="form-group">
			    <input type="text" class="form-control" name="fname" placeholder="请输入用户名">
		  </div>
			  <button type="button" class="btn btn-default btn-sm" id="searchBtn" onclick="javascript:;">
             	搜索 <i class="fa fa-search"></i>
         	  </button>
         	  <button type="button" class="btn btn-default btn-sm" id="clearBtn" onclick="javascript:;">
             	清空 
         	  </button>
         	  <button type="button" class="close"><span>x</span></button>
	    </form>
	    <div class="new-table-responsive">
	    	<div class="box-body table-responsive no-padding ">
	    		<table class="table table-hover">
	    			<tr>
                       <th><input type="checkbox" name="" id="all"/></th>
                       <th>序号</th>
                       <th>用户名</th>
                       <th>手机</th>
                       <th>状态</th>
                       <th style="width: 100px;">操作</th>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
	    		</table>
	    	</div>
	    </div>
    </div>
    
    <!-- 隐藏创建群聊div -->
    <div class="search-box-msg" id="addGroupChat" style="display:none">
	   <form class="form-inline">
		  <div class="form-group">
			    <input type="text" class="form-control" name="fname" placeholder="请输入用户名">
		  </div>
			  <button type="button" class="btn btn-default btn-sm" id="searchBtn" onclick="javascript:;">
             	搜索 <i class="fa fa-search"></i>
         	  </button>
         	  <button type="button" class="btn btn-default btn-sm" id="clearBtn" onclick="javascript:;">
             	清空 
         	  </button>
         	  <button type="button" class="close"><span>x</span></button>
	    </form>
	    <div class="new-table-responsive">
	    	<div class="box-body table-responsive no-padding ">
	    		<table class="table table-hover">
	    			<tr>
                       <th><input type="checkbox" name="" id="all"/></th>
                       <th>序号</th>
                       <th>用户名</th>
                       <th>手机</th>
                       <th>状态</th>
                       <th style="width: 100px;">操作</th>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
                    <tr>
                    	<td><input type="checkbox" name="" id="all"/></td>
                    	<td>1</td>
                    	<td>sunwei</td>
                    	<td>18752063928</td>
                    	<td>在线</td>
                    </tr>
	    		</table>
	    	</div>
	    </div>
    </div>
    <script src="../statics/jquery/jquery-2.2.3.min.js"></script>
    <script src="../statics/bootstrap/js/bootstrap.min.js"></script>
    <script src="../statics/bootstrap/js/bootstrap.js"></script>
    <script src="../statics/js/content.min.js"></script>
    <script>
	    function showAddFrindBox() {
	    	$("#addFriend").show();
		};
		
		function showAddGroupBox() {
	    	$("#addGroupChat").show();
		};
		function showAddGroupBox() {
	    	$("#addGroupChat").show();
		};
		$(".close").click(function(){
	        $(".search-box-msg").hide();
	    });
    </script>
</body>

</html>
