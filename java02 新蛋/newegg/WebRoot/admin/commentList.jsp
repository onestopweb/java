<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<link rel="stylesheet" href="admin/css/basic.css" type="text/css" />
<link rel="stylesheet" href="admin/css/list.css" type="text/css" />
<script type="text/javascript" src="admin/js/commentList.js"></script>
</head>

<body>
	<form action="commentList?substance=${substance }&pageIndex=${pageIndex}" method="post">
		<div class="show" style="height:118px; display: none; " id="show">
			
		</div>
	</form>
	<div class="list">
		<table cellpadding="0" cellspacing="0">
			<tr class="search">
				<td colspan="7">
					<form action="commentList" method="get">
						<input type="text" class="text" name="substance" value="${substance}" /> <input
							type="submit" class="submit" value="搜索" />
					</form></td>
			</tr>
			<tr class="title">
				<td>商品编号</td>
				<td>评论内容</td>
				<td>评论人</td>
				<td>评论时间</td>
				<td>评论状态</td>
				<td>操作</td>
			</tr>
			<c:forEach var="item" items="${cList }" varStatus="i">
			<tr ondblclick="javascript:showSql('${item.products_id }','${item.user_id }');" class="content <c:if test="${i.index %2 ne 0 }">colorBg</c:if>">
				<td>${item.products_id }</td>
				<td style="text-align: left; width: 700px;">${item.content }</td>
				<td>${item.user_id }</td>
				<td>${fn:substring(item.time,0,10)}</td>
				<td>${item.status_content }</td>
				<td style=" width: 100px;">
				
				<select onblur="javascript:ajaxUpdateStatusId('${item.products_id }','${item.user_id }',this);" >
						<c:forEach var="item2" items="${csList }" varStatus="i">
						<option value="${item2.comment_status_id }" <c:if test="${item2.comment_status_id eq item.status_id}">selected="selected"</c:if>>${item2.comment_status_content }</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			</c:forEach>
			<tr class="page">
				<td colspan="7"><em class="f_r"> <a
						href="commentList?substance=${substance }&pageIndex=1">首页</a> <a
						href="commentList?substance=${substance }&pageIndex=${pageIndex-1}">上一页</a>
						<a
						href="commentList?substance=${substance }&pageIndex=${pageIndex+1}">下一页</a>
						<a href="commentList?substance=${substance }&pageIndex=${end}">尾页</a>
				</em> <i> 共${totalCount}条数据(共有${end}页，现在是第${pageIndex}页) </i>
				
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
