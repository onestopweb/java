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
<title>新增标准信息</title>
<style type="text/css">  
*{ margin:0; padding:0; }  
body{ font-family:"宋体"; color:#333; font-size:14px; background:#fff;}  
h3{ text-align:center; line-height:40px;}  
table{ margin:0 auto; line-height:23px;}  
table input[type="text"]{ border:1px solid #333; height:18px; line-height:18px; padding-left:6px;}  
table select{ border:1px solid #333; }  
</style>  
</head>
<body>
	<div style=" padding: 8px; border: 1px solid #333; width: 480px; margin: 0 auto;">
		<form action="toAdd.action" method="post">
			<h3>新增标准信息</h3>
			<table>
				<tr>
					<td>*标准号:</td>
					<td><input type="text" name="standard.stdNum">
					</td>
				</tr>
				<tr>
					<td>*中文名称:</td>
					<td><input type="text" name="standard.zhname">
					</td>
				</tr>
				<tr>
					<td>*版本:</td>
					<td><input type="text" name="standard.stdVersion">
					</td>
				</tr>
				<tr>
					<td>*关键字/词:</td>
					<td><input type="text" name="standard.keys">
					</td>
				</tr>
				<tr>
					<td>*发布日期（yyyy-MM-dd）:</td>
					<td><input type="text" name="standard.releaseDate">
					</td>
				</tr>
				<tr>
					<td>*实施日期（yyyy-MM-dd）:</td>
					<td><input type="text" name="standard.implDate">
					</td>
				</tr>
				<tr>
					<td>*附件:</td>
					<td><input type="text" name="standard.packagePath">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="保存">&nbsp;<input
						type="button" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
