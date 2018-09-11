<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="tab-header" >
    <a id="header1" href="${pageContext.request.contextPath }/admin/dumpcart/dumpcartSelect.action">首页</a>
    <a id="header2" href="${pageContext.request.contextPath }/admin/department/departments.action">部门列表</a>
    <a id="header3" href="${pageContext.request.contextPath }/admin/position/positionSelect.action">职位列表</a>
    <a id="header4" href="${pageContext.request.contextPath }/admin/user/userSelect.action">住户信息</a>
    <a id="header5" href="${pageContext.request.contextPath }/admin/points/pointsSelect.action">积分查询</a>
    <a id="header6" href="${pageContext.request.contextPath }/admin/systemLog/systemLogSelect.action">系统日志</a>
</div>
<!-- Content Header (Page header) -->
<script>
	$().ready(function(){
		//菜单加载展开高亮显示选中项
		 $('.tab-header a').each(function() {
			if ($($(this))[0].href == String(window.location)) {
				$(this).addClass('active');
			}
		});
		seletedMenu();
	})
	function seletedMenu(){
		var currentUrl = window.location.href;
		if(currentUrl.indexOf("dumpcart")!=-1){
			$('#header1').addClass('active');
		}else if(currentUrl.indexOf("department")!=-1){
			$('#header2').addClass('active');
		}else if(currentUrl.indexOf("position")!=-1){
			$('#header3').addClass('active');
		}else if(currentUrl.indexOf("user/")!=-1){
			$('#header4').addClass('active');
		}else if(currentUrl.indexOf("points")!=-1){
			$('#header5').addClass('active');
		}else if(currentUrl.indexOf("systemLog")!=-1){
			$('#header6').addClass('active');
		}
	}
</script>