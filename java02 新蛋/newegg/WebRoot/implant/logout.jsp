<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
<title>登录注销</title>
</head>
<body>
	<% 
	 session.invalidate();//注销   
  	response.sendRedirect("../login");  
 %>
	<h3>你已成功退出本系统，跳转回首页了！</h3>
	<h3>
		如果没有跳转，请按<a href="login">这里</a>
	</h3>
</body>
</html>
