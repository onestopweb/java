<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<title>网站收藏</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.3.2.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/styles.css">
<script type="text/javascript">
	function add() {
		window
				.open(
						'toAdd.action',
						'_blank',
						'height=600, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
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
								<td><a href="#" onclick="add();" style="font-weight:bold;">添加书签</a>
								</td>
							</tr>
							<tr>
								<td><a href="#" onclick="showTags(-1)">全部</a>
								</td>
							</tr>
							<tr>
								<td><a href="#" onclick="showTags(0)">未分类</a>
								</td>
							</tr>
							<s:iterator id="tag" value="tagList">
								<tr>
									<td><a href="javascript:showTags('${tag.name}')">${tag.name}</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td class="selected_label"><a style="font-weight:bold;"
									href="toCloud.action">云图</a>
								</td>
							</tr>
						</table>
					</div></td>
				<td>
					<!-- 右边fav内容 -->
					<div class="content_links" id="content">
						<div style="padding:30px;width:450px;font-family:verdana;">
							<s:iterator id="tag" value="tagList">
								<!-- 根据数量显示不同的class -->
								<a class="tag<s:property value="#tag.count"/>"
									href="toList.action?type=<s:property value='#tag.name'/>">
									<s:property value="#tag.name" />
								</a>&nbsp;
							</s:iterator>
						</div>
					</div></td>
			</tr>
		</table>
		<div class="copyright">&copy; 2014 互联网信息技术有限公司</div>
	</s:form>
</body>
