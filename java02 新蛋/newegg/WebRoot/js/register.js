// JavaScript Document

//根据 id 获取元素
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	var serviceCount = 0;
	$("service").onclick = function(){
		if(serviceCount%2==0){
			serviceOpen();  
		}else{
			serviceClose();
		}
		serviceCount++;
    };
	//开机加载验证码图片，让它马上显示
	createCodeOnclick();

	//验证码图片
	$("createCode").onclick = function(){
		createCodeOnclick();
	};
	//换一张
	$("newCode").onclick = function(){
		createCodeOnclick();
	};
	
	//用户名验证
	$("username").onfocus = function(){
		usernameOnfocus();
	};
	$("username").onblur = function(){
		usernameOnblur(this);
	};
	
	//密码验证
	$("password").onfocus = function(){
		passwordOnfocus();
	};
	$("password").onblur = function(){
		passwordOnblur(this);
	};
	
	//确认密码
	$("password2").onfocus = function(){
		password2Onfocus();
	};
	$("password2").onblur = function(){
		password2Onblur(this);
	};
	
	//验证码
	$("code").onfocus = function(){
		codeOnfocus();
	};
	$("code").onblur = function(){
		codeOnblur(this);
	};
	
	//提交表单
	document.registerForm.onsubmit = function(){
		return check();
	};  
};


//客户服务菜单打开
function serviceOpen(){
	var service = $("service");
	var service2 = $("service2");
	service.style.backgroundColor='#fff';
	service.style.backgroundImage="url(images/chooseHover.jpg)";
	service2.style.display='block';
}

//客户服务菜单关闭
function serviceClose(){
	var service = $("service");
	var service2 = $("service2");
	service.style.backgroundColor='#f1f1f1';
	service.style.backgroundImage="url(images/choose.jpg)"; 
	service2.style.display='none';
}


var code;
//验证码图片
function createCodeOnclick(){
	code = "";
	var codeLength = 4;//验证码的长度
	var checkCode = $("createCode");
	var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符
	for(var i=0;i<codeLength;i++)
	{
		var charIndex = Math.floor(Math.random()*36);
		code +=selectChar[charIndex];
	}
	if(checkCode)
	{
		checkCode.value = code;
	}
}


//用户名验证
function usernameOnfocus(){
	var username = $("username");
	username.style.border = "1px solid #ffbf00";
}
function usernameOnblur(obj){
	var username = $("username");
	var usernameId = $("usernameId");
	username.style.border = "1px solid #cfcfcf";
	if("" == obj.value){
		usernameId.innerHTML="用户名不能为空";
		usernameId.style.backgroundImage="url(images/err.jpg)";
		usernameId.style.backgroundRepeat="no-repeat";
		usernameId.style.backgroundPosition="15px 9px";
		usernameId.style.paddingLeft="30px";
		usernameId.style.color="#ff6600";
		return false;
	}
	var regUser = /^[a-zA-Z][a-zA-Z0-9._-]{3,17}$/; 
	if(regUser.test(obj.value)==false){
		usernameId.innerHTML="只能以字母开关，后面可以使用数字减号点等符号，且长度为4-18";
		usernameId.style.backgroundImage="url(images/err.jpg)";
		usernameId.style.backgroundRepeat="no-repeat";
		usernameId.style.backgroundPosition="15px 9px";
		usernameId.style.paddingLeft="30px";
		usernameId.style.color="#ff6600";
		return false;
	} 
	var username2 = null;
	var xmlHttp = new XMLHttpRequest();
	var url = "ajaxUser?username="+ escape(username.value);
	xmlHttp.open("POST", url);//设置一个请求
	xmlHttp.onreadystatechange = function() {	//设置请求完成之后处理的回调函数  
		if (xmlHttp.readyState == 4) {//数据返回完毕  
			if (xmlHttp.status == 200) {//HTTP操作正常  
				var text = xmlHttp.responseText;//接收返回的内容  
				if(text != null){
					usernameId.innerHTML = xmlHttp.responseText;
					usernameId.style.backgroundImage="url(images/err.jpg)";
					usernameId.style.backgroundRepeat="no-repeat";
					usernameId.style.backgroundPosition="15px 9px";
					usernameId.style.paddingLeft="30px";
					usernameId.style.color="#ff6600";
				}
			}
		}
	};
	xmlHttp.send(null);//发送请求，不传递任何参数  	
	usernameId.innerHTML="";
	usernameId.style.backgroundImage="none";
	return true;
}


