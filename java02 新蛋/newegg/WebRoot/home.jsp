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
<title>我的家</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<link rel="stylesheet" type="text/css" href="css/float.css" />
<script type="text/javascript" src="js/home.js"></script>
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
        	<li class="service f_r" id="service">客户服务</li>
            <li class="help f_r"><a href="###">帮助中心</a></li>
            <li class="myNewegg f_r" id="myNewegg">我的新蛋</li>
            <li class="myOrder f_r"><a href="###">我的订单</a></li>
            <li class="welcome f_r">上午好,欢迎来新蛋购物！</li>
    		<c:if test="${username eq null}">
    		<li class="regOrLogin f_r" ><a href="register" class="f_l">注册</a><a href="login" class="f_r">登陆</a></li>
    		</c:if>
    		<c:if test="${username ne null}">
            <li class="f_r username" >亲爱的用户<em>${username}</em><a href="implant/logout.jsp">安全退出</a></li>
            </c:if>
    	</ul>
        <c:if test="${username eq null}">
    	<div class="myNewegg2" id="myNewegg2" style="display:none;">
            <p><a href="login" target="_blank" >请登陆后查看</a></p>
        </div>
    	</c:if>
    	<c:if test="${username ne null}">
        <div class="myNewegg2" id="myNewegg2" style="display:none;">
            <p><a href="home" target="_blank" >我的订单：${orderCount}</a></p>
            <p><a href="cart?statusId=1" target="_blank" >我的收藏：${collectListSize }</a></p>
            <p><a href="###">我的评论：${commentCount }</a></p>
            <p><a href="cart?statusId=2" target="_blank" >我的购物车：${cartListSize }</a></p>
        </div>
        </c:if> 
        <div class="service2" id="service2" style="display:none;"></div>
    </div>
</div>

<div class="searchbar">
	<div class="logo f_l"><a href="index" target="_blank" title="新蛋中国 - 全球领先的IT/数码网上购物商城-笔记本,电脑配件,数码相机,手机,办公设备,家电,百货"><img src="images/logo.jpg" width="322" height="65" /></a></div>
    <div class="search f_l">
    	<span>
    		<form action="search" method="get">
        		<input name="substance"  type="text" class="inputTxt" /><input type="submit" class="submitBut" value="搜索" />
        	</form>
        </span>
        <p><a href="###">MX100</a>|<a href="###">Ascend P6</a>|<a href="###">路由器</a>|<a href="###">电风扇</a></p>
    </div>
    <div class="returnGoods f_r"><a href="###" title="7天无理由退换货"><img src="images/returnGoods.gif" width="225" height="86" /></a></div>
</div>

