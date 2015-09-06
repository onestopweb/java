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
<link rel="stylesheet" href="admin/css/goods.css" type="text/css" />
<script type="text/javascript" src="admin/js/goods.js"></script>
</head>

<body>
	<form action="goodsNew" method="post">
		<div class="fillIn">
			<table cellpadding="0" cellspacing="0">
				<tr class="explain">
					<td colspan="8">新增商品内容</td>
				</tr>
				<tr class="item">
					<td class="key">商品编号</td>
					<td class="value">1</td>
					<td class="key">商品类型</td>
					<td class="value">
					<select name="classifyId" onblur="javascript:ajaxBrandbyclassifyId(this);">
							<c:forEach var="item" items="${pcList}" varStatus="i">  
							<option  value="${item.products_classify_id  }" <c:if test="${pItem.classifyId eq item.products_classify_id }">selected="selected"</c:if>>${item.products_classify_content }</option>
							</c:forEach>
					</select>
					</td>
					<td class="key">商品品牌</td>
					<td class="value">
					<select name="brandId" id="brand">
						<option>--请先择类型--</option>
					</select>
					</td>
					<td class="key">商品型号</td>
					<td class="value"><input type="text" value="请输入型号" name="model"
						style=" width:120px;" />(50字节之内)</td>
				</tr>
				<tr class="item">
					<td class="key">商品价格</td>
					<td class="value"><input type="text" value="100.00" name="price"
						style="width:60px;" />
					</td>
					<td class="key">商品库存</td>
					<td class="value"><input type="text" value="1" name="number"
						style="width:42px;" />
					</td>
					<td class="key">商品状态</td>
					<td class="value">
					<select name="statusId">
							<c:forEach var="item" items="${psList}" varStatus="i">  
							<option  value="${item.products_status_id  }" <c:if test="${pItem.status_id eq '1' }">selected="selected"</c:if>>${item.products_status_content }</option>
							</c:forEach>
					</select>
					</td>
					<td class="key">上传时间</td>
					<td class="value">默认你插入数据的时间</td>
				</tr>
				<tr class="item">
					<td class="key">商品介绍</td>
					<td class="value" colspan="9"><input type="text" value="请输入介绍" name="introduce"
						style=" width:920px;" />(120字节之内)</td>
				</tr>
				<tr class="item">
					<td class="key">商品描述</td>
					<td class="value" colspan="9"><input type="text" value="请输入描述" name="bewrite"
						style=" width:920px;" />(120字节之内)</td>
				</tr>
				<tr class="update">
					<td colspan="8"><input type="submit" class="submit f_r"
						value="新增" />
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div style="height:30px;"></div>
</body>
</html>
