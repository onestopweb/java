<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
<title>管理员登录注销</title>
</head>
<body>
<% 
	 session.invalidate();//注销  
 %>
<script type="text/javascript">
//刷新整个框架用的
parent.location="loginOfAdmin";
</script>
</body>
</html>
