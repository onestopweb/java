<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	if(request.getAttribute("pItem")==null || request.getAttribute("pItem").equals("")){
		response.sendRedirect("index");
	}
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品介绍</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/goods.css" />
<link rel="stylesheet" type="text/css" href="css/float.css" />
<script type="text/javascript" src="js/jqMagnifier.js" charset="gb2312"></script>
<script type="text/javascript" src="js/jsMagnifier.js" charset="gb2312"></script>
<script type="text/javascript" src="js/goods.js"></script>
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
        <p><a href="###">MX100</a>|<a href="###">Ascend P6</a>|<a href="###">路由器</a>|<a href="###">电风扇</a>|<a href="###">啤酒</a></p>
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
            <li class="f_l"><a href="###" title="二手宝库">二手宝库</a></li>
            <li class="f_l"><a href="###" title="海外直购">海外直购</a></li>
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
            <span> <a href="cart?statusId=2" target="_blank" >查看购物车&nbsp;&gt;&gt;&nbsp;&nbsp;</a>
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
            <span> <a href="home" target="_blank" >查看我的订单&nbsp;&gt;&gt;&nbsp;&nbsp;</a>
            <input type="button"  onclick="window.open('cart?statusId=1')" value="管理收藏" />
            </span>
    	</div>
    	</c:if>
    </div>
</div>

<div class="results">
	<div class="resultsCon">
    	<p><a href="###">首页&nbsp;&nbsp;&gt;&nbsp;&nbsp;</a><a href="###">${pItem.classify }&nbsp;&nbsp;&gt;&nbsp;&nbsp;</a><a href="###">${pItem.brand }&nbsp;&nbsp;&gt;&nbsp;&nbsp;</a>产品编号: ${pItem.products_id }</p>
    </div>
</div>

<div class="show">
	<div class="showImg f_l">
    	<div class="showGoods">
    		<c:forEach var="item" items="${piList}" varStatus="i" begin="0" end="0" >  
        	<a href="images/share/${item.products_large }" id="zoom1" class="MagicZoom MagicThumb"><img src="images/share/${item.products_large }" id="main_img"  style="width:439px; height:359px;" /></a>
        	</c:forEach>
        </div>
        <div class="showArea" id="showArea">
        	<c:forEach var="item" items="${piList}" varStatus="i">  
        	<c:if test="${i.index <5}" >
        	<a href="images/share/${item.products_large }" rel="zoom1" rev="images/share/${item.products_large }"><img src="images/share/${item.products_smallmap }"  /></a>
        	</c:if>
        	</c:forEach>
        </div>
        <div class="magnifier"><img src="images/goods/magnifier.gif" width="24" height="24" /></div>
    </div>
    <div class="showText f_r">
    	<h3>${pItem.introduce }</h3>
    	<p>${pItem.bewrite }</p>
        <span class="content">
        	<span class="conLeft f_l">
            	<p><em>品&nbsp;&nbsp;&nbsp;&nbsp;牌：</em><i>${pItem.brand }</i></p>
                <p><em>产品型号：</em><i>${pItem.model }</i></p>
            	<p>
            	 <c:choose>
            	 		 <c:when test="${pItem.status_id eq '1'}">  					        
					        <em>新&nbsp;品&nbsp;款：</em>
					     </c:when>   
					     <c:when test="${pItem.status_id eq '2'}">  					        
					        <em>抢&nbsp;购&nbsp;价：</em>
					     </c:when>  
					     <c:when test="${pItem.status_id eq '3'}">  
					        <em>促&nbsp;销&nbsp;价：</em>
					     </c:when>
					     <c:when test="${pItem.status_id eq '4'}">  
					        <em>秒&nbsp;杀&nbsp;价：</em>
					     </c:when>
					     <c:when test="${pItem.status_id eq '5'}">  
					        <em>经&nbsp;典&nbsp;款：</em>
					     </c:when>
					     <c:when test="${pItem.status_id eq '6'}">  
					        <em>推&nbsp;荐&nbsp;款：</em>
					     </c:when>            
					     <c:otherwise> 
					     	<em>新&nbsp;蛋&nbsp;价：</em>
					     </c:otherwise>  
					 </c:choose>
            	<i class="colorf60">¥&nbsp;<u>${pItem.price }</u></i></p>
            	<form action="handle" method="get">
                <p class="number"><em class="f_l">数&nbsp;&nbsp;&nbsp;&nbsp;量：</em><i class="f_l"><a id="numSub" class="sub f_l">-</a><input type="text" id="number" name="number" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" value="1" class="f_l" /><a id="numAdd" class="add f_l">+</a><span class="f_l">&nbsp;&nbsp;库存：${pItem.number }</span></i></p>
                <span class="function c">
                	<input type="hidden" name="id" value="${pItem.products_id }" />
                	<input type="submit" class="buy f_l" value="购买" />
                    <input type="buttom" class="cart f_l" value="购物车" onclick="javascript:saveSql2(${pItem.products_id },2,1);" />
                    <input type="buttom" class="collection f_l" value="加入收藏夹" title="加入收藏" onclick="javascript:saveSql(${pItem.products_id },1,1);" />
                    <span class="good f_l"><a class="f_l" id="love"></a><i class="f_l" id="loveId">26</i></span>
                    <span class="share f_l"><img src="images/goods/share.jpg" width="165" height="34" /></span>
                </span>
                </form>
            </span>
            <span class="conRight f_r">
            	<span class="say"><a href="###"><img src="images/goods/say.jpg" width="71" height="18" /></a></span>
                <span class="comments"><img src="images/goods/comments.jpg" width="186" height="24" /><em>已有${totalCount }人评论</em></span>
                <span class="twoWei"><a href="###"><img src="images/goods/twoWei.jpg" width="74" height="74" /></a><em>转到手机上看</em></span>
            </span>
        </span>
    </div>
