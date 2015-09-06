<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>添加书签</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/styles.css">
</head>
<body>
	<s:form name="fav" action="doAdd" method="post">
		<div class="banner">
			<img src="images/logo.gif"></img> 网站收藏
		</div>
		<table border="0" class="input_table">
			<tr>
				<td colspan="2"><s:textfield name="fav.label" size="40"
						label="名称" />
			</tr>
			<tr>
				<td colspan="2"><s:textfield name="fav.url" size="40"
						label="链接" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><font color="green">Tag可以多个，用“,”隔开</font>
				</td>
			</tr>
			<tr>
				<td colspan="2"><s:textfield label="Tag" name="fav.tags"
						size="40" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><s:textarea label="描述" name="fav.desc" rows="4"
						cols="39"></s:textarea>
				</td>
			</tr>
			<tr>
				<td><button onclick="window.close();">取消</button>
				</td>
				<td><button onclick="this.form.submit();">提交</button>
				</td>
			</tr>
		</table>
	</s:form>
</body>

