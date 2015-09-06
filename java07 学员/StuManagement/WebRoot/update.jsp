<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
*{ margin:0; padding:0; }
body{ font-family:"宋体"; color:#333; font-size:14px; background:#fff;}
h3{ text-align:center; line-height:40px;}
table{ margin:0 auto; line-height:23px;}
table input[type="text"]{ border:1px solid #333; height:18px; line-height:18px; padding-left:6px;}
table select{ border:1px solid #333; }
</style>
<script type="text/javascript">
//根据 id 获取元素  
function $(id) {  
	return document.getElementById(id);  
}
//开机加载  
window.onload = function() {  
	//为表单注入 onsubmit 事件  
	document.updatedForm.onsubmit = function() {  
	return check();  
	};  
};  
//提交表单前验证  
function check() {  
	var sname = $("sname");  
	var birthday = $("birthday"); 
	var telephone = $("telephone");
	var email = $("email");
	 
	if ("" == sname.value || "" == birthday.value|| "" == telephone.value|| "" == email.value) {  
    	alert("姓名，生日，电话和E-mail不能为空");  
		return false;  
	}  
	var regEmail = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;  
    if(regEmail.test(email.value)==false){
    	alert("电子邮箱格式不正确，请重新输入");  
        return false;  
    }
	return true;  
}  
</script>
<title>修改学员信息</title>
</head>
<body>
<h3>修改学员信息</h3>
<s:form action="updated" method="post" name="updatedForm">
<table>
    <tr>
        <td><input type="hidden" name="student.id" value="<s:property value='student.id'/>"/>姓名</td>
        <td><input type="text" name="student.sname" id="sname" value="<s:property value='student.sname'/>" /></td>
    </tr>
     <tr>
        <td>性别</td>
        <td>
        	 <s:if test='student.gender =="男"'>
				<input type="radio" value="男" name="student.gender" checked="checked" />男
				<input type="radio" value="女" name="student.gender" />女
			</s:if>
			<s:else>
				<input type="radio" value="男" name="student.gender" />男
				<input type="radio" value="女" name="student.gender" checked="checked"  />女
			</s:else>
        </td>
    </tr>
     <tr>
        <td>生日</td>
        <td><input type="text" name="student.birthday" id="birthday" value="<s:date name='student.birthday' format='yyyy-MM-dd' />" /></td>
    </tr>
     <tr>
        <td>电话</td>
        <td><input type="text" name="student.telephone" id="telephone" value="<s:property value='student.telephone'/>" /></td>
    </tr>
     <tr>
        <td>E-mail</td>
        <td><input type="text" name="student.email" id="email" value="<s:property value='student.email'/>" /></td>
    </tr>
     <tr>
        <td>班级</td>
        <td>
        	<select name="classId">
        		<s:iterator value="classesList">
        			<s:if test="student.classes.id == id">
        			<option value="<s:property value='id'/>" selected="selected"><s:property value="cname"/></option>
        			</s:if>
        			<s:else>
        				<option value="<s:property value='id'/>"><s:property value="cname"/></option>
        			</s:else>
        		</s:iterator>
            </select>
        </td>
    </tr>
    <tr><td colspan="2" style="text-align:center"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" /></td></tr>
</table>
</s:form>
</body>
</html>
