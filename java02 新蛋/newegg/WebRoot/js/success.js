// JavaScript Document
//根据 id 获取元素
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	onloadStyle();
	$("share1").onmousemove = function(){
		shareClose();
		var share1 = $("share1");
		share1.style.backgroundColor="#ffffff";
		share1.style.fontWeight="bold";
		share1.style.borderLeft="1px solid #eed9be";
		share1.style.borderRight="1px solid #eed9be";
		share1.style.borderTop="1px solid #eed9be";
		share1.style.borderBottom="1px solid #fff";
	};
	$("share2").onmousemove = function(){
		shareClose();
		var share2 = $("share2");
		share2.style.backgroundColor="#ffffff";
		share2.style.fontWeight="bold";
		share2.style.borderLeft="1px solid #eed9be";
		share2.style.borderRight="1px solid #eed9be";
		share2.style.borderTop="1px solid #eed9be";
		share2.style.borderBottom="1px solid #fff";
	};
	$("share3").onmousemove = function(){
		shareClose();
		var share3 = $("share3");
		share3.style.backgroundColor="#ffffff";
		share3.style.fontWeight="bold";
		share3.style.borderLeft="1px solid #eed9be";
		share3.style.borderRight="1px solid #eed9be";
		share3.style.borderTop="1px solid #eed9be";
		share3.style.borderBottom="1px solid #fff";
	};
	$("share4").onmousemove = function(){
		shareClose();
		var share1 = $("share4");
		share4.style.backgroundColor="#ffffff";
		share4.style.fontWeight="bold";
		share4.style.borderLeft="1px solid #eed9be";
		share4.style.borderRight="1px solid #eed9be";
		share4.style.borderTop="1px solid #eed9be";
		share4.style.borderBottom="1px solid #fff";
	};
};

function shareClose(){
	for(var i=1; i<=4; i++){
		document.getElementById("share"+i).style.backgroundColor="#ebf5f6"; 
		document.getElementById("share"+i).style.borderLeft="1px solid #e7ddd4";
		document.getElementById("share"+i).style.borderRight="1px solid #e7ddd4";
		document.getElementById("share"+i).style.borderTop="1px solid #e7ddd4";
		document.getElementById("share"+i).style.borderBottom="1px solid #eed9be";
		document.getElementById("share"+i).style.fontWeight="normal";
	}
}
function onloadStyle(){
	shareClose();
	var share1 = $("share1");
	share1.style.backgroundColor="#ffffff";
	share1.style.fontWeight="bold";
	share1.style.borderLeft="1px solid #eed9be";
	share1.style.borderRight="1px solid #eed9be";
	share1.style.borderTop="1px solid #eed9be";
	share1.style.borderBottom="1px solid #fff";
}
