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
<title>在线回答</title>
<style type="text/css">
*{ margin:0; padding:0; }  
body{ font-family:"宋体"; color:#333; font-size:14px; background:#fff;}  
a{ color:#069; text-decoration:underline;}  
a:hover{ color:#f60; text-decoration:underline;}  
h3{ text-align:center; line-height:40px;}
p{ text-align: center; height: 23px;}  
table{ margin:0 auto; line-height:23px;}  
table tr th{ background:#B8860B;}  
table tr td{ padding:0 8px;}  
table .tdBg td{ background:#999}  
</style>
</head>
<body>
	<div style=" padding: 8px; width: 480px; margin: 0 auto;">
		<h3>在线回答</h3>
		<p>
			<a href="question.jsp">我要提问</a>
		</p>
		<table border="1">
			<tr>
				<th>序号</th>
				<th>问题</th>
				<th>回答次数</th>
				<th>最后修改</th>
			</tr>
			<s:iterator value="duestions" status="st">
			<tr <s:if test="#st.even">class="tdBg"</s:if>>
				<td><s:property value="id"></s:property></td>
				<td><a href="findDetatil.action?id=<s:property value='id'/>">
				<s:property value="title"></s:property></a></td>
				<td><s:property value="ansewercount"></s:property></td>
				<td>&nbsp;<s:date name="lastmodidfied" format="yyyy-MM-dd"></s:date></td>
			</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
