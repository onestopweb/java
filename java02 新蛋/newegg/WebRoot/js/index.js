// JavaScript Document

//根据 id 获取元素
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	//我的新蛋
	var myNeweggCount = 0;
	$("myNewegg").onclick = function(){
		if(myNeweggCount%2==0){
			myNeweggOpen();  
		}else{
			myNeweggClose();
		}
		myNeweggCount++;
    };
	//客户服务
	var serviceCount = 0;
	$("service").onclick = function(){
		if(serviceCount%2==0){
			serviceOpen();  
		}else{
			serviceClose();
		}
		serviceCount++;
    };
	//菜单
	var menuArea1Count = 0;
	$("menuArea1").onclick = function(){
		if(menuArea1Count%2==0){
			menuArea1Open();  
		}else{
			menuAreaClose();
		}
		menuArea1Count++;
    };
	
	var menuArea2Count = 0;
	$("menuArea2").onclick = function(){
		if(menuArea2Count%2==0){
			menuArea2Open();  
		}else{
			menuAreaClose();
		}
		menuArea2Count++;
    };
	
	var menuArea3Count = 0;
	$("menuArea3").onclick = function(){
		if(menuArea3Count%2==0){
			menuArea3Open();  
		}else{
			menuAreaClose();
		}
		menuArea3Count++;
    };
	
	var menuArea4Count = 0;
	$("menuArea4").onclick = function(){
		if(menuArea4Count%2==0){
			menuArea4Open();  
		}else{
			menuAreaClose();
		}
		menuArea4Count++;
    };
	
	var menuArea5Count = 0;
	$("menuArea5").onclick = function(){
		if(menuArea5Count%2==0){
			menuArea5Open();  
		}else{
			menuAreaClose();
		}
		menuArea5Count++;
    };
	//购物车
	var cartManageCount = 0;
	$("cartManage").onclick = function(){
		if(cartManageCount%2==0){
			cartManageOpen();  
		}else{
			cartManageClose();
		}
		cartManageCount++;
    };
	//收藏提醒
	var collectionManageCount = 0;
	$("collectionManage").onclick = function(){
		if(collectionManageCount%2==0){
			collectionManageOpen();  
		}else{
			collectionManageClose();
		}
		collectionManageCount++;
    };
	//换一行
	var changeCount = 1;
	$("change").onclick = function(){
		var changeHover1 = $("changeHover1");
		var changeHover2 = $("changeHover2");
		var changeHover3 = $("changeHover3");
		if(changeCount==1){
			changeHover3.style.display='none';
			changeHover1.style.display='none';
			changeHover2.style.display='block';
		}else if( changeCount==2){
			changeHover2.style.display='none';
			changeHover1.style.display='none';
			changeHover3.style.display='block';
		}else{
			changeHover3.style.display='none';
			changeHover2.style.display='none';
			changeHover1.style.display='block';
		}
		changeCount++;
		if(changeCount==4){
			changeCount=1;
		}
	};
	
	//推荐功能
	$("rPTop1").onmousemove = function(){
		//推荐功能 样式全部初始化
		rPTopClose();
		rPTop1.style.backgroundColor="#fff"; 
		rPTop1.style.color="#f60";
		rPTop1.style.borderBottom="1px solid #fff";
		rPCon1.style.display='block';
	};
	$("rPTop2").onmousemove = function(){
		rPTopClose();
		rPTop2.style.backgroundColor="#fff"; 
		rPTop2.style.color="#f60";
		rPTop2.style.borderBottom="1px solid #fff";
		rPCon2.style.display='block';
	};
	$("rPTop3").onmousemove = function(){
		rPTopClose();
		rPTop3.style.backgroundColor="#fff"; 
		rPTop3.style.color="#f60";
		rPTop3.style.borderBottom="1px solid #fff";
		rPCon3.style.display='block';
	};
	$("rPTop4").onmousemove = function(){
		rPTopClose();
		rPTop4.style.backgroundColor="#fff"; 
		rPTop4.style.color="#f60";
		rPTop4.style.borderBottom="1px solid #fff";
		rPCon4.style.display='block';
	};
	//手机•摄影 热销榜
	$("ranking01").onmousemove = function(){
		//热销榜 样式初始化
		ranking0Close();
		ranking01.style.backgroundColor="#fff";
		ranking01.style.fontWeight="bold";
		ranking01.style.color="#f60";
		ranking01.style.borderLeft="1px solid #d9d9d9"; 
		ranking01.style.borderTop="1px solid #d9d9d9";  
		ranking01.style.borderRight="1px solid #d9d9d9"; 
		ranking01.style.borderBottom="1px solid #fff"; 
		rankingHover01.style.display='block'; 
	};
	$("ranking02").onmousemove = function(){
		ranking0Close();
		ranking02.style.backgroundColor="#fff";
		ranking02.style.fontWeight="bold";
		ranking02.style.color="#f60";
		ranking02.style.borderLeft="1px solid #d9d9d9"; 
		ranking02.style.borderTop="1px solid #d9d9d9";  
		ranking02.style.borderRight="1px solid #d9d9d9"; 
		ranking02.style.borderBottom="1px solid #fff"; 
		rankingHover02.style.display='block'; 
	};
	$("ranking03").onmousemove = function(){
		ranking0Close();
		ranking03.style.backgroundColor="#fff";
		ranking03.style.fontWeight="bold";
		ranking03.style.color="#f60";
		ranking03.style.borderLeft="1px solid #d9d9d9"; 
		ranking03.style.borderTop="1px solid #d9d9d9";  
		ranking03.style.borderRight="1px solid #d9d9d9"; 
		ranking03.style.borderBottom="1px solid #fff"; 
		rankingHover03.style.display='block'; 
	};
	//电脑•平板 热销榜
	$("ranking11").onmousemove = function(){
		//热销榜 样式初始化
		ranking1Close();
		ranking11.style.backgroundColor="#fff";
		ranking11.style.fontWeight="bold";
		ranking11.style.color="#f60";
		ranking11.style.borderLeft="1px solid #d9d9d9"; 
		ranking11.style.borderTop="1px solid #d9d9d9";  
		ranking11.style.borderRight="1px solid #d9d9d9"; 
		ranking11.style.borderBottom="1px solid #fff"; 
		rankingHover11.style.display='block'; 
	};
	$("ranking12").onmousemove = function(){
		ranking1Close();
		ranking12.style.backgroundColor="#fff";
		ranking12.style.fontWeight="bold";
		ranking12.style.color="#f60";
		ranking12.style.borderLeft="1px solid #d9d9d9"; 
		ranking12.style.borderTop="1px solid #d9d9d9";  
		ranking12.style.borderRight="1px solid #d9d9d9"; 
		ranking12.style.borderBottom="1px solid #fff"; 
		rankingHover12.style.display='block'; 
	};
	$("ranking13").onmousemove = function(){
		ranking1Close();
		ranking13.style.backgroundColor="#fff";
		ranking13.style.fontWeight="bold";
		ranking13.style.color="#f60";
		ranking13.style.borderLeft="1px solid #d9d9d9"; 
		ranking13.style.borderTop="1px solid #d9d9d9";  
		ranking13.style.borderRight="1px solid #d9d9d9"; 
		ranking13.style.borderBottom="1px solid #fff"; 
		rankingHover13.style.display='block'; 
	};
	
	//排行榜的第一个样式
	onloadRanking();
};

