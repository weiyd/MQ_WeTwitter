<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="${pageContext.request.contextPath }/statics/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
<aside class="main-sidebar">
	<section class="sidebar">
		<ul class="sidebar-menu">
			<li class="header">主导航</li>
			<li class="treeview <c:if test="${menu eq 'menu1' }">active</c:if>"><a href="#"> <i class="fa fa-folder"></i>
					<span>权限管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu1' }">menu-open</c:if>" <c:if test="${menu eq 'menu1' }">style="display:block"</c:if>>
					<c:if test="${accountCustom.roleId eq 1}">
						<li><a id="menu23"
						href="${pageContext.request.contextPath }/admin/account/accountList.action"><i
							class="fa fa-circle-o"></i>管理员列表</a></li>
					</c:if>
					<c:if test="${accountCustom.roleId eq 1}">
						<li><a id="menu21"
						href="${pageContext.request.contextPath }/admin/role/roleList.action"><i
							class="fa fa-circle-o"></i>角色列表</a></li>
					</c:if>
					<c:if test="${accountCustom.roleId eq 1}">
						<li><a id="menu22"
						href="${pageContext.request.contextPath }/admin/authority/authorityList.action"><i
							class="fa fa-circle-o"></i>权限列表</a></li>
					</c:if>
					<li><a id="menu24"
						href="${pageContext.request.contextPath }/admin/department/departments.action"><i
							class="fa fa-circle-o"></i>部门列表</a></li>
					<li><a id="menu25"
						href="${pageContext.request.contextPath }/admin/position/positionSelect.action"><i
							class="fa fa-circle-o"></i>职位列表</a></li>
				</ul></li>

			<li class="treeview <c:if test="${menu eq 'menu2' }">active</c:if>"><a href="#"><i
					class="fa fa-folder"></i> <span>系统管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu2' }">menu-open</c:if>" <c:if test="${menu eq 'menu2' }">style="display:block"</c:if>>
					<li><a id="menu31"
						href="${pageContext.request.contextPath}/admin/system/systembsList.action"><i
							class="fa fa-circle-o"></i>系统信息</a></li>
					<li><a id="menu32"
						href="${pageContext.request.contextPath }/admin/systemLog/systemLogSelect.action"><i
							class="fa fa-circle-o"></i>日志列表</a></li>
				</ul></li>
			<li class="treeview" id="menu3" <c:if test="${menu eq 'menu3' }">active</c:if>><a href="#"> <i
					class="fa fa-folder"></i> <span>标签管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu3' }">menu-open</c:if>" <c:if test="${menu eq 'menu3' }">style="display:block"</c:if>>
					<li><a id="menu41"
						href="${pageContext.request.contextPath}/admin/label/labelSelect.action"><i
							class="fa fa-circle-o"></i>标签列表</a></li>
					<li><a id="menu42"
						href="${pageContext.request.contextPath}/admin/scan/scanSelect.action"><i
							class="fa fa-circle-o"></i>扫描列表</a></li>
				</ul></li>

			<li class="treeview <c:if test="${menu eq 'menu4' }">active</c:if>" id="menu4"><a href="#"> <i
					class="fa fa-folder"></i> <span>基本信息</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu4' }">menu-open</c:if>" <c:if test="${menu eq 'menu4' }">style="display:block"</c:if>>
					<li><a id="menu51"
						href="${pageContext.request.contextPath }/admin/dumpcart/dumpcartSelect.action"><i
							class="fa fa-circle-o"></i>车辆列表</a></li>
					<li><a id="menu52"
						href="${pageContext.request.contextPath }/admin/user/userSelect.action"><i
							class="fa fa-circle-o"></i>住户信息</a></li>
					<li><a id="menu53"
						href="${pageContext.request.contextPath }/upload1/skip.action"><i
							class="fa fa-circle-o"></i>头像信息</a></li>
					<li><a id="menu54"
						href="${pageContext.request.contextPath }/userAccount/updataPassword.action"><i
							class="fa fa-circle-o"></i>密码修改</a></li>
					<li><a id="menu55"
						href="${pageContext.request.contextPath }/phoneBind/phoneBindSkip1.action"><i
							class="fa fa-circle-o"></i>手机绑定</a></li>
					<li><a id="menu56"
						href="${pageContext.request.contextPath }/testMail/mailBindSkip.action"><i
							class="fa fa-circle-o"></i>邮箱绑定</a></li>
					<li><a id="menu57"
						href="${pageContext.request.contextPath }/admin/member/memberSelect.action"><i
							class="fa fa-circle-o"></i>会员信息</a></li>
				</ul></li>
			<li class="treeview <c:if test="${menu eq 'menu5' }">active</c:if>" id="menu5"><a href="#"> <i
					class="fa fa-folder"></i> <span>积分管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu5' }">menu-open</c:if>" <c:if test="${menu eq 'menu5' }">style="display:block"</c:if>>
					<li><a id="menu61"
						href="${pageContext.request.contextPath }/admin/points/pointsSelect2.action"><i
							class="fa fa-circle-o"></i>积分兑换</a></li>
					<li><a id="menu62"
						href="${pageContext.request.contextPath }/admin/points/pointsSelect3.action"><i
							class="fa fa-circle-o"></i>积分奖励</a></li>
					<li><a id="menu63"
						href="${pageContext.request.contextPath }/admin/points/pointsSelect.action"><i
							class="fa fa-circle-o"></i>积分查询</a></li>
				</ul></li>

			<li class="treeview <c:if test="${menu eq 'menu6' }">active</c:if>" id="menu6"><a href="#"> <i
					class="fa fa-folder"></i> <span>文章管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu6' }">menu-open</c:if>" <c:if test="${menu eq 'menu6' }">style="display:block"</c:if>>
					<li><a id="menu71"
						href="${pageContext.request.contextPath }/admin/article/articleList.action"><i
							class="fa fa-circle-o"></i>文章列表</a></li>
					<li><a id="menu72"
						href="${pageContext.request.contextPath }/admin/articleCategory/articleCateList.action"><i
							class="fa fa-circle-o"></i>文章分类</a></li>
					<li><a id="menu73"
						href="${pageContext.request.contextPath }/admin/attachment/attachmentList.action"><i
							class="fa fa-circle-o"></i>资源列表</a></li>
					<li><a id="menu74"
						href="${pageContext.request.contextPath }/admin/attachmentFile/attachmentFileList.action"><i
							class="fa fa-circle-o"></i>附件详情</a></li>
				</ul></li>
			
				<li class="treeview <c:if test="${menu eq 'menu7' }">active</c:if>" id="menu7"><a href="#"> <i
					class="fa fa-folder"></i> <span>评论管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu7' }">menu-open</c:if>" <c:if test="${menu eq 'menu7' }">style="display:block"</c:if>>
					<li><a id="menu81"
						href="${pageContext.request.contextPath }/admin/comment/commentList.action"><i
							class="fa fa-circle-o"></i>评论列表</a></li>
					<li><a id="menu82"
						href="${pageContext.request.contextPath }/admin/commentReply/commentReplyList.action"><i
							class="fa fa-circle-o"></i>回复列表</a></li>
					<li><a id="menu83"
						href="${pageContext.request.contextPath }/admin/comment/statistics.action"><i
							class="fa fa-circle-o"></i>积分统计</a></li>
				</ul></li>
				<li class="treeview <c:if test="${menu eq 'menu8' }">active</c:if>" id="menu8"><a href="#"> <i
					class="fa fa-folder"></i> <span>商品管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu8' }">menu-open</c:if>" <c:if test="${menu eq 'menu8' }">style="display:block"</c:if>>
					<li><a id="menu91"
						href="${pageContext.request.contextPath }/admin/goods/goodsList.action"><i
							class="fa fa-circle-o"></i>商品列表</a></li>
					<li><a id="menu92"
						href="${pageContext.request.contextPath }/admin/goodsCate/goodsCateList.action"><i
							class="fa fa-circle-o"></i>目录列表</a></li>
							<li><a id="menu93"
						href="${pageContext.request.contextPath }/admin/brand/brandList.action"><i
							class="fa fa-circle-o"></i>品牌列表</a></li>
				</ul></li>
				
					<li class="treeview <c:if test="${menu eq 'menu9' }">active</c:if>" id="menu9"><a href="#"> <i
					class="fa fa-folder"></i> <span>订单日志管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu9' }">menu-open</c:if>" <c:if test="${menu eq 'menu9' }">style="display:block"</c:if>>
					<li><a id="menu101"
						href="${pageContext.request.contextPath }/admin/order/orderLogList.action"><i
							class="fa fa-circle-o"></i>订单日志列表</a></li>
				</ul></li>
				<li class="treeview <c:if test="${menu eq 'menu10' }">active</c:if>" id="menu10"><a href="#"> <i
					class="fa fa-folder"></i> <span>反馈管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu <c:if test="${menu eq 'menu10' }">menu-open</c:if>" <c:if test="${menu eq 'menu10' }">style="display:block"</c:if>>
					<li><a id="menu111"
						href="${pageContext.request.contextPath }/admin/feedback/feedbackList.action"><i
							class="fa fa-circle-o"></i>反馈列表</a></li>
				</ul></li>
				
		</ul>
	</section>
