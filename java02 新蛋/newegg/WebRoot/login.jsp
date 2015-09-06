<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>

<div class="header">
	<div class="headerCon">
		<ul class="headerLeft f_l">
    		<li class="phone f_l"><a href="###">掌上新蛋</a></li>
        	<li class="customer f_l"><a href="###">企业客户</a></li>
        	<li class="platform f_l"><a href="###">入驻开放平台</a></li>
    	</ul>
    	<ul class="headerRight f_r">
        	<li class="welcome f_l">上午好,欢迎来新蛋购物！</li>
        	<li class="help f_l"><a href="###">帮助中心</a></li>
        	<li class="service f_l" id="service">客户服务</li>
    	</ul>
        <div class="service2" id="service2" style="display:none;"></div>
    </div>
</div>

<div class="searchbar">
	<div class="logo f_l"><a href="index" title="新蛋中国 - 全球领先的IT/数码网上购物商城-笔记本,电脑配件,数码相机,手机,办公设备,家电,百货"><img src="images/logo.jpg" width="322" height="65" /></a></div>
    <h3 class="f_l"><i>欢迎登录</i></h3>
</div>

<div class="area">
	<div class="banner f_l">
    	<a href="###"><img src="images/login/banner.png" width="478" height="362" /></a>
    </div>
    <div class="login f_l">
    	<form action="login" method="post" name="loginForm">
    	<h3><a href="register" class="f_r">注册新用户&gt;&gt;</a><i>登录新蛋</i></h3>
        <p>用户名:<input type="text" id="username" name="uname" /></p>
        <h5 id="usernameId"></h5>
        <p>密&nbsp;&nbsp;码:<input type="password" id="password" name="upass" /></p>
        <h5 id="passwordId"></h5>
        <span><input type="submit" value="立即登陆" /><a href="register">账户安全</a><a href="register">忘记密码？</a></span>
        </form>
        <div class="loginIcon">
        	<h4><i>您还可以使用以下合作伙伴的账户登录新蛋网：</i></h4>
        	<a href="##">支付宝</a>
            <a href="##">QQ</a>
            <a href="##">网易</a>
            <a href="##">新浪微博</a>
            <br />
            <a href="##">手机支付</a>
            <a href="##">盛大登录</a>
            <a href="##">财付通</a>
            <a href="##">迅雷</a>
            <br />
            <a href="##">平安万里通</a>
            <a href="##">莆田政府采购登录</a>
        </div>
	</div>
</div>

<div class="iconAndEmail">
	<div class="icon">
    	<h3 class="f_l">关注我们：</h3>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon01.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">人人网</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon02.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">开心网</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon03.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">新浪微博</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon04.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">腾讯微博</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon05.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">优酷视频</a></dd>
        </dl>
    </div>
</div>

<div class="footer">
	<p class="footNav"><a href="###">关于我们</a>|<a href="###">联系我们</a>|<a href="###">人才招聘</a>|<a href="###">商家入驻</a>|<a href="###">广告服务</a>|<a href="###">手机新蛋</a>|<a href="###">友情链接</a>|<a href="###">销售联盟</a>|<a href="###">新蛋社区</a>|<a href="###">新蛋公益</a>|<a href="###">English Site</a></p>
    <p>北京市公安局朝阳分局备案编号110105014669&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;互联网药品信息服务资格证编号(京)-非经营性-2011-0034  |  新出发京零 字第大120007号</p>
    <p>音像制品经营许可证苏宿批005号&nbsp;&nbsp;|&nbsp;&nbsp;出版物经营许可证编号新出发(苏)批字第N-012号&nbsp;&nbsp;|&nbsp;&nbsp;互联网出版许可证编号新出网证(京)字150号</p>
    <p>网络文化经营许可证京网文[2011]0168-061号&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2004-2014&nbsp;&nbsp;新蛋newegg.com 版权所有</p>
    <p>新蛋旗下网站：360TOP</p>
    <span><a href="###"><img src="images/footer01.gif" width="108" height="40" /></a><a href="###"><img src="images/footer02.gif" width="108" height="40" /></a><a href="###"><img src="images/footer03.png" width="108" height="40" /></a><a href="###"><img src="images/footer04.png" width="112" height="40" /></a></span>
</div>

</body>
</html>
<<c:if test="${flag==false }">
	<script type="text/javascript">failureOfTips();</script>
</c:if>

