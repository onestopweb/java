// JavaScript Document
function $(id){  
    return document.getElementById(id);  
} 

window.onload = function(){
	//省市区下拉菜单
	choose();
	
	//收货人验证
	$("consignee").onblur = function(){
		onblurConsignee(this);
	};
	
	//手机验证
	$("phone").onblur = function(){
		onblurPhone(this);
	};
	
	//电话验证
	$("tel").onblur = function(){
		onblurTel(this);
	};
	
	//地址验证
	$("address").onblur = function(){
		onblurAddress(this);
	};
	
	//邮政编码验证
	$("code").onblur = function(){
		onblurCode(this);
	};
	
	//邮箱验证
	$("email").onblur = function(){
		onblurEmail(this);
	};
	
	//省份验证
	$("selProvince").onblur = function(){
		onblurSelProvince(this);
	};
	
	//城市验证
	$("selCity").onblur = function(){
		onblurSelCity(this);
	};
	
	//区域验证
	$("selDist").onblur = function(){
		onblurSelDist(this);
	};
	
	//给表单注册提交事件  
    document.userForm.onsubmit = function(){  
		return check();
    };
	
	//给表单注册提交事件  
    document.successForm.onsubmit = function(){  
		return checkSuccess();
    };   
};

//收货人验证
function onblurConsignee(obj){
	var consigneeId = $("consigneeId");
	if("" == obj.value){
		consigneeId.innerHTML="请输入正确的收货人";
		consigneeId.style.backgroundImage="url(images/shop/err.jpg) ";
		consigneeId.style.backgroundRepeat="no-repeat";
		return false;
	}
	var regConsignee = /^([\u4e00-\u9fa5]|\w+)+$/;  
    if(regConsignee.test(obj.value)==false){  
        consigneeId.innerHTML ="只能由汉字或字母组成";  
		consigneeId.style.backgroundImage="url(images/shop/err.jpg) ";
		consigneeId.style.backgroundRepeat="no-repeat";
        return false;  
    }     
    //把中文字符转换为两个字母，以计算字符长度  
    var len = obj.value.replace(/[\u4e00-\u9fa5]/g,"ab").length;  
    if(len<4 || len>20){   
        consigneeId.innerHTML ="长度为4-20个字符(一个汉字占两个字符)"; 
		consigneeId.style.backgroundImage="url(images/shop/err.jpg) ";
		consigneeId.style.backgroundRepeat="no-repeat"; 
        return false;  
    }
	consigneeId.style.backgroundImage="none";  
	consigneeId.innerHTML="";
	return true;
}

//手机验证
function onblurPhone(obj){
	var phoneId = $("phoneId");
	if("" == obj.value){
		phoneId.innerHTML="请输入正确的手机号";
		phoneId.style.backgroundImage="url(images/shop/err.jpg) ";
		phoneId.style.backgroundRepeat="no-repeat";
		return false;
	}  
    var regPhone = /^1(3|5|8)\d{9}$/;  
    if(regPhone.test(obj.value)==false){   
        phoneId.innerHTML ="手机号由11位数字组成，以13、15、18开头"; 
		phoneId.style.backgroundImage="url(images/shop/err.jpg) ";
		phoneId.style.backgroundRepeat="no-repeat"; 
        return false;  
    }
	phoneId.style.backgroundImage="none";  
	phoneId.innerHTML="";
	return true;
}

//地址验证
function onblurAddress(obj){
	var addressId = $("addressId");
	if("" == obj.value){
		addressId.innerHTML="请输入正确的地址";
		addressId.style.backgroundImage="url(images/shop/err.jpg) ";
		addressId.style.backgroundRepeat="no-repeat";
		return false;
	}
	addressId.style.backgroundImage="none";  
	addressId.innerHTML="";
	return true;
}

