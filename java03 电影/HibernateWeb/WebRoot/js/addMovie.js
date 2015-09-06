// JavaScript Document
/*
//根据 id 获取元素
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){	
	//电影名称
	$("name").onfocus = function(){
		nameOnfocus();
	};
	$("name").onblur = function(){
		nameOnblur(this);
	};
	
	//电影类型
	$("typeid").onfocus = function(){
		typeidOnfocus();
	};
	$("typeid").onblur = function(){
		typeidOnblur(this);
	};
	
	//价格
	$("price").onfocus = function(){
		priceOnfocus();
	};
	$("price").onblur = function(){
		priceOnblur(this);
	};
	
	//提交表单前验证
	document.addMovieForm.onsubmit = function(){
		return check();
	};  
};



//电影名称
function nameOnfocus(){
	var name = $("name");
	name.style.border = "1px solid #C00";
}
function nameOnblur(obj){
	var name = $("name");
	var nameId = $("nameId");
	if("" == obj.value){
		name.style.border = "1px solid #C00";
		nameId.innerHTML="*不能为空";
		return false;
	}
	nameId.innerHTML="";
	name.style.border = "1px solid #333";
	return true;
}

//电影类型
function typeidOnfocus(){
	var typeid = $("typeid");
	typeid.style.border = "1px solid #C00";
}
function typeidOnblur(obj){
	var typeid = $("typeid");
	var typeidId = $("typeidId");
	if("0" == obj.value){
		typeid.style.border = "1px solid #C00";
		typeidId.innerHTML="*请选择";
		return false;
	}
	typeidId.innerHTML="";
	typeid.style.border = "1px solid #333";
	return true;
}

//价格
function priceOnfocus(){
	var price = $("price");
	price.style.border = "1px solid #C00";
}
function priceOnblur(obj){
	var price = $("price");
	var priceId = $("priceId");
	if(50 >= obj.value){
		price.style.border = "1px solid #C00";
		priceId.innerHTML="*不得低于50元";
		return false;
	}
	priceId.innerHTML="";
	price.style.border = "1px solid #333";
	return true;
}

//提交表单前验证
function check(){
	var name = nameOnblur($("name"));
	var typeid = typeidOnblur($("typeid"));
	var price = priceOnblur($("price"));
	if(name && typeid && price){
		return true;
	}
	return false;
}
*/
