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
<%
	if(session.getAttribute("adminName")==null){
		response.sendRedirect("loginOfAdmin");
	}
 %>
<head>
<base href="<%=basePath%>">
<title>新蛋后台管理界面</title>
</head>
<frameset cols="153,13,*" id="framePage" name="framePage" frameborder="no" border="0"
	framespacing="0">
	<frame src="sideMenu" scrolling="no" id="leftFrame" />
	<frame src="admin/switch.jsp" frameborder="no" scrolling="no" noresize="noresize" />
	<frame src="userList" name="main" scrolling="yes" id="main" />
</frameset>
<noframes>
	<body>
		<p>您的浏览器不支持框架。</p>
	</body>
	</body>
</noframes>
</html>

