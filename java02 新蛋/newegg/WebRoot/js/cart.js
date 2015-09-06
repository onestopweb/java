// JavaScript Document

//根据 id 获取元素
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	$("allCheckBox").onclick = function(){
		allCheckBoxOnclick(this.checked);
	};
	calcSum();
};

//全选与非全选的效果
function allCheckBoxOnclick(val){
	var arr = document.getElementsByName("cartCheckVal");
	for(var i=0;i<arr.length;i++){
		arr[i].checked = val;
	}
}

function saveSql(id,statusId,number){
	var xmlHttp = new XMLHttpRequest();
	var url = "ajaxSave?id="+escape(id)+"&statusId="+escape(statusId)+"&number="+escape(number);
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
};

