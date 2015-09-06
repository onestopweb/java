<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改页面</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<style type="text/css">
table {
	margin: 40px auto 0 auto;
}
table tr * {
	line-height: 21px;
	padding: 0 6px;
}
table input[type="submit"] {
	margin-left: 40px;
}
table input[type="reset"] {
	margin-left: 20px;
}
</style>
<script type="text/javascript">
	//根据 id 获取元素
	function $(id) {
		return document.getElementById(id);
	}
	//开机加载
	window.onload = function() {
		//为表单注入 onsubmit 事件
		document.updateForm.onsubmit = function() {
			return check();
		};
	};
	//提交表单前验证
	function check() {
		var mname = $("mname");
		var mage = $("mage");
		if ("" == mname.value || "" == mage.value) {
			alert("会员姓名、性别和年龄不能为空");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<form action="index" method="post" name="updateForm">
		<table border="1" bgcolor="#33FFFF">
			<tr>
				<th colspan="2">会员信息<input type="hidden" name="mid"
					value="${membersInfo.mid }" />
				</th>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" value="${membersInfo.mname }"
					name="mname" id="mname" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<c:if test="${membersInfo.mgender eq '男' }">
					<input type="radio" value="男" name="mgender" checked="checked" />男
					<input type="radio" value="女" name="mgender" />女
					</c:if>
					<c:if test="${membersInfo.mgender ne '男' }">
					<input type="radio" value="男" name="mgender" />男
					<input type="radio" value="女" name="mgender" checked="checked"  />女
					</c:if>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" value="${membersInfo.mage }" name="mage"
					id="mage" /></td>
			</tr>
			<tr>
				<td>家庭地址</td>
				<td><input type="text" value="${membersInfo.maddress }"
					name="maddress" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" value="${membersInfo.memail }"
					name="memail" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改" /><input
					type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>