//我的新蛋菜单打开
function myNeweggOpen(){
	var myNewegg = $("myNewegg");
	var myNewegg2 = $("myNewegg2");
	myNewegg.style.backgroundColor='#fff';
	myNewegg.style.backgroundImage="url(images/chooseHover.jpg)";
	myNewegg2.style.display='block';
}

//我的新蛋菜单关闭
function myNeweggClose(){
	var myNewegg = $("myNewegg");
	var myNewegg2 = $("myNewegg2");
	myNewegg.style.backgroundColor='#f1f1f1';
	myNewegg.style.backgroundImage="url(images/choose.jpg)"; 
	myNewegg2.style.display='none';
}

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

//menu 打开
function menuOpen(){
	var menu2 = $("menu2");
	menu2.style.display='block';
}

//menu 关闭
function menuClose(){
	var menu2 = $("menu2");
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	menu2.style.display='none';
	menuClass1.style.display='none';
	menuClass2.style.display='none';
	for(var i=1; i<=5; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#fff"; 
	}
}

//menuArea1
function menuArea1Open(){
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	for(var i=1; i<=5; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#f7f7f7"; 
	}
	menuClass2.style.display='none';
	menuArea1.style.backgroundColor='#fff';
	menuClass1.style.display='block';
}

//menuArea2
function menuArea2Open(){
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	for(var i=1; i<=5; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#f7f7f7"; 
	}
	menuClass1.style.display='none';
	menuArea2.style.backgroundColor='#fff';
	menuClass2.style.display='block';
}