<div class="nav">
	<div class="navCon">
    	<span class="allClass f_l" id="menu"><i title="全部商品分类">全部商品分类</i></span>
        <ul class="f_l">
        	<li class="f_l"><a href="index" target="_blank"  title="首页">首页</a></li>
            <li class="f_l"><a href="time" target="_blank"  title="限时抢购">限时抢购</a></li>
            <li class="f_l"><a href="###" title="团团赚">团团赚</a></li>
            <li class="f_l"><a href="###" title="手机频道">手机频道</a></li>
            <li class="f_l"><a href="###" title="极客生活">极客生活</a></li>
            <li class="f_l"><a href="###" title="爱车配">爱车配</a></li>
        </ul>
         <span class="shoppingCart f_l" id="cartManage"><i id="cartManageSub">购物车&nbsp;<em id="cartManageSub2">${cartListSize }</em>&nbsp;件</i></span>
         <span class="collectRemind f_l" id="collectionManage"><i id="collectionManageSub">收藏提醒</i></span>
         <div class="menu" id="menu2" style="display:none;">
            <div class="menuArea" id="menuArea1">
                <h3><a href="search?substance=手机" target="_blank" >手机</a><a href="###">摄影</a></h3>
                <p><a href="###" class="item1">智能手机</a><a href="search?substance=微单" target="_blank"  class="item2">微单</a></p>
            </div>
            <div class="menuArea" id="menuArea2">
                <h3><a href="###">电脑</a><a href="search?substance=平板" target="_blank">平板</a></h3>
                <p><a href="search?substance=笔记本" target="_blank" class="item1">笔记本</a><a href="search?substance=平板" target="_blank" class="item2">平板</a><a href="###" class="item2">台机</a></p>
            </div>
            <div class="menuArea" id="menuArea3">
                <h3><a href="search?substance=单反相机" target="_blank" >相机</a><a href="###">外设</a></h3>
                <p><a href="search?substance=路由器" target="_blank"  class="item1">路由器</a><a href="###" class="item2">iPad</a><a href="search?substance=耳机" target="_blank"   class="item2">耳机</a></p>
            </div>
            <div class="menuArea" id="menuArea4">
                <h3><a href="###">家用电器</a></h3>
                <p><a href="###" class="item1">电视</a><a href="###" class="item2">洗衣机</a><a href="###" class="item2">冰箱</a></p>
            </div>
            <div class="menuArea" id="menuArea5">
                <h3><a href="###">厨房</a><a href="###">生活电器</a></h3>
                <p><a href="###" class="item1">空气净化器</a><a href="###" class="item2">净水器</a></p>
            </div>
            <div class="menuArea2">
                <h3>生活百货</h3>
                <p><a href="###">汽车用品</a><a href="###">个护健康</a></p>
                <p><a href="###">办公耗材</a><a href="###">钟表</a><a href="###">礼品</a></p>
                <p><a href="###">家居</a><a href="###">食品</a><a href="###">酒饮</a><a href="###">保健</a></p>
                <p><a href="###">鞋服</a><a href="###">箱包</a><a href="###">母婴</a><a href="###">玩具</a></p>
                <p><a href="###">运动</a><a href="###">户外</a><a href="###">首饰</a><a href="###">美妆</a></p>
            </div>
        </div>
        <div class="menuClass" id="menuClass1" style="display:none;"> <span class="menuBrand f_r">
            <h3>热门品牌</h3>
            <table border=0 cellpadding=0 cellspacing=0>
                <tr>
                    <td><a href="###"><img src="images/appleLogo.jpg" /></a></td>
                    <td><a href="###"><img src="images/SamsungLogo.jpg" /></a></td>
                </tr>
                <tr>
                    <td><a href="###"><img src="images/sonyLogo.jpg" /></a></td>
                    <td><a href="###"><img src="images/huaweiLogo.jpg" /></a></td>
                </tr>
                <tr>
                    <td><a href="###"><img src="images/nikonLogo.jpg" /></a></td>
                    <td><a href="###"><img src="images/xiaomiLogo.jpg" /></a></td>
                </tr>
            </table>
            </span>
            <table class="menuContent">
                <tr>
                    <td class="w62">手机</td>
                    <td class="w478"><a href="###">智能手机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">对讲机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">合约机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">iPhone</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">非智能手机</a></td>
                </tr>
                <tr>
                    <td class="w62">运营商</td>
                    <td class="w478"><a href="###" class="a1">合约机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">选号入网</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">3G上网卡</a></td>
                </tr>
                <tr>
                    <td class="w62">手机配件</td>
                    <td class="w478"><a href="###">蓝牙耳机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">手机耳机 </a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">手机电池/充电器</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">手机数据线</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">车载手机配件</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">手机通用配件</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">手机贴膜</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">手机保护套</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">移动电源</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">iPhone附件</a></td>
                </tr>
                <tr>
                    <td class="w62">摄影摄像</td>
                    <td class="w478"><a href="###">单反相机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">单电/微单</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">镜头</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">数码相机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">数码摄像机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">特殊相机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">照片打印机</a></td>
                </tr>
                <tr>
                    <td class="w62">数码附件</td>
                    <td class="w478"><a href="###">单反配件</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">镜头滤镜 </a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">数码贴膜/清洁</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">数码包</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">三脚架/云台</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">电池/充电器 </a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">存储卡</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">MP3/MP4</a></td>
                </tr>
            </table>
        </div>
        <div class="menuClass2" id="menuClass2" style="display:none;"> <span class="menuBrand f_r">
            <h3>热门品牌</h3>
            <table border=0 cellpadding=0 cellspacing=0>
                <tr>
                    <td><a href="###"><img src="images/thinkpadLogo.jpg" /></a></td>
                    <td><a href="###"><img src="images/asusLogo.jpg" /></a></td>
                </tr>
                <tr>
                    <td><a href="###"><img src="images/dellLogo.jpg" /></a></td>
                    <td><a href="###"><img src="images/hpLogo.jpg" /></a></td>
                </tr>
                <tr>
                    <td><a href="###"><img src="images/lenovo2Logo.jpg" /></a></td>
                    <td><a href="###"><img src="images/SamsungLogo.jpg" /></a></td>
                </tr>
            </table>
            </span>
            <table class="menuContent">
                <tr>
                    <td class="w62">笔记本</td>
                    <td class="w478"><a href="###">智能手机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">电脑包</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">智能手机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">MacBook</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">笔记本</a></td>
                </tr>
                <tr>
                    <td class="w62">平板电脑</td>
                    <td class="w478"><a href="###">平板电脑配件</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">3G上网卡</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">iPad</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">平板电脑</a></td>
                </tr>
                <tr>
                    <td class="w62">台式机</td>
                    <td class="w478"><a href="###">一体机</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">iMac</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">Mac mini</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###">Mac Pro</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="###" class="a1">台式机</a></td>
                </tr>
            </table>
        </div>
        <c:if test="${cartList eq null}">
        <div class="cartManage" id="cartManage2"  style="display:none;">
            <p>您还没有购买商品，快去挑选吧！</p>
        </div>
        </c:if>
        <c:if test="${cartList ne null}">
        <div class="cartManage2"  id="cartManage2" style="display:none;">
            <h3><em class="f_r">金额总计：<i>¥${carttotaPrice}</i></em></h3>
            <c:forEach var="item" items="${cartList }" varStatus="i">  
            <dl>
                <dt class="f_l"><a href="goods?id=${item.products_id}" target="_blank" title="${item.introduce }"><img src="images/share/${item.print }" width="50" height="38" /></a></dt>
                <dd class="f_l">
                    <p><a href="goods?id=${item.products_id}" target="_blank" title="${item.introduce }">${fn:substring(item.introduce,0,18)}</a></p>
                    <i>¥${item.price }</i><em>&nbsp;&nbsp;×&nbsp;&nbsp;${item.number }</em> </dd>
            </dl>
            </c:forEach>
            <span> <a href="cart?statusId=2">查看购物车&nbsp;&gt;&gt;&nbsp;&nbsp;</a>
            <input type="button"   onclick="window.open('cart?statusId=2')" value="立即购买" />
            </span> 
         </div>
         </c:if>
         <c:if test="${collectList eq null}">
        <div class="collectionManage" id="collectionManage2" style="display:none;">
            <p>您收藏的商品暂无动态提醒．</p>
        </div>
        </c:if>
        <c:if test="${collectList ne null}">
        <div class="collectionManage2" id="collectionManage2" style="display:none;">
            <h3><em class="f_r">收藏数量：<i>${collectListSize }</i>&nbsp;件</em></h3>
            <c:forEach var="item" items="${collectList }" varStatus="i">  
            <dl>
                <dt class="f_l"><a href="goods?id=${item.products_id}" target="_blank" title="${item.introduce }"><img src="images/share/${item.print }" width="50" height="38" /></a></dt>
                <dd class="f_l">
                    <p><a href="goods?id=${item.products_id}" target="_blank" title="${item.introduce }">${fn:substring(item.introduce,0,18)}</a></p>
                    <em>收藏时间：<i>${fn:substring(item.time,0,10)}</i></em> </dd>
            </dl>
            </c:forEach>
            <span> <a href="home">查看我的订单&nbsp;&gt;&gt;&nbsp;&nbsp;</a>
            <input type="button"   onclick="window.open('cart?statusId=1')" value="管理收藏" />
            </span>
    	</div>
    	</c:if>
    </div>
