<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JS百叶窗焦点图</title>
<script type=text/javascript src="implant/goodGoods/goodGoods.js"></script>
<style type="text/css">
/*公共样式*/
*{ margin:0; padding:0;}
body{ font-family:"宋体"; color:#666; font-size:12px; background:#fff;}
a{ color:#666; text-decoration:none;}
a:hover{ color:#666; text-decoration:none;}
a img{ border:none;}
.f_l{ float:left;}
.f_r{ float:right;}
span{ display:block;}
i{ font-style:normal;}
em{ font-style:normal;}
ul li{ list-style-type:none;}
.c{ clear:both;}

/*百叶窗焦点图样式*/
.goodGoods{ width:1198px; height:275px; border:1px solid #d9d9d9;}
.slide{ width:673px; height:;}
.slide dl{ width:673px; height:275px; position:relative; background:#fff;}
.slide dl dt{ width:311px; height:275px; float:left;}
.slide dl dt img{ padding-left:32px; padding-top:35px;}
.slide dl dd{ width:362px; height:275px; float:left;}
.slide dl dd h3{ height:32px; line-height:32px; font-family:"微软雅黑"; margin-top:28px;}
.slide dl dd h3 em{ color:#f60; font-weight:bold;}
.slide dl dd h3 a{ font-weight:normal; color:#333; text-decoration:none;}
.slide dl dd h3 a:hover{ font-weight:normal; color:#333; text-decoration:underline;}
.slide dl dd p{ color:#676767; line-height:21px; font-family:"Arial"; width:334px; height:135px; word-break:break-all;}
.slide dl dd i{ color:#676767; font-family:"Arial"; padding-right:80px;}
.slide dl .portrait{ position:absolute; left:603px; top:196px;}

/*id控制*/
#center { }
#slider { position: absolute; width: 1198px; height: 275px; overflow: hidden; top: 0px; left: 0px}
#slider .slide { position: absolute; border-left:1px solid #d9d9d9; width: 673px; height: 275px; overflow: hidden; top: 0px; cursor: default; left: 22px;text-align:left;}
#slider .title { color: #f80; font-size: 1.2em; font-weight: bold; margin-right: 1.5em; text-decoration: none;}
#slider .text {	position: absolute; text-align: justify; width: 470px; display: none; font-family: verdana, arial, helvetica, sans-serif; color: #fff; font-size: 0.9em; top: 100%; left: 10px;}
#slider .diapo { position: absolute; filter: alpha(opacity=100); visibility: visible; opacity: 1;}
#apdiv1 { z-index: 1; position: absolute; background-color: #000000; width: 820px; height: 30px; overflow: hidden; top: 0px; left: 0px;}
#apdiv2 { z-index: 3; position: absolute; width: 860px; height: 35px; overflow: hidden; top: 216px; left: -429px;}

</style>
</head>

<body>

<div id="center">
<div class="goodGoods" id="slider">
	<c:forEach var="item" items="${cList}" varStatus="i" begin="0" end="0">
	<div class=slide>
    	<dl>
        	<dt><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem1.introduce} 分类：${pItem1.classify} 品牌：${pItem1.brand} 型号： ${pItem1.model}"><img src="images/share/${piItem1.products_large }" width="250" height="187" class=diapo 
	border=0 /></a></dt>
        	<dd>
            	<h3><em>推荐度100%</em><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem1.introduce} 分类：${pItem1.classify} 品牌：${pItem1.brand} 型号： ${pItem1.model}"> ${fn:substring(pItem1.introduce,0,24)}</a></h3>
                <p>${fn:substring(item.ne_content,0,143)}...</p>
                <i class="f_r">${item.ne_user_id}</i>
            </dd>
            <img src="implant/goodGoods/portrait.jpg" width="60" height="60" class="portrait" />
        </dl>
		<div class=text></div>
    </div>
    </c:forEach>
    <c:forEach var="item" items="${cList}" varStatus="i" begin="1" end="1">
	<div class=slide>
    	<dl>
        	<dt><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem2.introduce} 分类：${pItem2.classify} 品牌：${pItem2.brand} 型号： ${pItem2.model}"><img src="images/share/${piItem2.products_large }" width="250" height="187" class=diapo 
	border=0 /></a></dt>
        	<dd>
            	<h3><em>推荐度100%</em><a href="goods?id=${item.ne_products_id}"  target="_blank"  title="${pItem2.introduce} 分类：${pItem2.classify} 品牌：${pItem2.brand} 型号： ${pItem2.model}"> ${fn:substring(pItem2.introduce,0,24)}</a></h3>
                <p>${fn:substring(item.ne_content,0,143)}...</p>
                <i class="f_r">${item.ne_user_id}</i>
            </dd>
            <img src="implant/goodGoods/portrait.jpg" width="60" height="60" class="portrait" />
        </dl>
		<div class=text></div>
    </div>
    </c:forEach>
    <c:forEach var="item" items="${cList}" varStatus="i" begin="2" end="2">
	<div class=slide>
    	<dl>
        	<dt><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem3.introduce} 分类：${pItem3.classify} 品牌：${pItem3.brand} 型号： ${pItem3.model}"><img src="images/share/${piItem3.products_large }" width="250" height="187" class=diapo 
	border=0 /></a></dt>
        	<dd>
            	<h3><em>推荐度100%</em><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem3.introduce} 分类：${pItem3.classify} 品牌：${pItem3.brand} 型号： ${pItem3.model}"> ${fn:substring(pItem3.introduce,0,24)}</a></h3>
                <p>${fn:substring(item.ne_content,0,143)}...</p>
                <i class="f_r">${item.ne_user_id}</i>
            </dd>
            <img src="implant/goodGoods/portrait.jpg" width="60" height="60" class="portrait" />
        </dl>
		<div class=text></div>
    </div>
    </c:forEach>
    <c:forEach var="item" items="${cList}" varStatus="i" begin="3" end="3">
	<div class=slide>
    	<dl>
        	<dt><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem4.introduce} 分类：${pItem4.classify} 品牌：${pItem4.brand} 型号： ${pItem4.model}"><img src="images/share/${piItem4.products_large }" width="250" height="187" class=diapo 
	border=0 /></a></dt>
        	<dd>
            	<h3><em>推荐度100%</em><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem4.introduce} 分类：${pItem4.classify} 品牌：${pItem4.brand} 型号： ${pItem4.model}"> ${fn:substring(pItem4.introduce,0,24)}</a></h3>
                <p>${fn:substring(item.ne_content,0,143)}...</p>
                <i class="f_r">${item.ne_user_id}</i>
            </dd>
            <img src="implant/goodGoods/portrait.jpg" width="60" height="60" class="portrait" />
        </dl>
		<div class=text></div>
    </div>
    </c:forEach>
    <c:forEach var="item" items="${cList}" varStatus="i" begin="4" end="4">
	<div class=slide>
    	<dl>
        	<dt><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem5.introduce} 分类：${pItem5.classify} 品牌：${pItem5.brand} 型号： ${pItem5.model}"><img src="images/share/${piItem5.products_large }" width="250" height="187" class=diapo 
	border=0 /></a></dt>
        	<dd>
            	<h3><em>推荐度100%</em><a href="goods?id=${item.ne_products_id}" target="_blank"  title="${pItem5.introduce} 分类：${pItem5.classify} 品牌：${pItem5.brand} 型号： ${pItem5.model}"> ${fn:substring(pItem5.introduce,0,24)}</a></h3>
                <p>${fn:substring(item.ne_content,0,143)}...</p>
                <i class="f_r">${item.ne_user_id}</i>
            </dd>
            <img src="implant/goodGoods/portrait.jpg" width="60" height="60" class="portrait" />
        </dl>
		<div class=text></div>
    </div>
    </c:forEach>
</div>
</div>

<script type=text/javascript>
slider.init();
</script>

</body>
</html>

