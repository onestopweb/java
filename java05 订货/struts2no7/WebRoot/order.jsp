<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/basic.css" />
<link type="text/css" rel="stylesheet" href="css/order.css" />
<title>订购商品</title>
</head>
<body>
	<s:debug></s:debug>
	<div>
		<ul>
			<li>订单号：<s:property value="order.id"/></li>
			<li>收货人：<s:property value="order.name"/></li>
			<li>收货人地址：<s:property value="order.address"/></li>
		</ul>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>数量</td>
			</tr>
			
			<s:iterator value="orderDetails" >
			<tr>
				<td><s:property value='goods.name'/></td>
				<td><s:property value='goods.price'/></td>
				<td><s:property value='amount'/></td>
			</tr>
			</s:iterator>
			<tr>
				<td colspan="3">总价：<s:property value="total"/></td>
			</tr>
		</table>
	</div>
</body>
</html>