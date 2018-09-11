<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
	//分页跳转到对应的页面
	function toPage(p){
		//获取整个 URL 为字符串
		var currentUrl = window.location.href;
		//分页信息
		var currentNo = "${page.pageNum }";
		if(currentUrl.indexOf("pageNo")!=-1 ){
			var newUrl = currentUrl.replace("pageNo="+currentNo, "pageNo="+p);
			window.location.href = newUrl;
		}else if(currentUrl.indexOf("?")!=-1){
			var newUrl = currentUrl+"&pageNo="+p;
			window.location.href = newUrl;
		}else{
			var newUrl = currentUrl+"?pageNo="+p;
			window.location.href = newUrl;
		}
	}
</script>

<ul class="pagination pagination-sm no-margin pull-right">
	<li><a
		href="javascript:toPage(1);">首页</a></li>
	<c:if test="${page.hasPreviousPage }">
		<li><a
			href="javascript:toPage(${page.pageNum-1});"
			aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a></li>
	</c:if>
	<c:forEach items="${page.navigatepageNums }" var="page_Num">
		<c:if test="${page_Num == page.pageNum }">
			<li class="active"><a href="#">${page_Num }</a></li>
		</c:if>
		<c:if test="${page_Num != page.pageNum }">
			<li><a
				href="javascript:toPage(${page_Num });">${page_Num }</a></li>
		</c:if>
	</c:forEach>
	<c:if test="${pageInfo.hasNextPage }">
		<li><a
			href="javascript:toPage(${page.pageNum+1 });"
			aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</c:if>
	<li><a
		href="javascript:toPage(${page.pages});">末页</a></li>
</ul>