</div>

<div class="area">
	<div class="browse f_l">
    	<h3><em>浏览此商品最终购买</em></h3>
    	<c:forEach var="item" items="${groomList}" varStatus="i">
        <dl>
        	<dt><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce} 分类：${item.classify} 品牌：${item.brand} 型号： ${item.model}"><img src="images/share/${item.picture}" width="125" height="94" /></a></dt>
            <dd>
            	<p><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce} 分类：${item.classify} 品牌：${item.brand} 型号： ${item.model}">${fn:substring(item.introduce,0,34)}</a></p>
                <i>¥${item.price }</i>
            </dd>
        </dl>
     	</c:forEach>
    </div>
	<div class="info f_l">
    	<p><a href="###" class="f_r"><img src="images/goods/err.jpg" width="14" height="11" />&nbsp;欢迎纠错</a><i class="f_r">如果您发现商品信息不准确，</i></p>
        <h3>${pItem.introduce }</h3>
        <c:forEach var="item" items="${pcList}" varStatus="i">  
        <img src="images/share/${item.products_content }" />
        </c:forEach>
    </div>
</div>
<div class="line c"></div>

<div class="comments" >
	<h3><em>查看评论</em><a name="Anchor"></a></h3>
    <c:forEach var="item" items="${cList}" varStatus="i">  
    <dl>
    	<dt class="f_l"><img src="images/goods/portrait.jpg" width="60" height="60" /><i>${item.ne_user_id }</i></dt>
        <dd class="f_r">
        	<span>${(pageIndex-1)*5+i.index+1} 楼&nbsp;&nbsp;&nbsp;<em>${item.ne_user_id }</em>&nbsp;说：</span>
        	<p>${item.ne_content }</p>
            <i>${item.ne_time }</i>
        </dd>
    </dl>
    </c:forEach>
</div>

<div class="page">
    <em class="f_r"><a href="goods?id=${pItem.products_id }&pageIndex=1#Anchor">首页</a><a href="goods?id=${pItem.products_id }&pageIndex=${pageIndex-1}#Anchor">上一页</a><a href="goods?id=${pItem.products_id }&pageIndex=${pageIndex+1}#Anchor">下一页</a><a href="goods?id=${pItem.products_id }&pageIndex=${end}#Anchor">尾页</a></em>
    <i>共${totalCount }条评论(共有${end}页，现在是第${pageIndex}页)</i>
</div>

<div class="submit">
	<form action="goods?id=${pItem.products_id }&pageIndex=1#Anchor" method="post" name="CommentForm">
		<h3 class="f_l"><i>我来说：</i></h3>
    	<div class="inputText f_l" ><textarea name="content" id="content" onblur="javascript:ajaxSelectComment('${pItem.products_id }');" ></textarea></div>
    	<c:if test="${username ne null}">
    	<div class="inputSubmit f_l"><input type="submit" value="提交评论" /></div>
    	</c:if>
    	<c:if test="${username eq null}">
    	<div class="inputSubmit f_l"><input type="button" value="请先登陆" /></div>
    	</c:if>
    </form>
</div>

<div class="iconAndEmail">
	<div class="icon f_l">
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
    <div class="email f_r">
    	<p class="f_l"><input type="text" class="inText" value="请输入Email地址" /><input type="button" class="inBut" value="订阅" /></p><a href="###" class="f_l">分类订阅&gt;&gt;</a><a href="###" class="f_l">新蛋省钱宝典&gt;&gt;</a>
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

<!-- 回到顶部 begin -->
<div style="position:fixed; width:30px; height:33px; cursor:pointer; bottom:35px; right:30px;"><a href="#"><img src="images/top.jpg" width="30" height="33" /></a></div>
<!-- 回到顶部 end -->

</body>
</html>
