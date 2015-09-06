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
<link rel="stylesheet" href="admin/css/sideMenu.css" type="text/css" />
<script language="javascript">
	/*共用*/
	function $(id) {
		return document.getElementById(id);
	}

	window.onload = function() {

		var countId1 = 0;
		$("Id1").onclick = function() {
			var Id1 = $("Id1");
			var Id1Hover = $("Id1Hover");
			if (countId1 % 2 == 0) {
				Id1Hover.style.display = "block";
				Id1.style.backgroundImage = "url(admin/images/buttom.jpg)";
				Id1.style.backgroundRepeat = "no-repeat";
				Id1.style.color = "#b6241f";
			} else {
				Id1Hover.style.display = "none";
				Id1.style.backgroundImage = "url(admin/images/buttomHover.jpg)";
				Id1.style.backgroundRepeat = "no-repeat";
				Id1.style.color = "#fff";
			}
			countId1++;
		};

		var countId2 = 0;
		$("Id2").onclick = function() {
			var Id2 = $("Id2");
			var Id2Hover = $("Id2Hover");
			if (countId2 % 2 == 0) {
				Id2Hover.style.display = "block";
				Id2.style.backgroundImage = "url(admin/images/buttom.jpg)";
				Id2.style.backgroundRepeat = "no-repeat";
				Id2.style.color = "#b6241f";
			} else {
				Id2Hover.style.display = "none";
				Id2.style.backgroundImage = "url(admin/images/buttomHover.jpg)";
				Id2.style.backgroundRepeat = "no-repeat";
				Id2.style.color = "#fff";
			}
			countId2++;
		};

		var countId3 = 0;
		$("Id3").onclick = function() {
			var Id3 = $("Id3");
			var Id3Hover = $("Id3Hover");
			if (countId3 % 2 == 0) {
				Id3Hover.style.display = "block";
				Id3.style.backgroundImage = "url(admin/images/buttom.jpg)";
				Id3.style.backgroundRepeat = "no-repeat";
				Id3.style.color = "#b6241f";
			} else {
				Id3Hover.style.display = "none";
				Id3.style.backgroundImage = "url(admin/images/buttomHover.jpg)";
				Id3.style.backgroundRepeat = "no-repeat";
				Id3.style.color = "#fff";
			}
			countId3++;
		};

		var countId4 = 0;
		$("Id4").onclick = function() {
			var Id4 = $("Id4");
			var Id4Hover = $("Id4Hover");
			if (countId4 % 2 == 0) {
				Id4Hover.style.display = "block";
				Id4.style.backgroundImage = "url(admin/images/buttom.jpg)";
				Id4.style.backgroundRepeat = "no-repeat";
				Id4.style.color = "#b6241f";
			} else {
				Id4Hover.style.display = "none";
				Id4.style.backgroundImage = "url(admin/images/buttomHover.jpg)";
				Id4.style.backgroundRepeat = "no-repeat";
				Id4.style.color = "#fff";
			}
			countId4++;
		};
	};
</script>
</head>
<%!
	 //统计访问次数
	public synchronized void browCount(ServletContext application) {
		if (application.getAttribute("brow") == null) {
			application.setAttribute("brow", 1);
		} else {
			int count = Integer.parseInt(application.getAttribute("brow")
					.toString());
			application.setAttribute("brow", count + 1);
		}

	}%>

<%
	browCount(application);
%>
<body>
	<div class="sideMenu">
		<div class="logo">
			<img src="admin/images/logo.jpg" width="153" height="75" />
		</div>
		<div class="info">
			<p class="p1">管理员：${adminName}</p>
			<p class="p2">
				<a href="admin/AdminLogout.jsp">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="###"
					target="_blank">打开新蛋首页</a>
			</p>
			<p class="p3">统计访问次数：<%=application.getAttribute("brow") %></p>
		</div>
		<h3>
			<a id="Id1">用户管理</a>
		</h3>
		<ul id="Id1Hover" style="display:none;">
			<li><a href="userList" target="main">用户管理</a>
			</li>
			<c:if test="${uList.ne_level_id eq '3'}">
			<li><a href="userNew" target="main">新增管理员</a>
			</li>
			</c:if>
		</ul>
		<h3>
			<a id="Id2">商品信息</a>
		</h3>
		<ul id="Id2Hover" style="display:none;">
			<c:if test="${uList.ne_level_id eq '3'}">
			<li><a href="classUpdate" target="main">分类管理</a>
			</li>
			<li><a href="classNew" target="main">创建分类</a>
			</li>
			</c:if>
			<li><a href="goodsList?substance=" target="main">商品管理</a>
			</li>
			<li><a href="goodsNew" target="main">新增商品</a>
			</li>
		</ul>
		<h3>
			<a id="Id3">订单管理</a>
		</h3>
		<ul id="Id3Hover" style="display:none;">
			<li><a href="orderList" target="main">订单管理</a>
			</li>
		</ul>
		<h3>
			<a id="Id4">评论管理</a>
		</h3>
		<ul id="Id4Hover" style="display:none;">
			<li><a href="commentList" target="main">评论管理</a>
			</li>
		</ul>
	</div>
</body>
</html>
