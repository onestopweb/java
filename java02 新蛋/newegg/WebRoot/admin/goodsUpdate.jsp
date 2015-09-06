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
	<div class="search">
		<table cellpadding="0" cellspacing="0">
			<tr class="searchInput">
				<td>
					<form action="goodsUpdate" method="get">
					<input type="text" class="text" name="id" value="${pItem.products_id }" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  />
						<input type="submit" class="submit" value="搜索" />
					</form>
					</td>
			</tr>
	</table>
	</div>
	<form action="goodsUpdate?id=${pItem.products_id }" method="post">
		<div class="fillIn">
			<table cellpadding="0" cellspacing="0">
				<tr class="explain">
					<td colspan="10">商品内容修改</td>
				</tr>
				<tr class="item">
					<td class="key">商品编号</td>
					<td class="value">${pItem.products_id }<input type="hidden" name="uid" value="${pItem.products_id }"/></td>
					<td class="key">商品类型</td>
					<td class="value">
					<select name="classifyId" onblur="javascript:ajaxBrandbyclassifyId(this);">
							<c:forEach var="item" items="${pc2List}" varStatus="i">  
							<option  value="${item.products_classify_id  }" <c:if test="${pItem.classifyId eq item.products_classify_id }">selected="selected"</c:if>>${item.products_classify_content }</option>
							</c:forEach>
					</select>
					</td>
					<td class="key">商品品牌</td>
					<td class="value">
					<select name="brandId" id="brand">
							<option value="${pItem.brandId }">${pItem.brand }</option>
					</select>
					</td>
					<td class="key">商品型号</td>
					<td class="value">
					<input type="text" value="${pItem.model }" name="model" style=" width:120px;" />(50字节之内)</td>
					<td class="key">上传时间</td>
					<td class="value">${pItem.time }</td>
				</tr>
				<tr class="item">
					<td class="key">商品图</td>
					<td class="value">
						<a href="goods?id=${pItem.products_id}" target="_blank"
						title="${pItem.introduce} 分类：${pItem.classify} 品牌：${pItem.brand} 型号： ${pItem.model}"><img src="images/share/${pItem.print }" width="20" height="15" />
					</a>
					</td>
					<td class="key">商品价格</td>
					<td class="value"><input type="text" value="${pItem.price }" name="price" style="width:60px;" />
					</td>
					<td class="key">商品库存</td>
					<td class="value"><input type="text" value="${pItem.number }" name="number" style="width:42px;" />
					</td>
					<td class="key">商品状态</td>
					<td class="value">
					<select name="statusId">
							<c:forEach var="item" items="${psList}" varStatus="i">  
							<option  value="${item.products_status_id  }" <c:if test="${pItem.status_id eq item.products_status_id }">selected="selected"</c:if>>${item.products_status_content }</option>
							</c:forEach>
					</select>
					</td>
					<td class="value" colspan="2"></td>
				</tr>
				<tr class="item">
					<td class="key">商品介绍</td>
					<td class="value" colspan="9"><input type="text" name="introduce"
						value="${pItem.introduce }"
						style=" width:920px;" />(120字节之内)</td>
				</tr>
				<tr class="item">
					<td class="key">商品描述</td>
					<td class="value" colspan="9"><input type="text" name="bewrite"
						value="${pItem.bewrite }" style=" width:920px;" />(120字节之内)</td>
				</tr>
				<tr class="update">
					<td colspan="10"><input type="submit" class="submit f_r"
						value="修改" />
					</td>
				</tr>
			</table>
		</div>
	</form>

	<form action="admin/smartuploadGoods.jsp" method="post"  enctype="multipart/form-data">
		<div class="upload">
			<table cellpadding="0" cellspacing="0">
				<tr class="explain">
					<td colspan="4"><input type="hidden" name="uid" value="${pItem.products_id }"/>商品图片替换</td>
				</tr>
				<tr class="item">
					<td class="key">商品小图显示(80*60)</td>
					<td class="value"><img src="images/share/${pItem.print }" width="80"
						height="60" />
					</td>
					<td class="key">商品中图显示(180*135)</td>
					<td class="value"><img src="images/share/${pItem.picture }" width="100"
						height="80" />
					</td>
				</tr>
				<tr class="item">
					<td class="key">商品小图路径(80*60)</td>
					<td class="value">/newegg/images/share/${pItem.print }</td>
					<td class="key">商品中图路径(180*135)</td>
					<td class="value">/newegg/images/share/${pItem.picture }</td>
				</tr>
				<tr class="item">
					<td class="key">商品小图上传(80*60)</td>
					<td class="value"><input type="file" name="pic"/>
					</td>
					<td class="key">商品中图上传(180*135)</td>
					<td class="value"><input type="file" name="pic2" />
					</td>
				</tr>
				<tr class="update">
					<td colspan="4"><input type="submit" class="submit"
						value="替换" />
					</td>
				</tr>
			</table>
		</div>
	</form>

	<form action="admin/smartuploadImages.jsp" method="post"  enctype="multipart/form-data">
		<div class="upload">
			<table cellpadding="0" cellspacing="0">
				<tr class="explain">
					<td colspan="5"><input type="hidden" name="uid" value="${pItem.products_id }"/>商品大小图上传或修改</td>
				</tr>
				<c:forEach var="item" items="${piList}" varStatus="i">  
				<tr class="item">
					<td class="key">小图位置${i.index+1 }显示(80*60)</td>
					<td class="value"><img src="images/share/${item.products_smallmap }"
						width="80" height="60" />
					</td>
					<td class="key">大图位置${i.index+1 }显示(640*480)</td>
					<td class="value"><img src="images/share/${item.products_large }"
						width="180" height="135" />
					</td>
					<td class="value" style="width: 80px;">
						<a  href="javascript:if(confirm('确认是否删除该组图')){location.href='goodsUpdate?id=${pItem.products_id }&delImgById=${item.products_smallmap }';}">
						<input style="color: #fff; font-family:Arial;" type="button" class="submit" value="删除"  /></a>
					</td>
				</tr>
				<tr class="item">
					<td class="key">小图位置${i.index+1 }路径(80*60)</td>
					<td class="value">/newegg/images/share/${item.products_smallmap }</td>
					<td class="key">大图位置${i.index+1 }路径(640*480)</td>
					<td class="value">/newegg/images/share/${item.products_large }</td>
					<td class="value" style="width: 80px;">&nbsp;</td>
				</tr>
				</c:forEach>
				<tr class="item">
					<td class="key">商品小图上传(80*60)</td>
					<td class="value"><input type="file" name="pic3" />
					</td>
					<td class="key">商品大图上传(640*480)</td>
					<td class="value"><input type="file" name="pic4" />
					</td>
					<td class="value" style="width: 80px;">&nbsp;</td>
				</tr>
				<tr class="update">
					<td colspan="5">
						<input type="submit" class="submit" value="确定" />
						<a  href="javascript:if(confirm('确认是否删除清空大小图')){location.href='goodsUpdate?id=${pItem.products_id }&delImg=yes';}">
						<input type="button" class="submit f_r" value="清空" style="margin-right:10px;" /></a>
					</td>
				</tr>
			</table>
		</div>
	</form>

	<form action="admin/smartuploadContent.jsp" method="post"  enctype="multipart/form-data">
		<div class="upload">
			<table cellpadding="0" cellspacing="0">
				<tr class="explain">
					<td colspan="2"><input type="hidden" name="uid" value="${pItem.products_id }"/>商品内容上传或修改</td>
				</tr>
				<c:forEach var="item" items="${pcList}" varStatus="i">  
				<tr class="item">
					<td class="value">
					<img src="images/share/${item.products_content }" />
					</td>
					<td class="value" style="width: 80px;">
						<a  href="javascript:if(confirm('确认是否删除该内容图')){location.href='goodsUpdate?id=${pItem.products_id }&delConById=${item.products_content}';}">
						<input style="color: #fff; font-family:Arial;" type="button" class="submit" value="删除"  /></a>
					</td>
				</tr>
				</c:forEach>
				<tr class="item">
					<td class="value"><input type="file" name="pic5" />
					</td>
					<td class="value" style="width: 80px;">&nbsp;</td>
				</tr>
				<tr class="update">
					<td colspan="2"><input type="submit" class="submit" value="确定" />
					<a  href="javascript:if(confirm('确认是否删除清空内容图')){location.href='goodsUpdate?id=${pItem.products_id }&delCon=yes';}">
					<input type="button" class="submit f_r" value="清空" style="margin-right:10px;" /></a>
					</td>
				</tr>
			</table>
		</div>
	</form>

	<div style="height:30px;"></div>
</body>
</html>
