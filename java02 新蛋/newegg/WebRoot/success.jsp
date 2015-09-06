<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("index");
	}
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>提交成功</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/success.css" />
<script type="text/javascript" src="js/success.js"></script>
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


<div class="success">
	<div class="text f_l">
    	<h3><i>您的订单提交成功，感谢您在新蛋网购物！</i></h3>
        <p>您的订单编号：</p>
        <p><em>订单：</em>${orderFatherId }<a href="home" target="_blank" >[查看订单]</a></p>
        <p class="setColor">请您记下这个号码, 以便您在付款和享受新蛋网提供的售后服务时使用</p>
        <p class="setColor2">应付金额：<i>¥${total}</i></p>
        <p class="setCon">不想错过新蛋网最棒，最新，最给力的优惠活动？<a href="###">点击这里</a>立即订阅<br />《蛋哥省钱快报》</p>
    </div>
    <div class="share">
    	<h3><i>分享给好友</i></h3>
        <div class="h4">
        	<h4 class="f_l icon03" id="share1"><a href="###">新浪微博</a></h4>
            <h4 class="f_l icon04" id="share2"><a href="###">腾讯微博</a></h4>
            <h4 class="f_l icon01" id="share3"><a href="###">人人网</a></h4>
            <h4 class="f_l icon02" id="share4"><a href="###">开心网</a></h4>
        </div>
        <div class="con">
        	<c:forEach var="item" items="${poList }" varStatus="i">  
        	<span class="f_l"><a href="goods?id=${item.products_id}" target="_blank" title="${item.introduce }"><img src="images/share/${item.print }" width="80" height="60" /></a></span>
            </c:forEach>
            <div class="c" style="height:15px;"></div>
            <textarea>我刚在新蛋商城买了<c:forEach var="item" items="${poList }" varStatus="i"> ${item.introduce }&nbsp;&nbsp;</c:forEach></textarea>
            <input type="button" value="立即分享" />
        </div>
    </div>
</div>

<div class="footer">
	<p>新蛋集团网站：<a href="###">美国新蛋</a>&nbsp;&nbsp;<a href="###">中国新蛋</a>&nbsp;&nbsp;<a href="###">加拿大新蛋 </a>&nbsp;&nbsp;<a href="###">新蛋软件</a></p>
    <p>© 2001-2014 新蛋贸易（中国）有限公司 版权所有 沪ICP备:05006005</p>
</div>
</body>
</html>


