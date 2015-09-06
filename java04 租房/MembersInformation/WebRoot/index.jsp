<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%  
    if(request.getAttribute("membersInfos")==null || request.getAttribute("membersInfos").equals("")){  
        response.sendRedirect("index");  
    }  
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页分页显示</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<style type="text/css">
table {
	margin: 40px auto 0 auto;
}
table tr * {
	line-height: 21px;
	padding: 0 6px;
}
table th {
	background: #F90;
	text-align: center;
}
table .tdBg {
	background: #f90;
}
table td a {
	color: #039;
	text-decoration: underline;
}
table td a:hover {
	font-weight: bold;;
}
div {
	text-align: center;
	margin-top: 20px;
}
div a {
	font-family: "微软雅黑";
	font-size: 18px;
	padding-right: 60px;
	color: #333;
}
div a:hover {
	color: #039;
	text-decoration: underline;
}
</style>
</head>

<body>
	<c:if test="${flag eq true }">
		<div style="color: #c00;">更改信息成功</div>
	</c:if>
	<table border="1">
		<tr>
			<th colspan="6">俱乐部会员信息</th>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>家庭地址</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${membersInfos }" var="item" varStatus="i">
			<tr class="<c:if test="${ i.index %2 ne 0}">tdBg</c:if>">
				<td><a href="update?mid=${item.mid}">${item.mid }</a></td>
				<td>${item.mname }</td>
				<td>${item.mgender }</td>
				<td>${item.mage }</td>
				<td>${item.maddress }</td>
				<td>${item.memail }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="index?pageIndex=${pageIndex-1 }">上一页</a><a
			href="index?pageIndex=${pageIndex+1 }">下一页</a>
	</div>
</body>
</html>
