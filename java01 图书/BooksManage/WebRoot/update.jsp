<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>修改图书</title>
<style type="text/css">
*{font-size:14px;font-family:"宋体";color:#333;line-height:24px;margin:0;}
div{width:420;margin:20px auto;;}
.addBook{font-size:22px;font-weight:bold;}
.text{height:22px;line-height:22px;border:1px #333 solid;}
select{border:1px #333 solid;}
</style>
</head>

<body>
	<div>
		<form action="update" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="id" value="${item.id }">
					</td>
					<td class="addBook">修改图书</td>
				</tr>
				<tr>
					<td>图书名称</td>
					<td><input type="text" name="name" id="name" class="text"
						value="${item.name}">
					</td>
				</tr>
				<tr>
					<td>图书作者</td>
					<td><input type="text" name="author" id="author" class="text"
						value="${item.author}">
					</td>
				</tr>
				<tr>
					<td>购买日期</td>
					<td><input type="text" name="time" id="time" class="text"
						value="${item.time}">
					</td>
				</tr>
				<tr>
					<td>图书类别</td>
					<td><select name="type" id="type">
							<option value="0">==请选择类别==</option>
							<option value="1"
								<c:if test="${item.type eq 1 }">selected="selected"</c:if>>计算机/软件</option>
							<option value="2"
								<c:if test="${item.type eq 2 }">selected="selected"</c:if>>小说/文摘</option>
							<option value="3"
								<c:if test="${item.type eq 3 }">selected="selected"</c:if>>杂项</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="btnAdd" value="修改图书"
						onclick="return checkInfo();" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		//验证方法
		function $(id) {
			return document.getElementById(id).value;
		}
		function checkInfo() {
			var name = $("name");
			var author = $("author");
			var time = $("time");
			var type = $("type");
			if (name == "" || author == "") {
				alert("图书名称和作者姓名不能为空");
				return false;
			} else {
				var reg = /^\d{4}-\d{2}-\d{2}$/;
				if (!reg.test(time)) {
					alert("时间格式错误");
					return false;
				} else if (type == "0") {
					alert("请选择图书分类");
					return false;
				}
			}
			return true;
		}
	</script>
</body>
</html>

