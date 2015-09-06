<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<title>标准信息列表</title>
<style type="text/css">  
*{ margin:0; padding:0; }  
body{ font-family:"宋体"; color:#333; font-size:14px; background:#fff;}  
a{ color:#069; text-decoration:underline;}  
a:hover{ color:#f60; text-decoration:underline;}  
h3{ text-align:center; line-height:40px;}  
table{ margin:0 auto; line-height:23px;}  
table tr th{ background:#B8860B;}  
table tr td{ padding:0 8px;}  
table .tdBg td{ background:#999}  
</style>  
<script type="text/javascript">
	function $(id) {
		return document.getElementById(id);
	}
	//全选  
	function checkAll(val) {
		var arr = document.getElementsByName("stdIds");
		//循环全选和非全选  
		for ( var i = 0; i < arr.length; i++) {
			arr[i].checked = val;
		}
	}
	//删除多行  
	function delRow() {
		var stdIds = document.getElementsByName("stdIds");
		var count = 0;
		var arr = new Array();
		for ( var i = 0; i < stdIds.length; i++) {
			if (stdIds[i].checked == true) {
				arr[count] = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择你要删除的行");
		} else {
			if (confirm("你确定要删除第" + arr + "条吗？")) {
				for ( var i = 0; i < arr.length; i++) {
					//调用 ajax
					ajaxDelete(stdIds[arr[i]].value);
				}
				alert("删除成功");
				window.location.href="toList.action";
			}
		}
	}
	//删除 ajax
	function ajaxDelete(stdIdsVal) {
		var xmlHttp = new XMLHttpRequest();
		var url = "toDelete.action?stdIds=" + escape(stdIdsVal);
		xmlHttp.open("GET", url);//设置一个请求  
		xmlHttp.onreadystatechange = function() { //设置请求完成之后处理的回调函数    
			if (xmlHttp.readyState == 4) {//数据返回完毕    
				if (xmlHttp.status == 200) {//HTTP操作正常    
					var text = xmlHttp.responseText;//接收返回的内容    
					if (text != null && text != "") {
						alert(text);
					}
				}
			}
		};
		xmlHttp.send(null);//发送请求，不传递任何参数    
	}
</script>
</head>
<body>
	<div style=" border: 1px solid #333; padding: 8px; width: 780px; margin: 0 auto;">
		<h3>标准信息列表</h3>
		<form action="toList.action" method="post">
			<table border="1" align="center">
				<tr>
					<td colspan="7"><input type="text" name="stdNum"> <input
						type="submit" value="提交检索"> <input type="button"
						onclick="window.open('toAdd.action')" value="新增标准"> <input
						type="button" onclick="delRow();" value="删除标准"></td>
				</tr>
				<tr>
					<th><input type="checkbox" onclick="checkAll(this.checked)">
					</th>
					<th>标准号</th>
					<th>中文名称</th>
					<th>版本</th>
					<th>发布日期</th>
					<th>实施日期</th>
					<th>操作</th>
				</tr>
				<s:iterator value="Standards" status="st">
					<tr <s:if test="#st.even">class="tdBg"</s:if>>
						<td><input type="checkbox" name="stdIds"
							value="<s:property value='stdId'/>" /></td>
						<td><a
							href="toUpdate.action?stdId=<s:property value='stdId'/>"><s:property
									value="stdId"></s:property>
						</a>
						</td>
						<td><s:property value="stdNum"></s:property>
						</td>
						<td><s:property value="zhname"></s:property>
						</td>
						<td><s:date name="releaseDate" format="yyyy-MM-dd"></s:date>
						</td>
						<td><s:date name="implDate" format="yyyy-MM-dd"></s:date>
						</td>
						<td><a
							href="toUpdate.action?stdId=<s:property value='stdId'/>">修改</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="7"><a href="toList.action?pageIndex=1">首页</a>| <a
						href="toList.action?pageIndex=<s:property value='pageIndex-1'/>">上一页</a>|
						<a
						href="toList.action?pageIndex=<s:property value='pageIndex+1'/>">下一页</a>|
						<a href="toList.action?pageIndex=<s:property value='pagecount'/>">末页</a>
						&nbsp;&nbsp; 第<s:property value="pageIndex" />页/共<s:property
							value="pagecount" />页</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
