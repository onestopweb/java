<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<title>我要提问</title>
<style type="text/css">  
body{ font-family:"宋体"; color:#333; font-size:14px; background:#fff;}  
a{ color:#069; text-decoration:underline;}  
a:hover{ color:#f60; text-decoration:underline;}  
h3{ text-align:center; line-height:40px;}
p{ text-align: center;}  
</style>  
</head>
<body>
	<div style=" width: 300px; margin: 0 auto;">
		<form action="doAdd.action" method="post">
			<h3>我要提问</h3>
			<p><a href="index.jsp">返回首页</a></p>
			<table>
				<tr><td>问题：</td><td><input type="text" name="duestion.title"></td></tr>
				<tr><td>问题描述：</td><td><input type="text" name="duestion.detaildesc"></td></tr>
				<tr><td></td><td><input type="submit" value="保存问题">
				&nbsp;&nbsp;<a href="index.jsp">返回</a></td></tr>
			</table>
		</form>
	</div>
</body>
</html>
