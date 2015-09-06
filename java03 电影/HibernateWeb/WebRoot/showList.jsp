<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>列表显示</title>
<link rel="stylesheet" href="css/basic.css" type="text/css" />
<link rel="stylesheet" href="css/showList.css" type="text/css" />
</head>

<body>
	<c:if test="${not empty  movies}">
		<table border="2">
			<tr>
				<th>电影名称</th>
				<th>类型</th>
				<th>主演</th>
				<th>导演</th>
				<th>票价</th>
			</tr>
			<c:forEach items="${movies }" var="item" varStatus="i">
				<tr>
					<td>${item.titile }</td>
					<td>${item.type.name }</td>
					<td>${item.actor }</td>
					<td>${item.director }</td>
					<td>${item.price }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h2>
		<c:if test="${empty  movies}">没有查询到数据</c:if>
	</h2>
</body>
</html>

