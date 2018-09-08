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
<!-- iCheck 
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/statics/admin/plugins/iCheck/square/blue.css">
-->

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
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>聊天云平台</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">登录窗口</p>

			<form action="#" autocomplete="off"
				method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="userName"
						placeholder="请输入账号"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password"
						placeholder="请输入密码"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="phoneNumber"
						placeholder="请输入手机号"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="checkCode"
						placeholder="请输入验证码" style="width: 200px; float: left;"> <a
						href="javascript:void(0)" class="validate-img"> <img
						src="${pageContext.request.contextPath }/loginService/kaptcha.jpg"
						width="102" height="38" style="float: left;" id="checkcode"
						onclick="onCheckCode();" title="看不清换一张" />
					</a>
				</div>

				<div class="row">
					<div class="col-xs-4 mt20" style="margin-left: 120px;">
						<input type="button" class="btn btn-primary btn-block btn-flat"
							id="login_button">登 录</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<script
		src="${pageContext.request.contextPath}/statics/jquery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script
		src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<%-- <script
		src="${pageContext.request.contextPath}/statics/admin/plugins/iCheck/icheck.min.js"></script> --%>
	<script>
		function onCheckCode() {
			var date = new Date();
			$("#checkcode").attr(
					"src",
					"${pageContext.request.contextPath }/loginService/kaptcha.jpg?d="
							+ date);
		}
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		
		$("#login_button").click(function(){
	        var userName=$("input[name='userName']").val();
	        var password=$("input[name='password']").val();
	        var phoneNumber=$("input[name='phoneNumber']").val();
	        var checkCode=$("input[name='checkCode']").val();
	        if(userName=='' || userName==undefined){
	        	alert("用户名不能为空");
	        	return;
	        }
	        if(password==undefined || password==''){
	            alert("密码不能为空");
	            return;
	        }
	        if(phoneNumber==undefined || phoneNumber==''){
	            alert("手机号码不能为空");
	            return;
	        }
	        if(checkCode==undefined || checkCode==''){
	            alert("验证码不能为空");
	            return;
	        }
	        var passR=/^(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*])[\da-zA-Z~!@#$%^&*]{6,10}$/;
	        if(!passR.test(password)){
	            alert("密码为六到十位的数字字母符号组合");
	            return;
	        }
	        var phoneR = /^1[34578]\d{9}$/;
	        if(!phoneR.test(phoneNumber)){
	      	  alert("手机号码格式不正确");
	          return;
	        } 
	      
	        $.ajax({
	            type : 'post',
	            url : '${pageContext.request.contextPath}/loginService/login.do',
	            data : {
	                "userName":userName,
	                "password":password,
	                "phoneNumber":phoneNumber,
	                "checkCode":checkCode
	            },
	            cache : false,
	            sync : true,
	            success : function(data) {
	                if (500== data.code) {
	                	alert(data.msg);
	                } else {
	                	if(200==data.code){
	                		alert(data.msg);
	                        window.location.href="${pageContext.request.contextPath}/loginService/toIndex.do"
	                        /* if(data.info.personalInfo!=null){
	                        	window.location.href="${pageContext.request.contextPath }/order/orderList.action";
	                        }else{
	                        	window.location.href="${pageContext.request.contextPath }/login/toIndex.action"
	                        } */
	                        
	                    }
	                }
	            },
	            error : function() {
	            	alert("请求失败!");
	            }

	        });
	    });
	</script>
</body>
</html>