//menuArea3
function menuArea3Open(){
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	for(var i=1; i<=5; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#f7f7f7"; 
	}
	menuClass2.style.display='none';
	menuArea3.style.backgroundColor='#fff';
	menuClass1.style.display='block';
}

//menuArea4
function menuArea4Open(){
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	for(var i=1; i<=5; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#f7f7f7"; 
	}
	menuClass1.style.display='none';
	menuArea4.style.backgroundColor='#fff';
	menuClass2.style.display='block';
}

//menuArea5
function menuArea5Open(){
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	for(var i=1; i<=5; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#f7f7f7"; 
	}
	menuClass2.style.display='none';
	menuArea5.style.backgroundColor='#fff';
	menuClass1.style.display='block';
}

//关闭所有的 menuAre
function menuAreaClose(){
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	for(var i=1; i<=6; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#f7f7f7"; 
	}
	menuClass2.style.display='none';
	menuClass1.style.display='none';
}

//购物车管理打开
function cartManageOpen(){
	var cartManage = $("cartManage");
	var cartManage2 = $("cartManage2");
	var cartManageSub = $("cartManageSub");
	var cartManageSub2 = $("cartManageSub2");
	cartManage2.style.display='block';
	cartManage.style.backgroundColor='#fff';
	cartManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImgHover.jpg)";
	cartManage.style.border="2px solid #ff6600";
	cartManage.style.borderBottom="none";
	cartManageSub.style.color="#767676";
	cartManageSub2.style.color="#f60";
	
	var collectionManage = $("collectionManage");
	var collectionManage2 = $("collectionManage2");
	var collectionManageSub = $("collectionManageSub");
	collectionManage2.style.display='none';
	collectionManage.style.backgroundColor='#ff6600';
	collectionManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImg.jpg)";
	collectionManage.style.border="2px solid #ff6600";
	collectionManage.style.borderBottom="none";
	collectionManageSub.style.color="#fff";
}

//购物车管理关闭
function cartManageClose(){
	var cartManage = $("cartManage");
	var cartManage2 = $("cartManage2");
	var cartManageSub = $("cartManageSub");
	var cartManageSub2 = $("cartManageSub2");
	cartManage2.style.display='none';
	cartManage.style.backgroundColor='#ff6600';
	cartManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImg.jpg)";
	cartManage.style.border="2px solid #ff6600";
	cartManage.style.borderBottom="none";
	cartManageSub.style.color="#fff";
	cartManageSub2.style.color="#ffb380";
	cartManageSub2.style.fontWeight="bold";
	cartManageSub2.style.fontFamily="Arial";
	
	var collectionManage = $("collectionManage");
	var collectionManage2 = $("collectionManage2");
	var collectionManageSub = $("collectionManageSub");
	collectionManage2.style.display='none';
	collectionManage.style.backgroundColor='#ff6600';
	collectionManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImg.jpg)";
	collectionManage.style.border="2px solid #ff6600";
	collectionManage.style.borderBottom="none";
	collectionManageSub.style.color="#fff";
}


