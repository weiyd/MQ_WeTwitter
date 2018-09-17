<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <link href="../statics/css/newsList.css" rel="stylesheet">
    <link href="../statics/css/index.css" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox chat-view">
                    <div class="ibox-title">
	                                             叽叽喳喳——消息管理器
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="news-type">
                                	<div class="news-first-type">
                                		<a href="#"><i class="glyphicon glyphicon-volume-up glyphicon-lg"></i>验证消息</a>
                                	</div>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="news-list">
                                	<c:forEach items="${newsList}" var="nlist" varStatus="newsCount">
                                   		<div class="news-content">
                                   			<p>${newsCount.count}.<a href="#" onclick="showFriendApply('${nlist.id}','${nlist.sender_name}','${nlist.sender_note }','${nlist.sender_id }')">【${nlist.sender_name}】请求添加您为好友。</a></p>
                                       	</div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 隐藏添加好友提示div -->
    <div class="addFriendremind-box-msg" style="display:none">
    	<div class="title">
    		好友申请详情
    		<button type="button" class="close"><span>x</span></button>
    	</div>
    	<div class="content">
	    	<p>【<span id="senderName"></span>】请求添加您为好友<span id="newsId" style="display:none"></span><span id="senderId" style="display:none"></span>为好友,附加信息：</p>
	    	<textarea id="senderNote" readonly="readonly"></textarea>
	    	<button type="button" class="btn btn-default btn-xs" onclick="friendApplyResult('yes')">同意 </button>
	    	<button type="button" class="btn btn-default btn-xs" href="friendApplyResult('no')">拒绝 </button>
    	</div>
    </div>
    <script src="../statics/jquery/jquery-2.2.3.min.js"></script>
    <script src="../statics/bootstrap/js/bootstrap.min.js"></script>
    <script src="../statics/bootstrap/js/bootstrap.js"></script>
    <script src="../statics/js/news.js"></script>
    <script src="../statics/dialog/jquery-confirm.min.js"></script>
    <script>
	    $(".addFriendremind-box-msg .close").click(function(){
	        $(".addFriendremind-box-msg").hide();
	    });
	    $(".gohome").click(function(){
	    	window.location.href="${pageContext.request.contextPath}/loginService/toIndex.do";
	    });
	    function friendApplyResult(data){
	    	var senderName=$("#senderName").text();
	    	var newsId=$("#newsId").text();
			var senderId=$("#senderId").text();
			var senderNote=$("#senderNote").val();
	    	$.ajax({
	            type : 'post',
	            url : '${pageContext.request.contextPath}/userManageService/replyFriendApplication.do',
	            contentType : 'application/json',
	            data : JSON.stringify({
	                "sender_name":senderName,
	                "id":newsId,
	                "sender_id":senderId,
	                "sender_note":senderNote,
	                "status":data
	            }),
	            cache : false,
	            sync : true,
	            success : function(data) {
	                warmMessage(data.resultMsg);
	                $(".addFriendremind-box-msg").hide();
	                location.reload();
	            },
	            error : function() {
	            	warmMessage("请求失败!");
	            	$(".addFriendremind-box-msg").hide();
	            }

	        });
	    };
    	function showFriendApply(id,senderName,senderNote,senderId){
    		$(".addFriendremind-box-msg").show();
    		$("#senderName").html(senderName);
			$("#newsId").html(id);
			$("#senderId").html(senderId);
			$("#senderNote").val(senderNote);
    	};
		function warmMessage(msg){
			var d=$.dialog({
		         content: '<div style="text-align:center;" class="text-center">'+msg+'</div>',
		         top: '10%',
		         left: '50%',
		         title: false, // hides the title.
		         closeIcon: false, // hides the close icon.
		         columnClass: 'xsmall',
		         onOpen: function(){
		             setTimeout(function(){
		                 d.close();
		             }, 800);
		         }
		   });
		}
    </script>
</body>

</html>
