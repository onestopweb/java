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
</head>

<body>
	<div class="fillIn">
		<table cellpadding="0" cellspacing="0">
			<tr class="explain">
				<td colspan="3">创建分类</td>
			</tr>
			<form action="classNew" method="get">
				<tr class="item">
					<td class="key">新增分类</td>
					<td class="value"><input type="text" name="productsClassify" />
					</td>
					<td class="prompt"><input type="submit" class="submit2" 	value="新增分类" />
					</td>
				</tr>
			</form>
			<form action="classNew" method="get">
				<tr class="item">
					<td class="key">新增品牌</td>
					<td class="value">
					<select name="productsClassifyId">
					<c:forEach var="item" items="${pcList }" varStatus="i">
							<option value="${item.products_classify_id }" <c:if test="${item.products_classify_id  eq '1' }">selected="selected"</c:if>>${item.products_classify_content }</option>
					</c:forEach>
					</select>
					&nbsp;&nbsp;<input type="text" style=" width:100px;" name="productsBrand" />
					</td>
					<td class="prompt"><input type="submit" class="submit2"
						value="新增品牌" />
					</td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>
