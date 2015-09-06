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
<link rel="stylesheet" href="admin/css/classUpdate.css" type="text/css" />
<script type="text/javascript" src="admin/js/classUpdate.js"></script>
</head>

<body>

	<div class="list">
		<table cellpadding="0" cellspacing="0">
			<tr class="explain">
				<td colspan="3">所有分类</td>
			</tr>
			<c:forEach var="item" items="${pcList }" varStatus="i">
				<tr class="item">
					<td class="key">分类 id${item.products_classify_id }</td>
					<td class="value"><input type="text"
						value="${item.products_classify_content }"
						onblur="javascript:ajaxClassifyUpdate('${item.products_classify_id }',this);" />
					</td>
					<td class="update"><a href="classUpdate">刷新</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<c:forEach var="item" items="${pcList }" varStatus="i">
		<div class="list">
			<table cellpadding="0" cellspacing="0">
				<tr class="explain">
					<td colspan="3">${item.products_classify_content }分类</td>
				</tr>
				<c:forEach var="item2" items="${pbList }" varStatus="i">
					<c:if
						test="${item.products_classify_id eq item2.products_classify_id }">
						<tr class="item">
							<td class="key">品牌 id${item2.products_brand_id }</td>
							<td class="value"><input type="text"
								value="${item2.products_brand_content }"
								onblur="javascript:ajaxBrandUpdate('${item2.products_brand_id  }',this);" />
							</td>
							<td class="update"><a href="classUpdate">刷新</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</c:forEach>
	<div style="height:30px;"></div>
</body>
</html>
