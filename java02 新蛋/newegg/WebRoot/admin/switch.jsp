<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
</style>
</head>
<script language="javascript">
	function $(id) {
		return document.getElementById(id);
	}

	window.onload = function() {
		var count = 0;
		$("menuSwitch").onclick = function() {
			var mainFrame = top.document.getElementById("framePage");
			var menuSwitch = $("menuSwitch");
			if (count % 2 == 0) {
				mainFrame.cols = "0,10,*";
				menuSwitch.style.backgroundImage = 'url(admin/images/frameShow.gif)';
				menuSwitch.title = '点击打开管理界面菜单';
			} else {
				mainFrame.cols = "153,10,*";
				menuSwitch.style.backgroundImage = 'url(admin/images/frameHide.gif)';
				menuSwitch.title = '点击隐藏管理界面菜单';
			}
			count++;
		};
	};
</script>
</head>

<body>
	<div
		style="height:800px; padding-top:260px; width:100px; cursor:pointer; background:url(admin/images/frameSwitchBj.gif) repeat-y;">
		<div id="menuSwitch"
			style="background:url(admin/images/frameHide.gif) no-repeat; width:10px; height:86px;"
			title="点击隐藏管理界面菜单"></div>
	</div>
</body>
</html>
