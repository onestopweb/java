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
<link rel="stylesheet" href="admin/css/news.css" type="text/css" />
<script type="text/javascript" src="admin/js/userNew.js"></script>
</head>

<body>
	<form action="userNew" method="post" name="adminForm">
		<div class="fillIn">
			<table cellpadding="0" cellspacing="0">
				<tr class="explain">
					<td colspan="3">新增管理员</td>
				</tr>
				<tr class="item">
					<td class="key">管理员</td>
					<td class="value"><input type="text" id="admin" name="userId" /></td>
					<td class="prompt" id="adminId">(必填)</td>
				</tr>
				<tr class="item">
					<td class="key">密码</td>
					<td class="value"><input type="text" id="adminPass" name="password" /></td>
					<td class="prompt" id="adminPassId">(必填)</td>
				</tr>
				<tr class="item">
					<td class="key">真实姓名</td>
					<td class="value"><input type="text" id="name" name="username" /></td>
					<td class="prompt" id="nameId">(必填)</td>
				</tr>
				<tr class="item">
					<td class="key">手机号码</td>
					<td class="value"><input type="text" id="phone" name="phone" /></td>
					<td class="prompt" id="phoneId">&nbsp;</td>
				</tr>
				<tr class="update">
					<td colspan="3"><input type="submit" class="submit f_r"
						value="新增普通管理员" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
