<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>图书信息列表</title>
<style type="text/css">
*{font-size:14px;font-family:"宋体";color:#333;line-height:24px;margin:0;}
div{width:480;margin:20px auto;}
.bookInfo{font-size:16px;font-weight:bold;background-color:#cf0;}
table tr td{padding:0px 5px;}
a{color:#f60;text-decoration:none;}
a:hover{color:#c00;text-decoration:underline;}
</style>
</head>

<body>
	<div>
		<table border="1">
			<tr>
				<td colspan="5" align="center" class="bookInfo">图书信息</td>
			</tr>
			<tr>
				<td>图书名称</td>
				<td>图书作者</td>
				<td>购买时间</td>
				<td>图书分类</td>
				<td>操作</td>
			</tr>
			<c:forEach var="item" items="${list }" varStatus="i">
				<tr
					<c:if test="${i.index%2 ne 0}" >style="background-color:#cff"</c:if>>
					<td>${item.name }</td>
					<td>${item.author }</td>
					<td>${item.time }</td>
					<td><c:if test="${item.type eq 1 }">计算机/软件</c:if> <c:if
							test="${item.type eq 2 }">小说/文摘</c:if> <c:if
							test="${item.type eq 3 }">杂项</c:if>
					</td>
					<td><a href="search?id=${item.id}">修改</a>&nbsp;<a
						href="javascript:if(confirm('是否确认删除')){location.href='delete?id=${item.id }';}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a href="add.jsp">新增</a>
		</p>
	</div>
</body>
</html>