//密码验证
function passwordOnfocus(){
	var password = $("password");
	password.style.border = "1px solid #ffbf00";
}
function passwordOnblur(obj){
	var password = $("password");
	var passwordId = $("passwordId");
	password.style.border = "1px solid #cfcfcf";
	if("" == obj.value){
		passwordId.innerHTML="密码不能为空";
		passwordId.style.backgroundImage="url(images/err.jpg)";
		passwordId.style.backgroundRepeat="no-repeat";
		passwordId.style.backgroundPosition="15px 9px";
		passwordId.style.paddingLeft="30px";
		passwordId.style.color="#ff6600";
		return false;
	}
	var regPwd = /^[a-zA-Z0-9]{6,16}$/;
	if(regPwd.test(obj.value)==false){
		passwordId.innerHTML="密码由英文字母和数字组成的6-16位字符";
		passwordId.style.backgroundImage="url(images/err.jpg)";
		passwordId.style.backgroundRepeat="no-repeat";
		passwordId.style.backgroundPosition="15px 9px";
		passwordId.style.paddingLeft="30px";
		passwordId.style.color="#ff6600";
		return false;
	} 
	passwordId.innerHTML="";
	passwordId.style.backgroundImage="none";
	return true;
}

//确认密码
function password2Onfocus(){
	var password2 = $("password2");
	password2.style.border = "1px solid #ffbf00";
}
function password2Onblur(obj){
	var password2 = $("password2");
	var password2Id = $("password2Id");
	password2.style.border = "1px solid #cfcfcf";
	if("" == obj.value){
		password2Id.innerHTML="确认密码不能为空";
		password2Id.style.backgroundImage="url(images/err.jpg)";
		password2Id.style.backgroundRepeat="no-repeat";
		password2Id.style.backgroundPosition="15px 9px";
		password2Id.style.paddingLeft="30px";
		password2Id.style.color="#ff6600";
		return false;
	}
	if(obj.value != $("password").value){
		password2Id.innerHTML="两次输入的密码不一致，请重新输入";
		password2Id.style.backgroundImage="url(images/err.jpg)";
		password2Id.style.backgroundRepeat="no-repeat";
		password2Id.style.backgroundPosition="15px 9px";
		password2Id.style.paddingLeft="30px";
		password2Id.style.color="#ff6600";
		return false;
	} 
	password2Id.innerHTML="";
	password2Id.style.backgroundImage="none";
	return true;
}


//验证码
function codeOnfocus(){
	var code = $("code");
	code.style.border = "1px solid #ffbf00";
}
function codeOnblur(obj){
	var code = $("code");
	var codeId = $("codeId");
	code.style.border = "1px solid #cfcfcf";
	if("" == obj.value){
		codeId.innerHTML="验证码不能为空";
		codeId.style.backgroundImage="url(images/err.jpg)";
		codeId.style.backgroundRepeat="no-repeat";
		codeId.style.backgroundPosition="15px 9px";
		codeId.style.paddingLeft="30px";
		codeId.style.color="#ff6600";
		return false;
	}
	if(obj.value != $("createCode").value){
		codeId.innerHTML="验证码不正确";
		codeId.style.backgroundImage="url(images/err.jpg)";
		codeId.style.backgroundRepeat="no-repeat";
		codeId.style.backgroundPosition="15px 9px";
		codeId.style.paddingLeft="30px";
		codeId.style.color="#ff6600";
		return false;
	}
	codeId.innerHTML="";
	codeId.style.backgroundImage="none";
	return true;
}

//提交表单
function check(){
	var username = usernameOnblur($("username"));
	var password = passwordOnblur($("password"));
	var password2 = password2Onblur($("password2"));
	var code = codeOnblur($("code"));
	if(username && password && password2 && code){
		return true;
	}
	return false;
}