<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>网站收藏</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/styles.css">
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.3.2.js"></script>
<script type="text/javascript">
	function add() {
		window
				.open(
						'toAdd.action',
						'_blank',
						'height=350, width=380, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no,left=180,top=200');
	}
</script>
</head>
<body>
	<s:form name="fav" method="post">
		<div class="banner">
			<img src="images/logo.gif"></img> 网站收藏
		</div>
		<table cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td style="text-align:right;" valign="top">
					<!-- 左边Tag列表 -->
					<div class="left_labels">
						<table class="labels_table" cellspacing="0" cellpadding="0"
							border="0">
							<tr>
								<td><a href="javascript:add();" style="font-weight:bold;">添加书签</a>
								</td>
							</tr>
							<tr>
								<td><a href="toList.action?type=-1">全部</a></td>
							</tr>
							<tr>
								<td><a href="toList.action?type=0">未分类</a></td>
							</tr>
							<s:iterator id="tag" value="tagList">
								<tr>
									<td><a
										href="toList.action?type=<s:property value='#tag.name'/>">
											<s:property value="#tag.name" /> </a></td>
								</tr>
							</s:iterator>
							<tr>
								<td class="selected_label"><a style="font-weight:bold;"
									href="toCloud.action">云图</a></td>
							</tr>
						</table>
					</div></td>
				<td>
					<!-- 右边fav内容 -->
					<div class="content_links" id="content">
						<s:iterator id="url" value="favList">
							<div style="padding:6px 10px;">
								<div>
									<a href="<s:property value="#url.url"/>"
										style="color:blue;font-size:18px;" target="_blank"><s:property
											value="#url.label" />
									</a>
								</div>
								<div style="color:black;font-size:16px;">
									<s:property value="#url.desc" />
								</div>
								<div style="color:green;font-size:14px;">
									<s:property value="#url.url" />
								</div>
							</div>
						</s:iterator>
					</div></td>
			</tr>
		</table>
		<div class="copyright">&copy; 2014 互联网信息技术有限公司</div>
	</s:form>
</body>