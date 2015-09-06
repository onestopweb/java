<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="admin/js/userList.js"></script>
</head>

<body>
	<form action="userList?userId=${userId}&levelId=${levelId}&pageIndex=${pageIndex}" method="post">
		<div class="show" style=" height:140px; display: none; " id="show">
		</div>
	</form>

	<div class="list">
		<table cellpadding="0" cellspacing="0">
			<tr class="search">
				<td colspan="8">
					<form action="userList?userId=${userId}" method="post">
						<select name="levelId">
							<option value="0">--全部--</option>
							<c:forEach var="item" items="${ulList }" varStatus="i">  
							<option value="${item.user_leve_id}" <c:if test="${item.user_leve_id eq levelId}">selected="selected"</c:if>>${item.user_leve_content}</option>
							</c:forEach>
						</select> <input type="submit" class="submit" value="确定" />
					</form>
					<form action="userList?levelId=${levelId}" method="post">
						<input type="text" class="text" name="userId" value="${userId}" /> <input type="submit"
							class="submit" value="搜索" />
					</form></td>
			</tr>
			<tr class="title">
				<td>用户编号</td>
				<td>密码</td>
				<td>用户姓名</td>
				<td>电话</td>
				<td>手机</td>
				<td>电子邮箱</td>
				<td>用户级别</td>
				<td>操作</td>
			</tr>
			<c:forEach var="item" items="${uList }" varStatus="i">  
			<tr ondblclick="javascript:showSql('${item.user_id }');" class="content <c:if test="${i.index %2 ne 0 }">colorBg</c:if>">
				<td>${item.user_id }</td>
				<td>${item.password }</td>
				<td><c:if test="${item.username eq null }">null</c:if><c:if test="${item.username ne null }">${item.username }</c:if></td>
				<td><c:if test="${item.tel eq null }">null</c:if><c:if test="${item.tel ne null }">${item.tel }</c:if></td>
				<td><c:if test="${item.phone eq null }">null</c:if><c:if test="${item.phone ne null }">${item.phone }</c:if></td>
				<td><c:if test="${item.email eq null }">null</c:if><c:if test="${item.email ne null }">${item.email }</c:if></td>
				<td>${item.leve_content }</td>
				<td><a href="javascript:if(confirm('是否注销该账号')){location.href='userList?logout=${item.user_id }';}"><img src="admin/images/logout.png" width="22"
						height="22" />
				</a>
				</td>
			</tr>
			</c:forEach>
			<tr class="page">
				<td colspan="8"><em class="f_r"> <a href="userList?userId=${userId}&levelId=${levelId}&pageIndex=1">首页</a> <a
						href="userList?userId=${userId}&levelId=${levelId}&pageIndex=${pageIndex-1}">上一页</a> <a href="userList?userId=${userId}&levelId=${levelId}&pageIndex=${pageIndex+1}">下一页</a> <a href="userList?userId=${userId}&levelId=${levelId}&pageIndex=${end}">尾页</a> </em> <i>
						共${totalCount}条数据(共有${end}页，现在是第${pageIndex}页) </i></td>
			</tr>
		</table>
	</div>
</body>
</html>
