// JavaScript Document

//根据 id 获取元素
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	var myNeweggCount = 0;
	var serviceCount = 0;
	var menuCount = 0;
	$("myNewegg").onclick = function(){
		if(myNeweggCount%2==0){
			myNeweggOpen();  
		}else{
			myNeweggClose();
		}
		myNeweggCount++;
    };
	$("service").onclick = function(){
		if(serviceCount%2==0){
			serviceOpen();  
		}else{
			serviceClose();
		}
		serviceCount++;
    };
	$("menu").onclick = function(){
		if(menuCount%2==0){
			menuOpen();  
		}else{
			menuClose();
		}
		menuCount++;
    };
	$("menuArea1").onmousemove  = function(){
		menuArea1Onmousemove();
	};
	$("menuArea2").onmousemove  = function(){
		menuArea2Onmousemove();
	};
	$("menuArea3").onmousemove  = function(){
		menuArea3Onmousemove();
	};
	$("menuArea4").onmousemove  = function(){
		menuArea4Onmousemove();
	};
	$("menuArea5").onmousemove  = function(){
		menuArea5Onmousemove();
	};
	
	var cartManageCount = 0;
	$("cartManage").onclick = function(){
		if(cartManageCount%2==0){
			cartManageOpen();  
		}else{
			cartManageClose();
		}
		cartManageCount++;
    };
	
	var collectionManageCount = 0;
	$("collectionManage").onclick = function(){
		if(collectionManageCount%2==0){
			collectionManageOpen();  
		}else{
			collectionManageClose();
		}
		collectionManageCount++;
    };
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
function menuArea1Onmousemove(){
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
function menuArea2Onmousemove(){
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
function menuArea3Onmousemove(){
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
function menuArea4Onmousemove(){
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
function menuArea5Onmousemove(){
	var menuClass1 = $("menuClass1");
	var menuClass2 = $("menuClass2");
	for(var i=1; i<=5; i++){
		document.getElementById("menuArea"+i).style.backgroundColor="#f7f7f7"; 
	}
	menuClass2.style.display='none';
	menuArea5.style.backgroundColor='#fff';
	menuClass1.style.display='block';
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
