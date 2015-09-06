// JavaScript Document
//根据 id 获取元素
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	setInterval("time()",1000);
};

function time(){
	var now = new Date(); //创建一个日期对象
	var hour = $("hour"); //时
	var minute = $("minute"); //分
	var second = $("second"); //秒
	if((24 - now.getHours())<10){
		hour.innerHTML="0"+(24 - now.getHours());
	}else{
		hour.innerHTML=24 - now.getHours();
	}
	if((60 - now.getMinutes())<10){
		minute.innerHTML="0"+(60 - now.getMinutes());
	}else{
		minute.innerHTML=60 - now.getMinutes();
	}
	if((60- now.getSeconds())<10){
		second.innerHTML="0"+(60- now.getSeconds());
	}else{
		second.innerHTML=60- now.getSeconds();
	}
}























