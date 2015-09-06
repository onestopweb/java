<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/register.css" />
<script type="text/javascript" src="js/register.js"></script>
</head>

<body>
<div class="header">
	<div class="headerCon">
		<ul class="headerLeft f_l">
    		<li class="phone f_l"><a href="###">掌上新蛋</a></li>
        	<li class="customer f_l"><a href="###">企业客户</a></li>
        	<li class="platform f_l"><a href="###">入驻开放平台</a></li>
    	</ul>
    	<ul class="headerRight f_r">
        	<li class="welcome f_l">上午好,欢迎来新蛋购物！</li>
        	<li class="help f_l"><a href="###">帮助中心</a></li>
        	<li class="service f_l" id="service">客户服务</li>
    	</ul>
        <div class="service2" id="service2" style="display:none;"></div>
    </div>
</div>

<div class="searchbar">
	<div class="logo f_l"><a href="index" title="新蛋中国 - 全球领先的IT/数码网上购物商城-笔记本,电脑配件,数码相机,手机,办公设备,家电,百货"><img src="images/logo.jpg" width="322" height="65" /></a></div>
    <h3 class="f_l"><i>新用户注册</i></h3>
</div>

<div class="caption">
	<h3 class="f_l">邮箱注册</h3>
</div>

<div class="area">
	<div class="register f_l">
    	<form action="register" method="post" name="registerForm">
    	<p><span class="text f_l"><i class="f_r">用户名：</i></span><span class="inputText f_l"><input type="text" id="username" name="uname" /></span><span id="usernameId" class="f_l"></span></p>
        <p><span class="text f_l"><i class="f_r">输入密码：</i></span><span class="inputText f_l"><input type="password" id="password" name="upass" /></span><span id="passwordId" class="f_l"></span></p>
        <p><span class="text f_l"><i class="f_r">再次输入：</i></span><span class="inputText f_l"><input type="password" id="password2" /></span><span id="password2Id" class="f_l"></span></p>
        <p><span class="text f_l"><i class="f_r">验证码：</i></span><span class="inputText2 f_l"><input type="text" class="code f_l" id="code" /><input type="text" class="code2 f_l" readonly="readonly" id="createCode" /><a href="###" class="f_l" id="newCode">看不清楚，换一张</a></span><span class="f_l" id="codeId"></span></p>
        <p><span class="text f_l"></span><span class="submit"><input type="submit" value="同意以下协议并提交注册" /></span></p>
        </form>
        <textarea readonly="readonly">