//收藏管理打开
function collectionManageOpen(){
	var collectionManage = $("collectionManage");
	var collectionManage2 = $("collectionManage2");
	var collectionManageSub = $("collectionManageSub");
	collectionManage2.style.display='block';
	collectionManage.style.backgroundColor='#fff';
	collectionManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImgHover.jpg)";
	collectionManage.style.border="2px solid #ff6600";
	collectionManage.style.borderBottom="none";
	collectionManageSub.style.color="#767676";
	
	var cartManage = $("cartManage");
	var cartManage2 = $("cartManage2");
	var cartManageSub = $("cartManageSub");
	var cartManageSub2 = $("cartManageSub2");
	cartManage2.style.display='none';
	cartManage.style.backgroundColor='#ff6600';
	cartManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImg.jpg)";
	cartManage.style.border="2px solid #ff6600";
	cartManage.style.borderBottom="none";
	cartManageSub.style.color="#fff";
	cartManageSub2.style.color="#ffb380";
	cartManageSub2.style.fontWeight="bold";
	cartManageSub2.style.fontFamily="Arial";
}

//收藏管理关闭
function collectionManageClose(){
	var collectionManage = $("collectionManage");
	var collectionManage2 = $("collectionManage2");
	var collectionManageSub = $("collectionManageSub");
	collectionManage2.style.display='none';
	collectionManage.style.backgroundColor='#ff6600';
	collectionManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImg.jpg)";
	collectionManage.style.border="2px solid #ff6600";
	collectionManage.style.borderBottom="none";
	collectionManageSub.style.color="#fff";
	
	var cartManage = $("cartManage");
	var cartManage2 = $("cartManage2");
	var cartManageSub = $("cartManageSub");
	var cartManageSub2 = $("cartManageSub2");
	cartManage2.style.display='none';
	cartManage.style.backgroundColor='#ff6600';
	cartManage.style.backgroundImage="url(images/shoppingCartORcollectRemindImg.jpg)";
	cartManage.style.border="2px solid #ff6600";
	cartManage.style.borderBottom="none";
	cartManageSub.style.color="#fff";
	cartManageSub2.style.color="#ffb380";
	cartManageSub2.style.fontWeight="bold";
	cartManageSub2.style.fontFamily="Arial";
}

//推荐功能 样式全部初始化
function rPTopClose(){
	for(var i=1; i<=4; i++){
		document.getElementById("rPTop"+i).style.backgroundColor="#f6f6f6"; 
		document.getElementById("rPTop"+i).style.borderBottom="1px solid #d9d9d9"; 
		document.getElementById("rPTop"+i).style.color="#666";
		document.getElementById("rPCon"+i).style.display='none'; 
	}
}

//热销榜 样式初始化
function ranking0Close(){
	for(var i=1; i<=3; i++){
		document.getElementById("ranking0"+i).style.backgroundColor="#e9e9e9"; 
		document.getElementById("ranking0"+i).style.borderBottom="1px solid #e9e9e9"; 
		document.getElementById("ranking0"+i).style.color="#666";
		document.getElementById("ranking0"+i).style.fontWeight="normal";
		document.getElementById("rankingHover0"+i).style.display='none'; 
	}
}
function ranking1Close(){
	for(var i=1; i<=3; i++){
		document.getElementById("ranking1"+i).style.backgroundColor="#e9e9e9"; 
		document.getElementById("ranking1"+i).style.borderBottom="1px solid #e9e9e9"; 
		document.getElementById("ranking1"+i).style.color="#666";
		document.getElementById("ranking1"+i).style.fontWeight="normal";
		document.getElementById("rankingHover1"+i).style.display='none'; 
	}
}

//排行榜的第一个样式
function onloadRanking(){
	var ranking11 = $("ranking11");
	ranking11.style.backgroundColor="#fff";
	ranking11.style.fontWeight="bold";
	ranking11.style.color="#f60";
	ranking11.style.borderLeft="1px solid #d9d9d9"; 
	ranking11.style.borderTop="1px solid #d9d9d9";  
	ranking11.style.borderRight="1px solid #d9d9d9"; 
	ranking11.style.borderBottom="1px solid #fff";
	var ranking01 = $("ranking01");
	ranking01.style.backgroundColor="#fff";
	ranking01.style.fontWeight="bold";
	ranking01.style.color="#f60";
	ranking01.style.borderLeft="1px solid #d9d9d9"; 
	ranking01.style.borderTop="1px solid #d9d9d9";  
	ranking01.style.borderRight="1px solid #d9d9d9"; 
	ranking01.style.borderBottom="1px solid #fff"; 	
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