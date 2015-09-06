// JavaScript Document

function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	
	//管理员账号
	$("inputAdmin").value='请输入管理员账号';
	$("inputAdmin").onfocus = function(){
		inputAdminOnfocus();
	};
	$("inputAdmin").onblur = function(){
		inputAdminOnblur(this);
	};
	
	//管理员密码
	$("inputPass").onblur = function(){
		inputPassOnblur(this);
	};
	//给表单注册提交事件  
    document.adminForm.onsubmit = function(){  
		return check();
    };
	
};

function inputAdminOnfocus(){
	var inputAdmin = $("inputAdmin");
	if(inputAdmin.value=='请输入管理员账号'){
		inputAdmin.value="";
	}
}
function inputAdminOnblur(obj){
	var inputAdmin = $("inputAdmin");
	inputAdmin.style.border = "1px solid #b5b5b5";
	if("" == obj.value||"请输入管理员账号" == obj.value){
		inputAdmin.style.border = "1px solid #c00";
		inputAdmin.value='请输入管理员账号';
		return false;
	}
	inputAdmin.style.border = "1px solid #b5b5b5";
	return true;
}

function inputPassOnblur(obj){
	var inputPass = $("inputPass");
	inputPass.style.border = "1px solid #b5b5b5";
	if("" == obj.value){
		inputPass.style.border = "1px solid #c00";
		return false;
	}
	inputPass.style.border = "1px solid #b5b5b5";
	return true;
}

function failureOfTips(){
	var inputAdmin = $("inputAdmin");
	inputAdmin.style.border = "1px solid #c00";
	var inputPass = $("inputPass");
	inputPass.style.border = "1px solid #c00";
}

function check(){
	var inputAdmin = inputAdminOnblur($("inputAdmin"));
	var inputPass = inputPassOnblur($("inputPass"));
	if(inputAdmin && inputPass ){
		return true;
	}
	return false;
}