//电话验证
function onblurTel(obj){
	var telId = $("telId");
	if("" == obj.value){
		telId.style.backgroundImage="none";  
		telId.innerHTML="";
		return true;
	}  
    var regTel = /^0\d{2,3}-?\d{7,8}$/;  
    if(regTel.test(obj.value)==false){   
        telId.innerHTML ="例如：020-12345678"; 
		telId.style.backgroundImage="url(images/shop/err.jpg) ";
		telId.style.backgroundRepeat="no-repeat"; 
        return false;  
    }
	telId.style.backgroundImage="none";  
	telId.innerHTML="";
	return true;
}

//邮政编码验证
function onblurCode(obj){
	var codeId = $("codeId");
	if("" == obj.value){
		codeId.innerHTML="请输入正确的地址";
		codeId.style.backgroundImage="url(images/shop/err.jpg) ";
		codeId.style.backgroundRepeat="no-repeat";
		return false;
	}
	var regCode = /^[1-9][0-9]{5}$/;  
    if(regCode.test(obj.value)==false){   
        codeId.innerHTML ="邮政编码的验证(开头不能为0，共6位)"; 
		codeId.style.backgroundImage="url(images/shop/err.jpg) ";
		codeId.style.backgroundRepeat="no-repeat"; 
        return false;  
    }
	codeId.style.backgroundImage="none";  
	codeId.innerHTML="";
	return true;
}

//邮箱验证
function onblurEmail(obj){
	var emailId = $("emailId");
	if("" == obj.value){
		emailId.innerHTML="请输入正确的电子邮箱";
		emailId.style.backgroundImage="url(images/shop/err.jpg) ";
		emailId.style.backgroundRepeat="no-repeat";
		return false;
	}
	var regEmail = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;  
    if(regEmail.test(obj.value)==false){   
        emailId.innerHTML ="电子邮箱格式不正确，请重新输入"; 
		emailId.style.backgroundImage="url(images/shop/err.jpg) ";
		emailId.style.backgroundRepeat="no-repeat"; 
        return false;  
    }
	emailId.style.backgroundImage="none";  
	emailId.innerHTML="";
	return true;
}

//省份验证
function onblurSelProvince(obj){
	var chooseId = $("chooseId");
	chooseId.style.backgroundImage="none";  
	chooseId.innerHTML="";
	if("" == obj.value){
		chooseId.innerHTML="请选择省市区";
		chooseId.style.backgroundImage="url(images/shop/err.jpg) ";
		chooseId.style.backgroundRepeat="no-repeat";
		return false;
	}
	chooseId.style.backgroundImage="none";  
	chooseId.innerHTML="";
	return true;
}

//城市验证
function onblurSelCity(obj){
	var chooseId = $("chooseId");
	chooseId.style.backgroundImage="none";  
	chooseId.innerHTML="";
	if("" == obj.value){
		chooseId.innerHTML="请选择省市区";
		chooseId.style.backgroundImage="url(images/shop/err.jpg) ";
		chooseId.style.backgroundRepeat="no-repeat";
		return false;
	}
	chooseId.style.backgroundImage="none";  
	chooseId.innerHTML="";
	return true;
}

//区域验证
function onblurSelDist(obj){
	var chooseId = $("chooseId");
	chooseId.style.backgroundImage="none";  
	chooseId.innerHTML="";
	if("" == obj.value){
		chooseId.innerHTML="请选择省市区";
		chooseId.style.backgroundImage="url(images/shop/err.jpg) ";
		chooseId.style.backgroundRepeat="no-repeat";
		return false;
	}
	chooseId.style.backgroundImage="none";  
	chooseId.innerHTML="";
	return true;
}

