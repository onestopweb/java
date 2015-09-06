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
<title>我来回答</title>
<style type="text/css">  
*{ margin:0; padding:0; }  
body{ font-family:"宋体"; color:#333; font-size:14px; background:#fff;}  
table{ margin:0 auto; line-height:23px;}   
table tr td{ padding:0 8px;} 
table tr .tdbg{ background: #999;} 
</style>  
</head>
<body>
	<div style=" padding: 8px; width: 480px; margin: 0 auto;">
		<form action="getAll.action" method="post">
			<table border="1">
				<tr><td>问题：</td><td class="tdbg">
				<s:property value="duestion.title"></s:property></td></tr>
				<tr><td>问题描述：</td><td class="tdbg">
				<s:property value="duestion.detaildesc"></s:property></td></tr>
				<s:iterator value="answers">
				<tr><td>网友回答</td><td class="tdbg">
					<s:property value="anscontent"></s:property>
					<br><s:date name="ansdate" format="yyyy-MM-dd"></s:date>
				</td></tr>
				</s:iterator>
				<tr><td>我来回答</td><td>
					<input type="hidden" name="id" value="<s:property value='id'/>">
					<input type="text" name="answer.anscontent"></td></tr>
				<tr><td><a href="index.jsp">返回</a></td><td><input type="submit"></td></tr>
			</table>
		</form>
	</div>
</body>
</html>