在注册前，敬请您阅读以下内容，在进行注册程序过程中点击"同意以上协议并注册"按钮即表示您已完全接受本协议项下的全部条款。一经用户成功注册，本协议立即生效。如果发生纠纷，注册会员不得以未仔细阅读为由进行抗辩。
第一条 定义：
下列术语在本协议中具有以下含义：
1.1 新蛋网：由上海新蛋电子商务有限公司所有，域名为www.newegg.cn的在线电子商务交易平台。
1.2 新蛋：上海新蛋电子商务有限公司及其关联企业的统称。
1.3 关联企业：现在或将来与上海新蛋电子商务有限公司构成"一方控制、共同控制另一方或对另一方施加重大影响，以及两方或两方以上同受一方控制、共同控制或重大影响"的关系的企业。
1.4 注册会员（或会员）：完成在新蛋网的注册，通过新蛋网浏览、购买、使用新蛋产品或者服务的用户。
第二条 服务条款确认和接纳
2.1 本协议是注册会员与新蛋之间签署的协议，对双方均具有法律约束力。此份协议是注册会员接受新蛋产品和服务时适用的通用条款，用于规范双方各个交易环节的权利义务。本协议是处理双方权利义务的当然约定依据，除非违反国家强制性法律，否则始终有效。
2.2 注册会员应当具有相应的民事行为能力，注册后在新蛋网进行下单购物、评论等行为的同时，也同时承认了会员拥有购买这些产品、发表这些评论的权利能力和行为能力，能够独立承担法律责任，并且对会员订单中提供的所有信息的真实性负责。
2.3 如会员需要在新蛋网行使超出自身行为能力的权利，应当在监护人的监护参与下才能使用相关服务。
2.4 注册会员了解并同意：随着市场经营情况的变化，新蛋有权随时更改本注册会员协议及相关服务规则。修改本协议时，新蛋将于相关页面公告修改的事实，有权不对注册会员进行个别通知。注册会员应该不时关注新蛋网的相关公告，以便了解本协议及其他服务规则的变化。若注册会员不同意本协议或相关服务规则，或者不同意新蛋作出的修改，注册会员可以主动停止使用新蛋提供的产品和服务；如果在新蛋修改协议或服务规则后，注册会员仍继续使用新蛋提供的产品和服务，即表示注册会员同意新蛋对本协议及相关服务规则所做的所有修改。由于注册会员在注册会员协议变更后因未熟悉公告规定而引起的损失，新蛋将不会承担任何责任。
2.5 注册会员在使用新蛋提供的各项服务的同时，承诺接受并遵守各项相关条款的规定。
第三条 注册会员权利义务
3.1 注册会员一旦注册成功，即成为新蛋网的合法注册会员，有权接受新蛋网提供的各项服务，下单购买新蛋产品，并有权对新蛋产品做出评论。
3.2 注册会员应妥善保管已注册的会员账户信息，对注册会员名和密码安全承担全部责任，会员可随时根据需要改变会员密码。
3.3 为更好的接受新蛋网提供的产品和服务，会员应当提供详尽、准确的个人资料，并不时维护更新，符合及时、详尽、准确的要求。
3.4 注册会员应对以其注册会员名进行的所有活动和事件负全责。注册会员若发现任何非法使用注册会员帐户或存在安全漏洞的情况，请立即通告新蛋。
3.5 会员不得传输或发表：煽动抗拒、破坏宪法和法律、行政法规实施的言论，煽动颠覆国家政权，推翻社会主义制度的言论，煽动分裂国家、破坏国家统一的的言论，煽动民族仇恨、民族歧视、破坏民族团结的言论。
3.6 会员不得利用本站从事洗钱、窃取商业秘密、窃取个人信息等违法犯罪活动。
3.7 会员不得干扰本站的正常运转，不得侵入本站及国家计算机信息系统。
3.8 会员不得传输或发表任何违法犯罪的、骚扰性的、中伤他人的、辱骂性的、恐吓性的、伤害性的、庸俗的、淫秽的、不文明的等信息资料。不得传输或发表损害国家社会公共利益和涉及国家安全的信息资料或言论。
第四条 新蛋的权利义务
4.1 为会员提供网上购物平台，提供便利优质的购物环境和售前、售后服务。
4.2 保障和维护全体注册会员利益，并承诺做到保质量，保价格，保服务质量。
4.3 对注册会员的电子邮件、手机号等隐私资料进行保护。
4.4 对注册会员的电子邮件、手机号等隐私资料进行保护，承诺不会在未获得注册会员许可的情况下擅自将注册会员的个人资料信息出租或出售给任何第三方，但以下情况除外：
4.4.1 会员同意让第三方共享资料；
4.4.2 注册会员同意公开其个人资料，享受为其提供的产品和服务；
4.4.3 本站需要听从法庭传票、法律命令或遵循法律程序；
4.4.4 本站发现注册会员违反了本站服务条款或本站其它使用规定。
4.5 新蛋应尽最大努力保证您所购商品与新蛋网上公布的价格一致，但价目表和声明并不构成要约。新蛋有权在发现了网站上显现的产品及订单的明显错误或缺货的情况下，单方面撤回任何承诺。同时，本站保留对产品订购的数量的限制权。
4.6 定期通过页面公告及电子邮件方式向注册会员发送活动信息。
4.7 通过页面的公告向注册会员发布协议条款的修改、服务变更、或其它重要事件。
第五条 声明
5.1 关于价格和数量：产品的价格和可获性都在新蛋网上指明。这类信息将随时更改且不发任何通知。商品的价格都包含了增值税。如果发生了意外情况，在确认了会员的订单后，由于供应商提价，税额变化引起的价格变化，或是由于网站的错误等造成商品价格变化，会员有权取消该订单，并希望会员能及时通过电子邮件或电话通知新蛋客服部。
5.2 关于提供担保：注册会员个人对网络服务的使用承担风险。新蛋对此不作任何类型的担保，不论是明确的或隐含的，但是不对商业性的隐含担保、特定目的和不违反规定的适当担保作限制。新蛋不担保服务一定能满足注册会员的要求，也不担保服务不会受中断，对服务的及时性，安全性，出错发生都不作担保。本站对在本站上得到的任何商品购物服务或交易进程，不作担保。
5.3 有限责任：新蛋网对任何直接、间接、偶然、特殊及继起的损害不负责任，这些损害可能来自：不正当使用网络服务，在网上购买商品或进行同类型服务，在网上进行交易，非法使用网络服务或注册会员传送的信息有所变动。这些行为都有可能会导致本站的形象受损，所以本站事先提出这种损害的可能性。
5.4 关于本协议签订地：本协议签订于上海市嘉定区。
第六条 免责条款
6.1 如因不可抗力或其他新蛋无法控制的原因使新蛋销售系统崩溃或无法正常使用导致网上交易无法完成或丢失有关的信息、记录等，新蛋不承担责任。但是新蛋会尽可能合理地协助处理善后事宜，并努力使客户免受经济损失。
6.2 除了新蛋的使用条件中规定的其它限制和除外情况之外，在中国法律法规所允许的限度内，对于因交易而引起的或与之有关的任何直接的、间接的、特殊的、附带的、后果性的或惩罚性的损害，或任何其它性质的损害，新蛋及其董事、管理人员、雇员、代理或其它代表在任何情况下都不承担责任。新蛋的全部责任，不论是合同、保证、侵权（包括过失）项下的还是其它的责任，均不超过您所购买的与该索赔有关的商品价值额。
第七条 争议管辖及法律适用
7.1 本协议的订立、执行和解释及争议的解决均应适用中国法律。
7.2 本协议具有可分性，如发生本协议部分条款与中国法律相抵触时，则这些条款将完全按法律规定重新解释，而其它合法条款则依旧保持对注册会员产生法律效力和影响。
7.3 本协议的可分性还体现在如本协议任何规定被裁定为无效或不可执行，该规定可被删除而其余条款应予以执行。
7.4 如双方就本协议内容或其执行发生任何争议，双方应尽力友好协商解决；协商不成时，任何一方均可向本协议签订地有管辖权的人民法院提起诉讼。
        </textarea>
    </div>
    <div class="sidebar f_l">
    	<span class="span1">
        	<h3>已是新蛋会员</h3>
			<a href="login">现在登录</a>
        </span>
        <span class="span2">
        	<h3>注册即享受</h3>
			<p>正品行货、正规发票</p>
			<p>全国配送、当天出库</p>
        </span>
    </div>
