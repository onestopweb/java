// JavaScript Document

function $(id){  
    return document.getElementById(id);  
} 

function showSql(userId){
	var show = $("show");
	show.style.display='block';
	show.innerHTML="";
	var xmlHttp = new XMLHttpRequest();
	var url = "ajaxUserList?userId="+escape(userId);
	xmlHttp.open("GET", url);//设置一个请求
	xmlHttp.onreadystatechange = function() {	//设置请求完成之后处理的回调函数  
		if (xmlHttp.readyState == 4) {//数据返回完毕  
			if (xmlHttp.status == 200) {//HTTP操作正常  
				var text = xmlHttp.responseText;//接收返回的内容  
				show.innerHTML=text;
			}
		}
	};
	xmlHttp.send(null);//发送请求，不传递任何参数  	
}
