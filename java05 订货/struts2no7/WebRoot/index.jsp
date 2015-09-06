<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/basic.css" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
<title>商品展示</title>
</head>

<body>
	<div>
		<h3>商品展示</h3>
		<s:if test="%{goods.size()==0}"><p>没有商品</p></s:if>
		<s:else>
		<s:form action="selectedGoods" method="get">
		<s:iterator value="goods" >
		<p>
			<s:property value='name'/>&nbsp;&nbsp;&nbsp;&nbsp;选购&nbsp; <input type="checkbox" name="ids" value="<s:property value='id'/>" />
		</p>
		<ul>
			<li>厂商：<s:property value='manufacture'/></li>
			<li>价格：<s:property value='price'/></li>
			<li><s:property value='specification'/></li>
		</ul>
		</s:iterator>
		<s:submit value="下单" > </s:submit>
		</s:form>
		</s:else>
	</div>
</body>
</html>