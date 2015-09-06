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
<script type="text/javascript" src="admin/js/goodsList.js"></script>
</head>

<body>
	<form action="goodsList?substance=${substance }&statusNum=${statusNum }&pageIndex=${pageIndex}" method="post">
		<div class="show" style=" height:162px; display: none; " id="show">

		</div>
	</form>

	<div class="list">
		<table cellpadding="0" cellspacing="0">
			<tr class="search">
				<td colspan="10">
					<form action="goodsList?substance=" method="get">
						<input type="hidden" name="substance" value="${substance}" /> <select
							name="statusNum">
							<option value="1">---默认---</option>
							<option value="1"
								<c:if test="${statusNum eq '1' }">selected="selected"</c:if>>按时间排序</option>
							<option value="2"
								<c:if test="${statusNum eq '2' }">selected="selected"</c:if>>按库存排序</option>
							<option value="3"
								<c:if test="${statusNum eq '3' }">selected="selected"</c:if>>按价格排序</option>
						</select> <input type="submit" class="submit" value="确定" />
					</form>
					<form action="goodsList" method="get">
						<input type="hidden" name="statusNum" value="${statusNum}" /> <input
							type="text" class="text" name="substance" value="${substance}" />
						<input type="submit" class="submit" value="搜索" />
					</form></td>
			</tr>
			<tr class="title">
				<td>商品编号</td>
				<td>商品类型</td>
				<td>商品品牌</td>
				<td>商品图</td>
				<td>商品价格</td>
				<td>商品库存</td>
				<td>上架时间</td>
				<td>商品状态</td>
				<td>上架/下架</td>
				<td>操作</td>
			</tr>
			<c:forEach var="item" items="${pList }" varStatus="i">
				<tr ondblclick="javascript:showSql('${item.products_id }');" class="content <c:if test="${i.index %2 ne 0 }">colorBg</c:if>">
					<td>${item.products_id }</td>
					<td>${item.classify }</td>
					<td>${item.brand }</td>
					<td><a href="goods?id=${item.products_id}" target="_blank"
						title="${item.introduce} 分类：${item.classify} 品牌：${item.brand} 型号： ${item.model}"><img
							src="images/share/${item.print}" width="26" height="20" /> </a></td>
					<td><input type="text" value="${item.price }"
						onblur="javascript:ajaxUpdatePrice('${item.products_id }',this);"
						style="width:60px;" />
					</td>
					<td><input type="text" value="${item.number }"
						onblur="javascript:ajaxUpdateNumber('${item.products_id }',this);"
						style="width:42px;" />
					</td>
					<td>${fn:substring(item.time,0,10)}</td>
					<td>${item.status_content }</td>
					<td><c:if test="${item.grounding eq '0' }">
							<img src="admin/images/grounding.png" width="22" height="22" />
						</c:if> <c:if test="${item.grounding eq '1' }">
							<img src="admin/images/undercarriage.png" width="22" height="22" />
						</c:if></td>
					<td><a href="goodsUpdate?id=${item.products_id }"><img
							src="admin/images/tool.png" width="22" height="22" /> </a>&nbsp;<a
						href="goodsList?substance=${substance }&statusNum=${statusNum }&pageIndex=${pageIndex}&id=${item.products_id }&grounding=0"><img
							src="admin/images/grounding.png" width="22" height="22" /> </a>&nbsp;<a
						href="goodsList?substance=${substance }&statusNum=${statusNum }&pageIndex=${pageIndex}&id=${item.products_id }&grounding=1"><img
							src="admin/images/undercarriage.png" width="22" height="22" /> </a>
					</td>
				</tr>
			</c:forEach>
			<tr class="page">
				<td colspan="10"><em class="f_r"> <a
						href="goodsList?substance=${substance }&statusNum=${statusNum }&pageIndex=1">首页</a>
						<a
						href="goodsList?substance=${substance }&statusNum=${statusNum }&pageIndex=${pageIndex-1}">上一页</a>
						<a
						href="goodsList?substance=${substance }&statusNum=${statusNum }&pageIndex=${pageIndex+1}">下一页</a>
						<a
						href="goodsList?substance=${substance }&statusNum=${statusNum }&pageIndex=${end}">尾页</a>
				</em><i>共${totalCount}条数据(共有${end}页，现在是第${pageIndex}页) </i>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
