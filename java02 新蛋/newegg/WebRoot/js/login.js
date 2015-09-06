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
	
	//用户名验证
	$("username").onfocus = function(){
		onfocusUsername();
	};
	$("username").onblur = function(){
		onblurUsername(this);
	};
	
	//密码验证
	$("password").onfocus = function(){
		onfocusPassword();
	};
	$("password").onblur = function(){
		onblurPassword(this);
	};
	document.loginForm.onsubmit = function(){
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

//用户名验证
function onfocusUsername(){
	var username = $("username");
	username.style.border = "1px solid #ffbf00";
}
function onblurUsername(obj){
	var username = $("username");
	var usernameId = $("usernameId");
	username.style.border = "1px solid #cfcfcf";
	if("" == obj.value){
		usernameId.innerHTML="请输入正确的用户名";
		usernameId.style.backgroundImage="url(images/err.jpg)";
		usernameId.style.backgroundRepeat="no-repeat";
		usernameId.style.backgroundPosition="84px 5px";
		usernameId.style.color="#ff6600";
		return false;
	}
	usernameId.innerHTML="";
	usernameId.style.backgroundImage="none";
	return true;
}


//密码验证
function onfocusPassword(){
	var password = $("password");
	password.style.border = "1px solid #ffbf00";
}
function onblurPassword(obj){
	var password = $("password");
	var passwordId = $("passwordId");
	password.style.border = "1px solid #cfcfcf";
	if("" == obj.value){
		passwordId.innerHTML="请输入正确的密码";
		passwordId.style.backgroundImage="url(images/err.jpg)";
		passwordId.style.backgroundRepeat="no-repeat";
		passwordId.style.backgroundPosition="84px 5px";
		passwordId.style.color="#ff6600";
		return false;
	}
	passwordId.innerHTML="";
	passwordId.style.backgroundImage="none";
	return true;
}

//失败提示 servlet
function failureOfTips(){
	var passwordId = $("passwordId");
	passwordId.innerHTML="请输入正确的用户名和密码。";
	passwordId.style.backgroundImage="url(images/err.jpg)";
	passwordId.style.backgroundRepeat="no-repeat";
	passwordId.style.backgroundPosition="84px 5px";
	passwordId.style.color="#ff6600";
}


function check(){
	var username = onblurUsername($("username"));
	var password = onblurPassword($("password"));
	if(username && password){
		return true;
	}
	return false;
}




