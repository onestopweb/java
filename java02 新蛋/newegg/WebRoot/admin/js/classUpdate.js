//JavaScript Document

function ajaxClassifyUpdate(productsClassifyId,obj){
	var xmlHttp = new XMLHttpRequest();
	var url = "ajaxClassUpdate?productsClassifyId="+escape(productsClassifyId)+"&classifyContent="+encodeURI(encodeURI(obj.value));
	xmlHttp.open("GET", url);//设置一个请求
	xmlHttp.onreadystatechange = function() {	//设置请求完成之后处理的回调函数  
		if (xmlHttp.readyState == 4) {//数据返回完毕  
			if (xmlHttp.status == 200) {//HTTP操作正常  
				var text = xmlHttp.responseText;//接收返回的内容  
				alert(text);
			}
		}
	};
	xmlHttp.send(null);//发送请求，不传递任何参数  	
}

function ajaxBrandUpdate(productsBrandId,obj){
	var xmlHttp = new XMLHttpRequest();
	var url = "ajaxBrandUpdate?productsBrandId="+escape(productsBrandId)+"&brandContent="+encodeURI(encodeURI(obj.value));
	xmlHttp.open("GET", url);//设置一个请求
	xmlHttp.onreadystatechange = function() {	//设置请求完成之后处理的回调函数  
		if (xmlHttp.readyState == 4) {//数据返回完毕  
			if (xmlHttp.status == 200) {//HTTP操作正常  
				var text = xmlHttp.responseText;//接收返回的内容  
				alert(text);
			}
		}
	};
	xmlHttp.send(null);//发送请求，不传递任何参数  	
}
