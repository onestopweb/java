<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询列表</title>
<link rel="stylesheet" href="css/basic.css" type="text/css" />
<link rel="stylesheet" href="css/selectList.css" type="text/css" />
</head>
<body>
	<form action="showList" method="post">
		<table>
			<tr>
				<td>电影名称</td>
				<td><input type="input" name="titile" />
				</td>
			</tr>
			<tr>
				<td>电影类型</td>
				<td><select name="typeid" id="typeid">
						<option value="0" selected="selected">请选择</option>
						<c:forEach var="item" items="${types}" varStatus="i">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>主演</td>
				<td><input type="input" name="actor" />
				</td>
			</tr>
			<tr>
				<td>导演</td>
				<td><input type="input" name="director" />
				</td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="input" name="minPrice" class="price" /> 至 <input
					type="input" name="maxPrice" class="price" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
