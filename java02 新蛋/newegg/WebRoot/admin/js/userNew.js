//JavaScript Document

function $(id){  
	return document.getElementById(id);  
} 

window.onload = function(){
	//管理员验证
	$("admin").onblur = function(){
		adminOnblur(this);
	};

	//密码验证
	$("adminPass").onblur = function(){
		adminPassOnblur(this);
	};

	//真实姓名验证
	$("name").onblur = function(){
		nameOnblur(this);
	};

	//手机验证
	$("phone").onblur = function(){
		phoneOnblur(this);
	};

	//给表单注册提交事件  
	document.adminForm.onsubmit = function(){  
		return check();
	};
};

function adminOnblur(obj){
	var adminId = $("adminId");
	if("" == obj.value){
		adminId.innerHTML="(必填)管理员账号不能为空";
		return false;
	}
	var regAdmin = /^[a-zA-Z][a-zA-Z0-9._-]{3,17}$/; 
	if(regAdmin.test(obj.value)==false){
		adminId.innerHTML="(必填)只能以字母开关,且长度为4-18";
		return false;
	}

	var xmlHttp = new XMLHttpRequest();
	var url = "ajaxUserNew?userId="+ escape(obj.value);
	xmlHttp.open("GET", url);//设置一个请求
	xmlHttp.onreadystatechange = function() {	//设置请求完成之后处理的回调函数  
		if (xmlHttp.readyState == 4) {//数据返回完毕  
			if (xmlHttp.status == 200) {//HTTP操作正常  
				var text = xmlHttp.responseText;//接收返回的内容 
				if(text != null){
					adminId.innerHTML= text;
				}
			}
		}
	};
	xmlHttp.send(null);//发送请求，不传递任何参数  
	return true;
}

function adminPassOnblur(obj){
	var adminPassId = $("adminPassId");
	if("" == obj.value){
		adminPassId.innerHTML="(必填)管理员密码不能为空";
		return false;
	}
	var regAdminPass = /^[a-zA-Z0-9]{6,16}$/;
	if(regAdminPass.test(obj.value)==false){
		adminPassId.innerHTML="(必填)密码由英文字母和数字组成的6-16位字符";
		return false;
	} 
	adminPassId.innerHTML="(必填)通过";
	return true;
}

function nameOnblur(obj){
	var nameId = $("nameId");
	if("" == obj.value){
		nameId.innerHTML="(必填)请输入正确的真实姓名";
		return false;
	}
	var regName = /^([\u4e00-\u9fa5]|\w+)+$/;  
	if(regName.test(obj.value)==false){  
		nameId.innerHTML ="(必填)只能由汉字或字母组成";  
		return false;  
	}     
	//把中文字符转换为两个字母，以计算字符长度  
	var len = obj.value.replace(/[\u4e00-\u9fa5]/g,"ab").length;  
	if(len<4 || len>20){   
		nameId.innerHTML ="(必填)长度为4-20个字符(一个汉字占两个字符)"; 
		return false;  
	}
	nameId.innerHTML="(必填)通过";
	return true;
}

function phoneOnblur(obj){
	var phoneId = $("phoneId");
	if("" == obj.value){
		phoneId.innerHTML="";
		return true;
	}  
	var regPhone = /^1(3|5|8)\d{9}$/;  
	if(regPhone.test(obj.value)==false){   
		phoneId.innerHTML ="手机号由11位数字组成，以13、15、18开头"; 
		return false;  
	}
	phoneId.innerHTML="通过";
	return true;
}


function check(){
	var admin = adminOnblur($("admin"));
	var adminPass = adminPassOnblur($("adminPass"));
	var name = nameOnblur($("name"));
	if(admin && adminPass && name ){
		return true;
	}
	return false;
}





