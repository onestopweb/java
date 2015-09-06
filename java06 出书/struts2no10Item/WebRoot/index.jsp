<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.ddd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- easyui配置 -->
		<link rel="stylesheet" href="script/themes/default/easyui.css" type="text/css" />
		<link rel="stylesheet" href="script/themes/icon.css" type="text/css" />
		<script type="text/javascript" src="script/jquery.min.js"></script>
		<script type="text/javascript" src="script/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="script/easyui-lang-zh_CN.js"></script>
		<!-- book的Css和JS -->
		<link rel="stylesheet" href="style/book.css" type="text/css" />
		<script type="text/javascript" src="script/book.js"></script>
		<title>书籍操作</title>
	</head>

	<body>
		<div id="main">
			<table id="bookbody">
			</table>
		</div>
		<!-- 编辑数据的div，默认看不到 -->
		<div id="divEdit">
				<div id="tabEdit">
					<form id="frmEdit" method="post">
					<input type="hidden" id="id" name="book.id" />
					<dl>
						<dd>
							ISBN:
						</dd>
						<dd>
							<input type="text" size="15" id="isbn" name="book.isbn" />
						</dd>
					</dl>
					<dl>
						<dd>
							书名:
						</dd>
						<dd>
							<input type="text" size="40" id="title" name="book.title" />
						</dd>
					</dl>
					<dl>
						<dd>
							价格￥:
						</dd>
						<dd>
							<input type="text" size="10" id="price" name="book.price" />
						</dd>
					</dl>
					<dl>
						<dd>
							出版日期:
						</dd>
						<dd>
							<input type="text" style="width: 150px" id="pubdate" name="book.pubdate" />
						</dd>
					</dl>
					<dl>
						<dd>
							简介:
						</dd>
						<dd>
							<textarea cols="45" rows="3" id="intro" name="book.intro"></textarea>
						</dd>
					</dl>
					</form>
				</div>
		</div>
	</body>
</html>

