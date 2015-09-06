<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("index");
	}
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>确认订单</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/order.css" />
<script type="text/javascript" src="js/order.js"></script>
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

<div class="title">
	<h3>
    	<i>新建或修改收货地址</i>
    </h3>
</div>

<form action="order?statusId=${statusId}" method="post" name="userForm">
<div class="site">
	<div class="consignee">
    	<h4 class="f_l"><i class="f_r">收货人:</i></h4>
        <span class="f_l"><input type="text" id="consignee" name="consignee" value="${userSelect.ne_username}" /></span>
        <p class="f_l"><i class="f_l">*</i><em class="f_l" id="consigneeId"></em></p>
    </div>
    <div class="phone">
    	<h4 class="f_l"><i class="f_r">手机:</i></h4>
        <span class="f_l"><input type="text" id="phone" name="phone" value="${userSelect.ne_phone}" /></span>
        <p class="f_l"><i class="f_l">*</i><em class="f_l" id="phoneId"></em></p>
    </div>
    <div class="tel">
    	<h4 class="f_l"><i class="f_r">联系电话:</i></h4>
        <span class="f_l"><input type="text" id="tel" name="tel" value="${userSelect.ne_tel}" /></span>
        <p class="f_l"><i class="f_l">&nbsp;</i><em class="f_l" id="telId"></em></p>
    </div>
    <div class="choose">
    	<h4 class="f_l"><i class="f_r">地区:</i></h4>
        <span class="f_l"><select id="selProvince" name="province"></select>&nbsp;&nbsp;<select id="selCity" name="city"></select>&nbsp;&nbsp;<select id="selDist" name="area"></select></span>
        <p class="f_l"><i class="f_l">*</i><em class="f_l" id="chooseId"></em></p>
    </div>
    <div class="address">
    	<h4 class="f_l"><i class="f_r">联系地址:</i></h4>
        <span class="f_l"><input type="text" id="address" name="address" value="${userSelect.ne_address}" /></span>
        <p class="f_l"><i class="f_l">*</i><em class="f_l" id="addressId"></em></p>
    </div>
    <div class="code">
    	<h4 class="f_l"><i class="f_r">邮政编码:</i></h4>
        <span class="f_l"><input type="text" id="code" name="code" value="${userSelect.ne_postalcode}" /></span>
        <p class="f_l"><i class="f_l">*</i><em class="f_l" id="codeId"></em></p>
    </div>
    <div class="email">
    	<h4 class="f_l"><i class="f_r">邮箱:</i></h4>
        <span class="f_l"><input type="text" id="email" name="email" value="${userSelect.ne_email}" /></span>
        <p class="f_l"><i class="f_l">*</i><em class="f_l" id="emailId"></em></p>
    </div>
    <div class="confirm">
    	<h4 class="f_l"></h4>
        <span class="f_l"><input type="submit" value="保存收货地址" class="submit" /><input type="reset" value="重置" class="reset" /></span>
        <p class="f_l"></p>
    </div>
</div>
</form>

<div class="title">
	<h3 class="w">
    	<i>确认订单</i>
    </h3>
</div>

<form action="success?statusId=${statusId}" method="post" name="successForm">
<div class="order">
	<div class="final f_r">
    	<h3><i>最终订单金额</i></h3>
        <p class="setMoney"><i class="f_r">¥${totaPrice }</i>商品金额:</p>
        <p><i class="f_r">¥5.00</i>运费: </p>
        <span><i class="f_r">¥${totaPrice+5.0 }</i>应付总额: </span>
        <input type="submit" value="立即结账" />
    </div>
    <div class="item">
    	<h3 class="h3-1"><i>我的订单</i></h3>
         <table border=0 cellpadding=0 cellspacing=0 >
        	<tr class="head"><td>&nbsp;&nbsp;&nbsp;&nbsp;商品名称</td><td style=" width:80px;" align="center">单价</td><td style="width:80px;" align="center">数量</td><td style="width:80px;" align="center">小计</td></tr>
            <c:forEach var="item" items="${poList }" varStatus="i">  
            <tr class="list">
                <td><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce }">${fn:substring(item.introduce,0,48)}</a>
                </td>
                <td align="center">¥${item.price }</td>
                <td align="center">${item.number}</td>
                <td align="center">¥${item.price*item.number }</td>
           	</tr>
           	</c:forEach>
        </table>
        <h3 class="h3-2"><i>配送信息</i></h3>
        <span>
        	<p><i>&nbsp;&nbsp;收货人：</i><em id="consigneeCon">${userSelect.ne_username}</em></p>
            <p><i>&nbsp;&nbsp;&nbsp;&nbsp;地址：</i><em id="addressCon">${userSelect.ne_save}${userSelect.ne_city}${userSelect.ne_borough}${userSelect.ne_address}</em></p>
            <p><i>&nbsp;&nbsp;&nbsp;&nbsp;手机：</i><em id="phoneCon">${userSelect.ne_phone}</em></p>
            <p><i>联系电话：</i><em>${userSelect.ne_tel}</em></p>
            <p><i>邮政编码：</i><em id="codeCon">${userSelect.ne_postalcode}</em></p>
            <p class="border"><i>&nbsp;&nbsp;&nbsp;&nbsp;邮箱：</i><em id="emailCon">${userSelect.ne_email}</em></p>
        </span>
    </div>
</div>
</form>

<div class="footer">
	<p>新蛋集团网站：<a href="###">美国新蛋</a>&nbsp;&nbsp;<a href="###">中国新蛋</a>&nbsp;&nbsp;<a href="###">加拿大新蛋 </a>&nbsp;&nbsp;<a href="###">新蛋软件</a></p>
    <p>© 2001-2014 新蛋贸易（中国）有限公司 版权所有 沪ICP备:05006005</p>
</div>
</body>
</html>
