<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>MQ_WeTwitter</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/statics/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/statics/iCheck/square/blue.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/statics/css/main.css?v=1">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition login-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="#"><b>聊天云平台</b></a>
		</div>
		<!-- /.register-logo -->
		<div class="register-box-body">
			<p class="register-box-msg">注册窗口</p>

			<form action="#" autocomplete="off"
				method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="userName"
						placeholder="请输入账号"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password"
						placeholder="请输入密码"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="phoneNumber"
						placeholder="请输入手机号"> <span
						class="glyphicon glyphicon-earphone form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="email"
						placeholder="请输入邮箱"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>

				<div class="row">
					<div class="col-xs-4 mt20" style="margin-right: 120px;">
						<input type="button" class="btn btn-primary btn-block btn-flat"
							id="register_button" value="注册" />
					</div>
				</div>
			</form>
		</div>
		<!-- /.register-box-body -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery 2.2.3 -->
	<script
		src="${pageContext.request.contextPath}/statics/jquery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script
		src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
    <script
		src="${pageContext.request.contextPath}/statics/iCheck/icheck.min.js"></script>
	<!-- jQuery UI 对话框 -->	
	<script 
		src="${pageContext.request.contextPath }/statics/dialog/jquery-confirm.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		
		$("#register_button").click(function(){
	        var userName=$("input[name='userName']").val();
	        var password=$("input[name='password']").val();
	        var phoneNumber=$("input[name='phoneNumber']").val();
	        var email=$("input[name='email']").val();
	        if(userName=='' || userName==undefined){
	        	warmMessage("用户名不能为空");
	        	return;
	        }
	        if(password==undefined || password==''){
	        	warmMessage("密码不能为空");
	            return;
	        }
	        if(phoneNumber==undefined || phoneNumber==''){
	        	warmMessage("手机号码不能为空");
	            return;
	        }
	        if(email==undefined || email==''){
	        	warmMessage("邮箱不能为空");
	            return;
	        }
	        var passR=/^(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*])[\da-zA-Z~!@#$%^&*]{6,10}$/;
	        if(!passR.test(password)){
	        	warmMessage("密码为六到十位的数字字母符号组合");
	            return;
	        }
	        var phoneR = /^1[34578]\d{9}$/;
	        if(!phoneR.test(phoneNumber)){
	        	warmMessage("手机号码格式不正确");
	          return;
	        } 
	      
	        $.ajax({
	            type : 'post',
	            url : '${pageContext.request.contextPath}/registerService/register.do',
	            dataType : 'json',
	            data : JSON.stringify({
	                "userName":userName,
	                "password":password,
	                "phoneNumber":phoneNumber,
	                "email":email
	            }),
	            cache : false,
	            sync : true,
	            success : function(data) {
	                if (500== data.code) {
	                	alert(data.msg);
	                } else {
	                	if(200==data.code){
	                		warmMessage(data.msg);
	                        window.location.href="${pageContext.request.contextPath}/loginService/toLogin.do"
	                        /* if(data.info.personalInfo!=null){
	                        	window.location.href="${pageContext.request.contextPath }/order/orderList.action";
	                        }else{
	                        	window.location.href="${pageContext.request.contextPath }/login/toIndex.action"
	                        } */
	                        
	                    }
	                }
	            },
	            error : function() {
	            	warmMessage("请求失败!");
	            }

	        });
	    });
		
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
		             }, 400);
		         }
		   });
		}
	</script>
</body>
</html>