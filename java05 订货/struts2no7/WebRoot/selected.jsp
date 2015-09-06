<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/basic.css" />
<link type="text/css" rel="stylesheet" href="css/selected.css" />
<title>订购商品</title>
</head>

<body>
	<div>
		<s:if test="%{goods.size()==0}">
			<h3>你没有商品</h3>
		</s:if>
		<s:else>
			<s:form action="saveOrder" method="post">
				<ul>
					<li>收货人：<input type="text" name="name" />
					</li>
					<li>收货人地址：<input type="text" name="address" />
					</li>
				</ul>
				<table cellpadding="0" cellspacing="0">
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>数量</td>
					</tr>
					<s:iterator value="goods">
						<tr>
							<td><input type="hidden" name="ids"
								value="<s:property value='id'/>" /> <s:property value="name" />
							</td>
							<td><s:property value="price" /></td>
							<td><input type="text" name="amounts" value="1" /></td>
						</tr>
					</s:iterator>
				</table>
				<s:submit value="订购"></s:submit>
			</s:form>
		</s:else>
	</div>
</body>
</html>