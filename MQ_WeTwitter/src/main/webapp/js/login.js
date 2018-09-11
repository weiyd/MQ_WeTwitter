function load() {
			var date = new Date();
			$("#checkcode").attr(
					"src",
					"${pageContext.request.contextPath }/loginService/kaptcha.jpg?d="
							+ date);
		};

function onCheckCode() {
			var date = new Date();
			$("#checkcode").attr(
					"src",
					"${pageContext.request.contextPath }/loginService/kaptcha.jpg?d="
							+ date);
		};
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
	       /*  var phoneNumber=$("input[name='phoneNumber']").val();*/
	        var checkCode=$("input[name='checkCode']").val(); 
	        if(userName=='' || userName==undefined){
	        	warmMessage("用户名不能为空");
	        	return;
	        }
	        if(password==undefined || password==''){
	        	warmMessage("密码不能为空");
	            return;
	        }
	        /* if(phoneNumber==undefined || phoneNumber==''){
	        	warmMessage("手机号码不能为空");
	            return;
	        } */
	        if(checkCode==undefined || checkCode==''){
	        	warmMessage("验证码不能为空");
	            return;
	        }
	       /*  var passR=/^(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*])[\da-zA-Z~!@#$%^&*]{6,10}$/;
	        if(!passR.test(password)){
	        	warmMessage("密码为六到十位的数字字母符号组合");
	            return;
	        } */
	        /* var phoneR = /^1[34578]\d{9}$/;
	        if(!phoneR.test(phoneNumber)){
	        	warmMessage("手机号码格式不正确");
	          return;
	        }  */
	      
	        $.ajax({
	            type : 'post',
	            url : '${pageContext.request.contextPath}/loginService/login.do',
	            contentType : 'application/json',
	            data : JSON.stringify({
	                "userName":userName,
	                "password":password,
	                "checkCode":checkCode
	            }),
	            cache : false,
	            sync : true,
	            success : function(data) {
	                if (200 == data.resultCode) {
	                	warmMessage(data.resultMsg);
	                	window.location.href="${pageContext.request.contextPath}/loginService/toIndex.do";
	                } else {
	                		warmMessage(data.resultMsg);
	                        /* if(data.info.personalInfo!=null){
	                        	window.location.href="${pageContext.request.contextPath }/order/orderList.action";
	                        }else{
	                        	window.location.href="${pageContext.request.contextPath }/login/toIndex.action"
	                        } */
	                        
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