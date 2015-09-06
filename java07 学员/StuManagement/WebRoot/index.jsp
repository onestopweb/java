<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<title>学生信息列表</title>
</head>
<body>
<h3>学生信息列表</h3>
<table border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
        <th>电话</th>
        <th>E-mail</th>
        <th>班级</th>
    </tr>
    <s:iterator value="students" status="st"> 
    <tr <s:if test="#st.even">class="tdBg"</s:if>  ><!-- 隔行变色 -->
        <td><s:a href="selected.action?id=%{id}"><s:property value="id"/></s:a></td>
        <td><s:property value="sname"/></td>
        <td><s:property value="gender"/></td>
        <td><s:date name="birthday" format="yyyy-MM-dd" /></td>
        <td><s:property value="telephone"/></td>
        <td><s:property value="email"/></td>
        <td><s:property value="classes.cname"/></td>
    </tr>
    </s:iterator>
</table>
</body>
</html>

