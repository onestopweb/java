<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>新蛋后面界面登陆</title>
<link rel="stylesheet" type="text/css" href="admin/css/basic.css" />
<link href="admin/css/loginOfAdmin.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="admin/js/loginOfAdmin.js"></script>
</head>

<body>
	<div class="interface">
		<div class="title">
			<img src="admin/images/loginOfAdmin/title.jpg" width="330" height="48" />
		</div>

		<form action="loginOfAdmin" method="post" name="adminForm">
			<div class="login">
				<input type="text" class="admin" name="inputAdmin" id="inputAdmin" /> <input
					type="password" class="adminPass" name="inputPass" id="inputPass" /> <input
					type="submit" class="submit" value="登陆" />
			</div>
		</form>
	</div>
</body>
</html>
<<c:if test="${flag==false }">
	<script type="text/javascript">failureOfTips();</script>
</c:if>