//省市区下拉菜单
function choose(){
	var temp;
	var P = new Array();
	var C = new Array();
	var D = new Array();
	P = new Array("北京","上海","天津","重庆","广东","四川","浙江","贵州","辽宁","江苏","福建","河北","河南"," 吉林","黑龙江","山东","安徽","广西","海南","内蒙古","山西","宁夏","甘肃","陕西","青海","湖北","湖南"," 江西","云南","新疆","香港","澳门");
	/*北京    */ C[0] = new Array("北京");
	/*上海    */ C[1] = new Array("上海");
	/*天津    */ C[2] = new Array("天津");
	/*重庆    */ C[3] = new Array("重庆");
	/*广东    */ C[4] = new Array("广州","深圳","珠海","佛山","惠州","东莞","中山","江门","湛江","汕头");
	/*四川    */ C[5] = new Array("成都","自贡市","攀枝花","泸州");
	/*浙江    */ C[6] = new Array("杭州","宁波","嘉兴","绍兴","温州","金华","衢州","舟山","台州","丽水","湖州");
	/*贵州    */ C[7] = new Array("贵阳");
	/*辽宁    */ C[8] = new Array("沈阳","大连");
	/*江苏    */ C[9] = new Array("南京","苏州","南通","无锡","盐城","徐州","常州","连云港","常熟","扬州","镇江","泰州","昆山","吴江");
	/*福建    */C[10] = new Array("福州","厦门","泉州");
	/*河北    */C[11] = new Array("石家庄","唐山","邯郸","保定","廊坊","衡水","秦皇岛");
	/*河南    */C[12] = new Array("郑州","洛阳");
	/*吉林    */C[13] = new Array("长春","吉林");
	/*黑龙江  */C[14] = new Array("哈尔滨");
	/*山东    */C[15] = new Array("济南","青岛","威海","烟台","潍坊","日照","临沂","淄博");
	/*安徽    */C[16] = new Array("合肥","芜湖","马鞍山");
	/*广西    */C[17] = new Array("南宁","桂林","北海","柳州");
	/*海南    */C[18] = new Array("海南","三亚");
	/*内蒙古  */C[19] = new Array("呼和浩特","包头");
	/*山西    */C[20] = new Array("太原");
	/*宁夏    */C[21] = new Array("银川");
	/*甘肃    */C[22] = new Array("兰州");
	/*陕西    */C[23] = new Array("西安");
	/*青海    */C[24] = new Array("西宁");
	/*湖北    */C[25] = new Array("武汉","宜昌");
	/*湖南    */C[26] = new Array("长沙","株洲","湘潭");
	/*江西    */C[27] = new Array("南昌","赣州");
	/*云南    */C[28] = new Array("昆明");
	/*新疆    */C[29] = new Array("乌鲁木齐");
	/*香港    */C[30] = new Array("香港");
	/*澳门    */C[31] = new Array("澳门");
	/*台湾    */C[31] = new Array("台北");
	for(temp in C)
	{
		D[temp] = new Array();
	}
	/*北京    */D[0][0] = new Array("海淀区,朝阳区,东城区,西城区,崇文区,宣武区,丰台区,石景山,房山区,门头沟,通州区,顺义区,昌平区,密云区,怀柔区,延庆区,平谷区,大兴区,燕郊区");
	/*上海    */D[1][0] = new Array("黄浦区,卢湾区,徐汇区,徐家汇,长宁区,静安区,普陀区,闸北区,虹口区,杨浦区,宝山区,闵行区,嘉定区,浦东新区,松江区,金山区,青浦区,南汇区,奉贤区,崇明县");
	/*天津    */D[2][0] = new Array("和平,西青,北辰,大港,南开,河东,河西,河北,津南,红桥,塘沽,汉沽,东丽,宝坻,蓟县,武清,宁河,静海,开发区");
	/*重庆    */D[3][0] = new Array("南岸,渝北,万盛,大渡口,万州,北碚,沙坪坝,巴南,双桥,涪陵,江北,九龙坡,渝中");
	/*广州    */D[4][0] = new Array("荔湾,越秀,东山,天河,海珠,黄埔,芳村,白云,花都,番禺,东莞,广州经济技术开发区,从化,增城,萝岗,清远,南沙,佛山");
	/*深圳    */D[4][1] = new Array("福田,罗湖,南山,盐田,宝安,龙岗");
	/*珠海    */D[4][2] = new Array("斗门,横琴,金湾,香洲,坦洲");
	/*佛山    */D[4][3] = new Array("南海,顺德,三水,高明,禅城");
	/*惠州    */D[4][4] = new Array("博罗县,大亚湾区,惠城区,惠东县,惠阳区,龙门县,仲恺区");
	/*东莞    */D[4][5] = new Array("茶山,长安,常平,大朗,大岭山,道?,东城,东坑,凤岗,高?,莞城,洪梅,厚街,黄江,虎门,寮步,麻涌,南城,企石,桥头,清溪,沙 田,石碣,石龙,石排,松山湖,塘厦,万江,望牛墩,谢岗,樟木头,中堂");
	/*中山    */D[4][6] = new Array("东区,南区,西区,石岐区,南头镇,古镇镇,东凤镇,小榄镇,黄圃镇,三角镇,民众镇,阜沙镇,火炬区,港口镇,东升镇,横栏镇,沙溪镇,大涌镇,板芙镇,五桂山镇,南朗镇,三乡镇,神湾镇,坦洲镇");
	/*江门    */D[4][7] = new Array("新会区,蓬江区,江海区,台山市,恩平市,鹤山市,开平市");
	/*成都    */D[5][0] = new Array("青羊,锦江,金牛,武侯,成华,龙泉驿,青白江,高新区,金堂县,新都区,温江区,郫县,双流县,新津县,大邑县,都江堰市,崇州市,邛崃市,蒲江县,彭州市,高新西区,高新西区");
	/*杭州    */D[6][0] = new Array("上城,下城,西湖,拱墅,江干,滨江,余杭,萧山,富阳,桐庐,临安,淳安,建德");
	/*宁波    */D[6][1] = new Array("海曙,江东,江北,鄞州,镇海,北仑,慈溪,余姚,奉化,宁海,象山,高新区,东钱湖旅游度假区");
	/*嘉兴    */D[6][2] = new Array("嘉善,平湖,海盐,海宁,桐乡,秀洲,南湖,市区,经济开发区");
	/*绍兴    */D[6][3] = new Array("绍兴县,诸暨市,上虞市,新昌县,越城区,嵊州市");
	/*贵阳    */D[7][0] = new Array("云岩,南明,金阳新区,小河,花溪,乌当,白云,清镇,开阳,修文,息烽,小河片,金阳");
	/*沈阳    */D[8][0] = new Array("和平,沈河,皇姑,大东,铁西,苏家屯,东陵,新城子,于洪,新民,辽中,康平,法库,浑南新区,沈北新区");
	/*大连    */D[8][1] = new Array("西岗,中山,沙河口,甘井子,旅顺口,金州,开发区,高新园区,长兴岛,普兰店,瓦房店,庄河");
	/*南京    */D[9][0] = new Array("白下,秦淮,玄武,鼓楼,下关,建邺,江宁,六合,浦口,栖霞,雨花,大厂,溧水,高淳");
	/*苏州    */D[9][1] = new Array("园区,新区,平江,沧浪,金阊,虎丘,吴中,昆山,常熟,太仓,张家港,相城,吴江");
	/*南通    */D[9][2] = new Array("城东区,城南区,城北区,城中区,狼山区,天生港,唐闸区,观音山区,开发区,海安县,如皋市,如东县,通州,海门,启东市,海门市,港闸,崇川");
	/*无锡    */D[9][3] = new Array("崇安区,南长区,北塘区,新区,滨湖区,惠山区,马山区,锡山区,江阴市,宜兴市");
	/*盐城    */D[9][4] = new Array("盐城,东台,大丰,盐都,建湖,响水,阜宁,射阳,滨海");
	/*徐州    */D[9][5] = new Array("丰县,鼓楼,贾汪,金山桥开发区,沛县,邳州市,泉山,睢宁市,新城区,云龙,铜山区");
	/*常州    */D[9][6] = new Array("金坛,溧阳,戚区,天宁,武进,新北,钟楼");
	/*连云港  */D[9][7] = new Array();
	/*常熟    */D[9][8] = new Array();
	/*扬州    */D[9][9] = new Array("宝应市,广陵区,高邮市,邗江区,江都市,开发区,维扬区,仪征市");
	/*镇江    */D[9][10] = new Array("丹阳市,句容市,扬中市,丹徒区,京口区,润州区,镇江新区");
	/*泰州    */D[9][11] = new Array("城中区,城东区,城西区,城南区,城北区,高港区,泰兴市,姜堰市,兴化市,靖江市");
	/*昆山    */D[9][12] = new Array("巴城镇,淀山湖镇,花桥镇,锦溪镇,陆家镇,千灯镇,玉山镇,张浦镇,周市镇,周庄镇");
	/*福州    */D[10][0] = new Array("台江,鼓楼,仓山,晋安,马尾,闽侯县,长乐市");
	/*厦门    */D[10][1] = new Array("开元,湖里,思明,鼓浪屿,集美,杏林,海沧,同安,翔安,漳州,龙岩,泉州");
	/*泉州    */D[10][2] = new Array("丰泽区,安溪县,德化县,惠安县,晋江市,鲤城区,洛江区,南安市,泉港区,石狮市,永春县");
	/*石家庄  */D[11][0] = new Array("桥东,桥西,新华,裕华,长安,开发区,正定,平山,鹿泉市,栾城,藁城");
	/*唐山    */D[11][1] = new Array("曹妃甸工业区,丰南,丰润,高新区,古冶,海港开发区,汉沽管理区,开平,乐亭县,卢台开发区,路北,路南,滦南县,滦县,南堡开发区,迁安市,迁西县,唐海县,玉田县,遵化市");
	/*邯郸    */D[11][2] = new Array();
	/*保定    */D[11][3] = new Array();
	/*廊坊    */D[11][4] = new Array("安次,广阳,三河,霸州,香河,永清,固安,文安,大城,大厂");
	/*衡水    */D[11][5] = new Array("桃城区,深州市,冀州市,安平县,故城县,阜城县,景县,枣强县,武强县,饶阳县,开发区,武邑县,郊区");
	/*秦皇岛  */D[11][6] = new Array("北戴河,昌黎县,抚宁县,海港,卢龙县,青龙县,山海关");
	/*郑州    */D[12][0] = new Array("金水,中原,管城,二七,邙山,惠济,经济技术开发区,郑东新区");
	/*洛阳    */D[12][1] = new Array("涧西区,西工区,老城区,?河区,洛龙区,吉利区,偃师市,栾川县,孟津县,咸阳县,伊川县,宜阳县");
	/*长春    */D[13][0] = new Array("朝阳,宽城,二道,南关,绿园,双阳,其它,吉林地区,高新,经开,净月,汽开");
	/*吉林    */D[13][1] = new Array("昌邑区,船营区,龙潭区,丰满区,永吉县,舒兰市,磐石市,蛟河市,桦甸市,经开区,高新区");
	/*哈尔滨  */D[14][0] = new Array("道里,道外,南岗,动力,平房,香坊,太平,开发区,阿城,呼兰,松北");
	/*济南    */D[15][0] = new Array("市中,天桥,历下,槐荫,历城,长清,高新,济阳,平阴,商河,章丘");
	/*青岛    */D[15][1] = new Array("市南,市北,四方,李沧,崂山,城阳,黄岛,即墨市,胶州市,胶南市,平度市,莱西市,开发区");
	/*威海    */D[15][2] = new Array("环翠区,文登市,荣成市,乳山市,高区,经区");
	/*烟台    */D[15][3] = new Array("芝罘区,福山区,龙口市,莱阳市,莱州市,蓬莱市,招远市,莱山区,开发区,牟平区,栖霞市,海阳市,长岛县");
	/*潍坊    */D[15][4] = new Array("奎文,潍城,寒亭,坊子,寿光市,高新技术开发区,经济开发区");
	/*日照    */D[15][5] = new Array("东港");
	/*临沂    */D[15][6] = new Array("兰山");
	/*合肥    */D[16][0] = new Array("中市,东市,西市,郊区,庐阳区,包河区,瑶海区,蜀山区,高新区,新站区,经开区,政务区,滨湖新区");
	/*南宁    */D[17][0] = new Array("兴宁,青秀,西乡塘,江南,良庆,邕宁,桂林市,北海市,钦州市");
	/*桂林    */D[17][1] = new Array("秀峰区,叠彩区,象山区,七星区,雁山区,西城区,八里街区");
	/*北海    */D[17][2] = new Array("海城,银海,铁山港,合浦");
	/*海南    */D[18][0] = new Array("海口市,三亚市,文昌市,琼海市,万宁市,儋州市,东方市,五指山市,保亭县,洋浦经济开发区,其他,定安县,澄迈县");
	/*呼和浩特*/D[19][0] = new Array("回民,玉泉,新城,金川开发区,金桥开发区,金山开发区,如意开发区,赛罕,郊区,托克托,清水河,武川,和林格尔,土默特左旗");
	/*太原    */D[20][0] = new Array("杏花岭,小店,迎泽,尖草坪,万柏林,晋源,榆次");
	/*银川    */D[21][0] = new Array("城区,新城,兴庆区,金凤区,西夏区,永定县,贺兰县,灵武市");
	/*兰州    */D[22][0] = new Array("城关,七里河,西固,安宁,红古,永登,榆中,皋兰");
	/*西安    */D[23][0] = new Array("城北,城南,城东,城内,城西,高新,长安,临潼,蓝田,阎良,灞桥,咸阳");
	/*西宁    */D[24][0] = new Array("城中,城东,城西,城北,湟源,湟中,大通回族土族自治县");
	/*武汉    */D[25][0] = new Array("江汉,江岸,?口,汉阳,武昌,洪山,青山,东西湖,黄陂,江夏,阳逻,新洲,蔡甸,汉南,沌口");
	/*宜昌    */D[25][1] = new Array("夷陵区,西陵区,伍家岗区,点军区,?亭区,宜都市,当阳市,枝江市,东山开发区,远安县,兴山县,秭归县,长阳土家族自治县,五峰土家族自治县");
	/*长沙    */D[26][0] = new Array("岳麓,天心,雨花,开福,芙蓉,星沙,长沙经济开发区");
	/*南昌    */D[27][0] = new Array("东湖,西湖,青云谱,湾里,昌北,高新开发区,红谷滩,南昌县,青山湖,新建县,郊区,进贤,安义");
	/*昆明    */D[28][0] = new Array("盘龙区,五华区,官渡区,西山区,安宁,呈贡,其他,东川");
	/*乌鲁木齐*/D[29][0] = new Array("天山,沙伊巴克,新市,水磨沟,头屯河,南泉,东山");
	/*香港    */D[30][0] = new Array("北区,大埔去,东区,观塘区,黄大仙区,九龙城区,葵青区,离岛区,南区,沙田区,屯门区,湾仔区,西贡区,油尖旺区,元朗区,中西区,荃湾区");
	/*台北    */D[31][0] = new Array();
	///城市与省份的序列对应、每个城市与每个区域数组对应
	//创建城市对象，返回一个该城市所在省份及所拥有区域的对象
	function createCity(sCityName)
	{
		var oCity = new Object();
		oCity.province = "";
		oCity.city = sCityName;
		oCity.dist = new Array();
		oCity.pindex = -1;//所属省份在省份数组中的位置index
		oCity.cindex = -1;//城市在所属城市数组中的位置index（二者用来确定区域数组）
	   
		var m = -1;var n = -1;
		for(var i = 0; i < C.length; i++)
		{
			for(var j=0; j < C[i].length; j++)
			{
				if(C[i][j] == sCityName)
				{
					oCity.province = P[i];
					oCity.dist = D[i][j];
					oCity.pindex = i;
					oCity.cindex = j;
					break;
				}
			}
		   
			if(oCity.province != "")
			{
				break;
			}
		}
	   
		return oCity;
	}
	/*三级、省、市、区域*/
	/*面向对象*/
	function oMenu(selProvince,selCity,selDist)
	{
		///selProvince省份的select控件id
		///selCity城市的select控件id
		///selDist区域的select控件id
		this.oProvince = document.getElementById(selProvince);   
	   
		///城市变化，初始化区域
		function fnInitDist(city)
		{
			var objCity = createCity(city);
			var dist = objCity.dist.toString().split(',');
			ClearSelect(selDist,"请选择区域");
			InitSelect(selDist,dist,"");
		};
	   
		///初始化城市
		function fnInitCity(province)
		{ 
			for(var i = 0;i < P.length;i++)
			{
				if(P[i] == province)
				{
					ClearSelect(selCity,"请选择城市");
					InitSelect(selCity,C[i],"");
					ClearSelect(selDist,"请先选择城市");
					document.getElementById(selCity).onchange = function (){fnInitDist(this.value);};
					break;
				}
			}       
		};
	   
		///初始化省份
		this.fnInitProvince = function(){
			InitSelect(selProvince,P,"请选择省份");
			ClearSelect(selCity,"请先选择省份");
			ClearSelect(selDist,"请先选择城市");       
			this.oProvince.onchange = function (){fnInitCity(this.value);};
		};
	
	///初始化select控件
		function InitSelect(obj,aInitValue,sMenu)
		{
			///obj:要初始化的select控件对象的id
			///aInitValue:要初始化的数组值
			///sMenu:在select控件头部要添加的option，value为空；如果该参数为空，则只初始化aInitValue而不加头部
			if(sMenu != "")
			{
				document.getElementById(obj).options.add(new Option(sMenu,""));
			}
		   
			for(var i = 0; i < aInitValue.length; i++)
			{
				document.getElementById(obj).options.add(new Option(aInitValue[i],aInitValue[i]));
			}       
		}
	   
		function ClearSelect(obj,sMenu)
		{       
			document.getElementById(obj).options.length = 0;
			document.getElementById(obj).options.add(new Option(sMenu,""));       
		}   
	
	}
	
	var oMenu = new oMenu("selProvince","selCity","selDist");//select ID
		oMenu.fnInitProvince();
}

function check(){
	var consignee = onblurConsignee($("consignee"));
	var phone = onblurPhone($("phone"));
	var tel = onblurTel($("tel"));
	var address = onblurAddress($("address"));
	var code = onblurCode($("code"));
	var email = onblurEmail($("email"));
	var selProvince = onblurSelProvince($("selProvince"));
	var selCity = onblurSelCity($("selCity"));
	var selDist = onblurSelDist($("selDist"));
	if(consignee && phone && tel && address && code && email && selProvince && selCity && selDist){
		return true;
	}
	return false;
}
function checkSuccess(){
	var consigneeCon = $("consigneeCon").innerHTML;
	var addressCon = $("addressCon").innerHTML;
	var phoneCon = $("phoneCon").innerHTML;
	var codeCon = $("codeCon").innerHTML;
	var emailCon = $("emailCon").innerHTML;
	if(consigneeCon.length>1 && addressCon.length>6 && phoneCon.length>3 && codeCon.length>3 && emailCon.length>3){
		return true;
	}
	alert("你提交的资料不完整，请完备你的资料。");
	return false;
}