</div>

<div class="iconAndEmail">
	<div class="icon">
    	<h3 class="f_l">关注我们：</h3>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon01.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">人人网</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon02.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">开心网</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon03.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">新浪微博</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon04.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">腾讯微博</a></dd>
        </dl>
        <dl class="f_l">
        	<dt class="f_l"><a href="###"><img src="images/icon05.jpg" width="18" height="18" /></a></dt>
            <dd class="f_l"><a href="###">优酷视频</a></dd>
        </dl>
    </div>
</div>

<div class="footer">
	<p class="footNav"><a href="###">关于我们</a>|<a href="###">联系我们</a>|<a href="###">人才招聘</a>|<a href="###">商家入驻</a>|<a href="###">广告服务</a>|<a href="###">手机新蛋</a>|<a href="###">友情链接</a>|<a href="###">销售联盟</a>|<a href="###">新蛋社区</a>|<a href="###">新蛋公益</a>|<a href="###">English Site</a></p>
    <p>北京市公安局朝阳分局备案编号110105014669&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;互联网药品信息服务资格证编号(京)-非经营性-2011-0034  |  新出发京零 字第大120007号</p>
    <p>音像制品经营许可证苏宿批005号&nbsp;&nbsp;|&nbsp;&nbsp;出版物经营许可证编号新出发(苏)批字第N-012号&nbsp;&nbsp;|&nbsp;&nbsp;互联网出版许可证编号新出网证(京)字150号</p>
    <p>网络文化经营许可证京网文[2011]0168-061号&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2004-2014&nbsp;&nbsp;新蛋newegg.com 版权所有</p>
    <p>新蛋旗下网站：360TOP</p>
    <span><a href="###"><img src="images/footer01.gif" width="108" height="40" /></a><a href="###"><img src="images/footer02.gif" width="108" height="40" /></a><a href="###"><img src="images/footer03.png" width="108" height="40" /></a><a href="###"><img src="images/footer04.png" width="112" height="40" /></a></span>
</div>

</body>
</html>
