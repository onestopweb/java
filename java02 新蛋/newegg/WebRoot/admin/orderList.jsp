<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="stylesheet" href="admin/css/list.css" type="text/css" />
<script type="text/javascript" src="admin/js/orderList.js"></script>
</head>

<body>
	<div class="show" style="height:89px; display: none; " id="show">
	</div>
	<div class="list">
		<table cellpadding="0" cellspacing="0">
			<tr class="search">
				<td colspan="7">
					<form action="orderList" method="get">
						<input type="text" class="text" name="substance" value="${substance }" /> <input
							type="submit" class="submit" value="搜索" />
					</form>
				</td>
			</tr>
			<tr class="title">
				<td>订单号</td>
				<td>订单用户编号</td>
				<td>商品</td>
				<td>总价</td>
				<td>下单时间</td>
				<td>订单状态</td>
				<td>操作</td>
			</tr>
			<c:forEach var="item" items="${ofList}" varStatus="i">
				<tr ondblclick="javascript:showSql('${item.user_id }');"
					class="content <c:if test="${i.index %2 ne 0 }">colorBg</c:if>">
					<td>${item.order_father_id }</td>
					<td>${item.user_id }</td>
					<td style="text-align: left; padding-left: 10px; width: 180px;">
						<c:forEach var="item2" items="${item.orderSonList}">
							<a href="goods?id=${item2.products_id}" target="_blank"
								title="${item2.introduce } 价格：${item2.money }  数量：${item2.number } "><img
								src="images/share/${item2.print }" width="26" height="20" />
							</a>￥${item2.money }X${item2.number }=￥${item2.money*item2.number }<br />
						</c:forEach></td>
					<td>￥${item.total}</td>
					<td>${fn:substring(item.order_time,0,10)}</td>
					<td>${item.status}</td>
					<td style="width: 168px;">
					<select onblur="javascript:updaeOrderStatus('${item.order_father_id }',this);" >
							<c:forEach var="item3" items="${ofsList}">
							<option value="${item3.order_father_status_id }" <c:if test="${item3.order_father_status_id eq item.status_id}">selected="selected"</c:if>>${item3.order_father_status_content }</option>
							</c:forEach>
					</select>
					</td>
				</tr>
			</c:forEach>
			<tr class="page">
				<td colspan="7"><em class="f_r"> <a
						href="orderList?substance=${substance }&pageIndex=1">首页</a> <a
						href="orderList?substance=${substance }&pageIndex=${pageIndex-1}">上一页</a>
						<a
						href="orderList?substance=${substance }&pageIndex=${pageIndex+1}">下一页</a>
						<a href="orderList?substance=${substance }&pageIndex=${end}">尾页</a>
				</em> <i> 共${totalCount}条数据(共有${end}页，现在是第${pageIndex}页) </i>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