</aside>
<script>
	$().ready(function() {
		//菜单加载展开高亮显示选中项
		$('.treeview ul li a').each(function() {
			if ($($(this))[0].href == String(window.location)) {
				$(this).parent().parent().parent().addClass('active');
				$(this).parent().parent().addClass("menu-open")
				$(this).css("color", "#fff");
			}
		});
		selectedLeftMenu();
	})
	//左侧菜单选中状态
	function selectedLeftMenu() {
		var currentUrl = window.location.href;
		if (currentUrl.indexOf("account") != -1) {
			$('#menu23').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("role") != -1) {
			$('#menu21').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("authority") != -1) {
			$('#menu22').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("department") != -1) {
			$('#menu24').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("position") != -1) {
			$('#menu25').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("systemInfoSave") != -1) {
			$('#menu31').css("color", "#fff");//选择项高亮显示
		}else if (currentUrl.indexOf("systembsList") != -1) {
			$('#menu31').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("systemLog") != -1) {
			$('#menu32').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("label") != -1) {
			$('#menu41').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("scan") != -1) {
			$('#menu42').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("dumpcart") != -1) {
			$('#menu51').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("user") != -1) {
			$('#menu52').css("color", "#fff");//选择项高亮显示
		} else if (currentUrl.indexOf("user/") != -1) {
			$('#menu53').css("color", "#fff");
		} else if (currentUrl.indexOf("article/") != -1) {
			$('#menu71').css("color", "#fff");
		} else if (currentUrl.indexOf("articleCategory") != -1) {
			$('#menu72').css("color", "#fff");
		} else if (currentUrl.indexOf("attachment/") != -1) {
			$('#menu73').css("color", "#fff");
		} else if (currentUrl.indexOf("attachmentFile") != -1) {
			$('#menu74').css("color", "#fff");
		} else if (currentUrl.indexOf("comment/") != -1) {
			$('#menu81').css("color", "#fff");
		} else if (currentUrl.indexOf("commentReply/") != -1) {
			$('#menu82').css("color", "#fff");
		} else if (currentUrl.indexOf("/getInfo.") != -1) {
			$('#menu61').css("color", "#fff");
		} else if (currentUrl.indexOf("/pointsSelect2") != -1) {
			$('#menu61').css("color", "#fff");
		} else if (currentUrl.indexOf("/pointsSelect3") != -1) {
			$('#menu62').css("color", "#fff");
		} else if (currentUrl.indexOf("getInfo2") != -1) {
			$('#menu62').css("color", "#fff");
		} else if (currentUrl.indexOf("findpointsById") != -1) {
			$('#menu63').css("color", "#fff");
		} else if (currentUrl.indexOf("/pointsSelect.") != -1) {
			$('#menu63').css("color", "#fff");
		} else if (currentUrl.indexOf("goods/") != -1) {
			$('#menu91').css("color", "#fff");
		} else if (currentUrl.indexOf("goodsCate") != -1) {
			$('#menu92').css("color", "#fff");
		} else if (currentUrl.indexOf("/brand/") != -1) {
			$('#menu93').css("color", "#fff");
		} else if (currentUrl.indexOf("orderLogList") != -1) {
			$('#menu101').css("color", "#fff");
		}
	}
</script>

