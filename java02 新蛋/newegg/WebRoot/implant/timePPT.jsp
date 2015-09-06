<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	if(request.getAttribute("lbList")==null || request.getAttribute("lbList").equals("")){
		response.sendRedirect("timePPT");
	}
 %>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JS鼠标控制左右滚动图片带自动翻滚</title>
<script type="text/javascript" src="implant/timePPT/timePPT.js"></script>
<style type="text/css">

/*公共样式*/
*{ margin:0; padding:0;}
body{ font-family:"宋体"; color:#666; font-size:12px; background:#fff;}
a{ color:#666; text-decoration:none;}
a:hover{ color:#666; text-decoration:none;}
a img{ border:none;}
.f_l{ float:left;}
.f_r{ float:right;}
i{ font-style:normal;}
em{ font-style:normal;}
ul li{ list-style-type:none;}
.c{ clear:both;}

/*倒计时PPT样式*/
.timePPT{ width:771px; height:233px;}
/*倒计时PPT头部的倒计时*/
.timePPT .title{ width:771px; height:28px; margin-bottom:8px;}
.timePPT .title h3{ font-family:"微软雅黑"; line-height:28px; font-size:16px; font-weight:bold; color:#c00;}
.timePPT .title a{ color:#666; font-weight:bold; width:90px; font-size:12px; background:url(icon.jpg) no-repeat 80px 2px;}
.timePPT .title span{ text-align:center; font-weight:bold; font-size:14px; line-height:28px; color:#666; display:block;}
.timePPT .title span i{ padding:5px; background:#eee;}

/*滚动图片效果样式*/
.rollBox{width:771px; height:169px; overflow:hidden; position:relative;}
.rollBox .LeftBotton{ width:12px; height:169px; background:url(implant/timePPT/LeftBotton.jpg) no-repeat 0px 72px; top:0; left:0; overflow:hidden; display:inline; position:absolute; cursor:pointer;}
.rollBox .LeftBotton:hover{ background:url(implant/timePPT/LeftBottonHover.jpg) no-repeat 0px 72px;}
.rollBox .RightBotton{ width:12px; height:169px; background:url(implant/timePPT/RightBotton.jpg) no-repeat 3px 72px; top:0; right:0; overflow:hidden; position:absolute; display:inline; cursor:pointer;}
.rollBox .RightBotton:hover{ background:url(implant/timePPT/RightBottonHover.jpg) no-repeat 3px 72px; }
.rollBox .Cont{ width:740px; height:169px; margin-left:18px; overflow:hidden;float:left;}
.rollBox .ScrCont{width:10000000px;}
.rollBox .Cont .pic{ width:150px; height:169px; float:left; padding:0 17px 0 18px;}
.rollBox .Cont .pic img{ padding-left:3px;}
.rollBox .Cont .pic p{ font-family:"Arial"; line-height:18px; word-break:break-all;}
.rollBox .Cont .pic p a{ color:#666; text-decoration:none;}
.rollBox .Cont .pic p a:hover{ color:#666; text-decoration:underline;}
.rollBox .Cont .pic i{ font-family:"微软雅黑"; color:#f60; font-weight:bold; font-size:14px; margin-top:4px; }
.rollBox .Cont a:link,.rollBox .Cont a:visited{color:#626466;text-decoration:none;}
.rollBox .Cont a:hover{color:#f00;text-decoration:underline;}
.rollBox #List1,.rollBox #List2{float:left;}
</style>
</head>

<body>
<div class="timePPT">

<div class="title">
<h3 class="f_l"><i>限时抢购</i></h3><a href="time" target="_blank" class="f_r">更多抢购商品</a> <span>剩余时间：<i id="hour"></i>:<i id="minute"></i>:<i id="second"></i></span>
</div>
        
<div class="rollBox">
    <div class="LeftBotton" onmousedown="ISL_GoUp()" onmouseup="ISL_StopUp()" onmouseout="ISL_StopUp()"></div>
    <div class="Cont" id="ISL_Cont">
        <div class="ScrCont">
            <div id="List1"> 
                <!-- 图片列表 begin -->
                <c:forEach var="item" items="${lbList}" varStatus="i">
                <c:if test="${i.index <11}" >  
                <div class="pic"><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce} 分类：${item.classify} 品牌：${item.brand} 型号： ${item.model}"><img src="images/share/${item.picture}" width="144" height="108" /></a><p><a href="goods?id=${item.products_id}" target="_blank"  title="${item.introduce} 分类：${item.classify} 品牌：${item.brand} 型号： ${item.model}">${fn:substring(item.introduce,0,36)}</a></p><i>￥${item.price}</i>
                </div>
                </c:if>
				</c:forEach>
                <!-- 图片列表 end -->                
            </div>
            <div id="List2"></div>
        </div>
    </div>
    <div class="RightBotton" onmousedown="ISL_GoDown()" onmouseup="ISL_StopDown()" onmouseout="ISL_StopDown()"></div>
</div>

</div>
<script language="javascript" type="text/javascript">
<!--//--><![CDATA[//><!--
//图片滚动列表 mengjia 070816
var Speed = 1; //速度(毫秒)
var Space = 740; //每次移动(px)
var PageWidth = 740; //翻页宽度
var fill = 0; //整体移位
var MoveLock = false;
var MoveTimeObj;
var Comp = 0;
var AutoPlayObj = null;
GetObj("List2").innerHTML = GetObj("List1").innerHTML;
GetObj('ISL_Cont').scrollLeft = fill;
GetObj("ISL_Cont").onmouseover = function(){clearInterval(AutoPlayObj);}
GetObj("ISL_Cont").onmouseout = function(){AutoPlay();}
AutoPlay();
function GetObj(objName){if(document.getElementById){return eval('document.getElementById("'+objName+'")')}else{return eval('document.all.'+objName)}}
function AutoPlay(){ //自动滚动
 clearInterval(AutoPlayObj);
 AutoPlayObj = setInterval('ISL_GoDown();ISL_StopDown();',3000); //间隔时间
}
function ISL_GoUp(){ //上翻开始
 if(MoveLock) return;
 clearInterval(AutoPlayObj);
 MoveLock = true;
 MoveTimeObj = setInterval('ISL_ScrUp();',Speed);
}
function ISL_StopUp(){ //上翻停止
 clearInterval(MoveTimeObj);
 if(GetObj('ISL_Cont').scrollLeft % PageWidth - fill != 0){
  Comp = fill - (GetObj('ISL_Cont').scrollLeft % PageWidth);
  CompScr();
 }else{
  MoveLock = false;
 }
 AutoPlay();
}
function ISL_ScrUp(){ //上翻动作
 if(GetObj('ISL_Cont').scrollLeft <= 0){GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft + GetObj('List1').offsetWidth}
 GetObj('ISL_Cont').scrollLeft -= Space ;
}
function ISL_GoDown(){ //下翻
 clearInterval(MoveTimeObj);
 if(MoveLock) return;
 clearInterval(AutoPlayObj);
 MoveLock = true;
 ISL_ScrDown();
 MoveTimeObj = setInterval('ISL_ScrDown()',Speed);
}
function ISL_StopDown(){ //下翻停止
 clearInterval(MoveTimeObj);
 if(GetObj('ISL_Cont').scrollLeft % PageWidth - fill != 0 ){
  Comp = PageWidth - GetObj('ISL_Cont').scrollLeft % PageWidth + fill;
  CompScr();
 }else{
  MoveLock = false;
 }
 AutoPlay();
}
function ISL_ScrDown(){ //下翻动作
 if(GetObj('ISL_Cont').scrollLeft >= GetObj('List1').scrollWidth){GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft - GetObj('List1').scrollWidth;}
 GetObj('ISL_Cont').scrollLeft += Space ;
}
function CompScr(){
 var num;
 if(Comp == 0){MoveLock = false;return;}
 if(Comp < 0){ //上翻
  if(Comp < -Space){
   Comp += Space;
   num = Space;
  }else{
   num = -Comp;
   Comp = 0;
  }
  GetObj('ISL_Cont').scrollLeft -= num;
  setTimeout('CompScr()',Speed);
 }else{ //下翻
  if(Comp > Space){
   Comp -= Space;
   num = Space;
  }else{
   num = Comp;
   Comp = 0;
  }
  GetObj('ISL_Cont').scrollLeft += num;
  setTimeout('CompScr()',Speed);
 }
}
//--><!]]>
</script>
</body>
</html>

