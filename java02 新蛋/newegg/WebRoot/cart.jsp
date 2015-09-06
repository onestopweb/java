<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	if(request.getAttribute("poList")==null || session.getAttribute("username")==null){
		response.sendRedirect("index");
	}
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/cart.css" />
<script type="text/javascript" src="js/cart.js"></script>
</head>

<body>

<div class="header">
	<div class="logo f_l">
    	<a href="###"><img src="images/shop/logo.jpg" width="331" height="76" /></a>
    </div>
    <div class="info f_r">
    	<p class="p1 f_r"><span class="f_l">亲爱的用户&nbsp;<i>${username}</i>&nbsp;&nbsp;<a  href="implant/logout.jsp">安全退出</a>&nbsp;&nbsp;</span><img src="images/shop/tel.jpg" width="210" height="22" class="f_l" /></p>
        <p class="p2 f_r">上海地区免运费，南京、杭州等11个城市99元免运费，其它城市399元免运费。<a href="###">查看详情</a></p>
    </div>
</div>

<div class="prompt">
	<div class="promptCon"></div>
</div>

<form action="order?statusId=${statusId}" method="post">
<div class="cart">
	<div class="settlement f_r">
    	<h3><i>购物车结算</i></h3>
        <p class="setMoney"><i class="f_r">¥${totaPrice }</i>商品金额：</p>
        <p><i class="f_r">¥${totaPrice+5.0 }</i>合计：</p>
        <input type="submit" value="立即结账" />
        <a href="###">继续购物&gt;&gt;</a>
    </div>
    <div class="order">
    	<h3><i>我的购物车</i></h3>
        <table  border=0 cellpadding=0 cellspacing=0 >
        	<tr class="title"><td style="width:60px;">&nbsp;<input id="allCheckBox" type="checkbox" />&nbsp;全选</td><td>&nbsp;&nbsp;&nbsp;&nbsp;商品名称</td><td style=" width:80px;" align="center">单价</td><td style="width:80px;" align="center">数量</td><td style="width:80px;" align="center">小计</td><td style="width:80px;" align="center">操作</td></tr>
            <c:forEach var="item" items="${poList }" varStatus="i">  
            <tr class="list">
            	<td align="center"><input name="cartCheckVal" type="checkbox" /></td>
                <td>
                	<span class="listImg f_l"><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce }"><img src="images/share/${item.print }" width="80" height="60" /></a></span>
                    <span class="Text f_l"><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce }">${fn:substring(item.introduce,0,70)}</a></span>
                </td>
                <td class="money" align="center">¥${item.price }</td>
                <td class="addOrsub"><span><input type="text" class="inputText" value="${item.number}" readonly="readonly"/><p class="f_r"><input onclick="window.location.href='cart?id=${item.products_id}&statusId=${item.status_id }&number=${item.number+1}'" type="button" class="add" /><input onclick="window.location.href='cart?id=${item.products_id}&statusId=${item.status_id }&number=${item.number-1}'" type="button" class="sub" /></p></span></td>
                <td class="money" align="center">¥${item.price*item.number }</td>
                <td class="delete" align="center"><a  href="javascript:if(confirm('是否确认删除')){location.href='cart?id=${item.products_id}&statusId=${item.status_id }';}">删除</a></td>
           	</tr>
           	</c:forEach>
        </table>
    </div>
</div>
</form>

<div class="borderBj"></div>

<div class="share">
	<span>
    	<h3>
        	<i>疯抢商品</i>
        </h3>
    </span>
    <c:forEach var="item" items="${folieList }" varStatus="i">  
    <dl class="f_l">
    	<dt><a href="goods?id=${item.products_id}" target="_blank" title="${item.introduce} 分类：${item.classify} 品牌：${item.brand} 型号： ${item.model}"><img src="images/share/${item.picture }" width="144" height="108" /></a></dt>
        <dd>
        	<p><a href="goods?id=${item.products_id}" target="_blank" title="${item.introduce} 分类：${item.classify} 品牌：${item.brand} 型号： ${item.model}">${fn:substring(item.introduce,0,36)}</a></p>
            <span>${fn:substring(item.bewrite,0,13)}</span>
        	<i>￥${item.price }</i>
        	<input type="button" value="加入收藏夹" onclick="javascript:saveSql(${item.products_id },1,1);"  />
        </dd>
    </dl>
   </c:forEach>
</div>

<div class="borderBj"></div>

<div class="footer">
	<p>新蛋集团网站：<a href="###">美国新蛋</a>&nbsp;&nbsp;<a href="###">中国新蛋</a>&nbsp;&nbsp;<a href="###">加拿大新蛋 </a>&nbsp;&nbsp;<a href="###">新蛋软件</a></p>
    <p>© 2001-2014 新蛋贸易（中国）有限公司 版权所有 沪ICP备:05006005</p>
</div>
</body>
</html>
