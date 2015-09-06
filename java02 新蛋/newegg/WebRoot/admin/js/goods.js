//JavaScript Document
function $(id){  
	return document.getElementById(id);  
} 

function ajaxBrandbyclassifyId(obj){
	var brand = $("brand");
	brand.innerHTML="";
	var xmlHttp = new XMLHttpRequest();
	var url = "ajaxBrandbyclassifyId?classifyId="+escape(obj.value);
	xmlHttp.open("GET", url);//设置一个请求
	xmlHttp.onreadystatechange = function() {	//设置请求完成之后处理的回调函数  
		if (xmlHttp.readyState == 4) {//数据返回完毕  
			if (xmlHttp.status == 200) {//HTTP操作正常  
				var text = xmlHttp.responseText;//接收返回的内容  
				brand.innerHTML= text;
			}
		}
	};
	xmlHttp.send(null);//发送请求，不传递任何参数  	
}