</div>

<div class="home">
	<div class="sidebar f_l">
    	<h3><i>我的新蛋</i></h3>
        <span>
        	<img src="images/portrait.jpg" width="60" height="60" />
            <p><em>${username}</em></p>
            <p>会员：<i>
            	 <c:choose>  
					     <c:when test="${totaPrice>1000000}">  
					        高级会员 
					     </c:when>  
					     <c:when test="${totaPrice>10000}">  
					        中级会员 
					     </c:when>  
					     <c:otherwise>  
					        初级会员 
					     </c:otherwise>  
					 </c:choose>
            </i></p>
        </span>
        <h4><i>订单管理</i></h4>
        <ul>
        	<li><a href="###">订单查询</a></li>
            <li><a href="###">订单查询</a></li>
            <li><a href="###">售后申请</a></li>
        </ul>
        <h4><i>服务中心</i></h4>
        <ul>
        	<li><a href="###">到货通知</a></li>
            <li><a href="###">降价通知</a></li>
            <li><a href="###">我的咨询</a></li>
            <li><a href="###">我的评论</a></li>
            <li><a href="###">我的关注</a></li>
            <li><a href="###">我的配置单</a></li>
        </ul>
        <h4><i>个人信息管理</i></h4>
        <ul>
        	<li><a href="###">编辑个人信息</a></li>
            <li><a href="###">修改头像</a></li>
            <li><a href="###">管理收货信息</a></li>
            <li><a href="###">修改帐户密码</a></li>
            <li><a href="###">账户保护问题</a></li>
            <li><a href="###">支付验证设置</a></li>
            <li><a href="###">我的积分</a></li>
            <li><a href="###">我的经验值</a></li>
            <li><a href="###">我的代币</a></li>
            <li><a href="###">我的奖品</a></li>
            <li><a href="###">我的蛋券</a></li>
            <li><a href="###">我的礼品卡</a></li>
            <li><a href="###">账户余额</a></li>
        </ul>
    </div>
    <div class="manage f_r">
    	<p class="results"><a href="###">首页</a>&nbsp;&gt;&nbsp;我的新蛋</p>
        <div class="info">
        	<div class="infoLeft f_l">
            	<h3>个人信息</h3>
                <p>会员级别: <i>
                	 <c:choose>  
					     <c:when test="${totaPrice>1000000}">  
					        高级会员 
					     </c:when>  
					     <c:when test="${totaPrice>10000}">  
					        中级会员 
					     </c:when>  
					     <c:otherwise>  
					        初级会员 
					     </c:otherwise>  
					 </c:choose>
                </i></p>
                <span class="span1">手机已认证</span>
                <span class="span2">邮箱已认证</span>
            </div>
            <div class="infoRight f_l">
            	<h3><i>交易管理</i></h3>
                <p>订单管理: 有<i>${noNdvanceCount}</i>个等待处理的订单</p>
                <p>订单总量: 一共有<i>${totalCount}</i>个订单</p>
                <p>我的收藏夹: 一共有<i>${planOrdeCount}</i>个件商品</p>
                <p>总消费金额:<em>￥${totaPrice}</em></p>
            </div>
        </div>
        <div class="order">
        	<h3><i>我的订单</i><a name="Anchor"></a></h3>
            <p class="head">
            	<span class="type f_l">订单编号/类型</span>
                <span class="goods f_l">订单商品</span>
                <span class="time f_l">下单时间</span>
                <span class="money f_l">订单金额</span>
                <span class="style f_l">订单状态</span>
                <span class="operate f_l">操作</span>
            </p>
            <c:forEach var="item" items="${ofList}" varStatus="status" >
            <p class="list">
            	<span class="type f_l">${item.order_father_id }<br />普通订单</span>
                <span class="goods f_l">
                	<c:forEach var="item2"  items="${item.orderSonList}" >
                	<a href="goods?id=${item2.products_id}" target="_blank"  title="${item2.introduce } 价格：${item2.money }  数量：${item2.number } "><img src="images/share/${item2.print }" width="40" height="35" /></a>
                	</c:forEach>
                </span>
                <span class="time f_l">${fn:substring(item.order_time,0,10)}</span>
                <span class="money f_l">￥${item.total}</span>
                <span class="style f_l">${item.status}</span>
                <span class="operate f_l"><a href="javascript:if(confirm('确认是否要作废该订单')){location.href='home?pageIndex=${pageIndex}&orderId=${item.order_father_id }';}">作废订单</a></span>
            </p>
            <p class="line c"></p>
        	</c:forEach>
            <p class="page">
            	 <em class="f_r"><a href="home?pageIndex=1#Anchor">首页</a><a href="home?pageIndex=${pageIndex-1}#Anchor">上一页</a><a href="home?pageIndex=${pageIndex+1}#Anchor">下一页</a><a href="home?pageIndex=${end}#Anchor">尾页</a></em>
    <i>共${totalCount}条订单(共有${end}页，现在是第${pageIndex}页)</i>
            </p>
        </div>
        <div class="borderBj"></div>
        <div class="collection">
        	<h3><i>我最近的收藏</i></h3>
        	 <c:forEach var="item" items="${poList}" varStatus="status" begin="0" end="3" >
            <dl class="f_l">
            	<dt><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce}">${fn:substring(item.introduce,0,48)}</a> ${fn:substring(item.bewrite,0,6)}</dt>
                <dd>新蛋价：<i>￥${item.price}</i></dd>
            </dl>
            </c:forEach>
            <i id="show" style="display:none" >
            <c:forEach var="item" items="${poList}" varStatus="status" begin="4" >
            <dl class="f_l">
            	<dt><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce}">${fn:substring(item.introduce,0,48)}</a> ${fn:substring(item.bewrite,0,6)}</dt>
                <dd>新蛋价：<i>￥${item.price}</i></dd>
            </dl>
            </c:forEach>
            </i>
            <p class="c"><a class="f_r" id="operate">查看全部</a></p>
        </div>
        <div class="borderBj"></div>
    </div>
</div>

<div style="height:20px;" class="c"></div>

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
