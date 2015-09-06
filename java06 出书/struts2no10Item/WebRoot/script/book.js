// jQuery 起点
$(function(){
	//加载所有的书籍
	listBook();
	//日期加上日期控件
	$("#pubdate").datebox({
		required:true
	});
	//给文本框加上验证器
	$("#isbn").validatebox({
		required:true
	});
	//书名的验证
	$("#title").validatebox({
		required:true,
		missingMessage:'书名不能为空'
	});
	//价格用货币验证框
	$("#price").numberbox({
		required:true,
		min:5.5,
		max:9999,
		precision:2,
		missingMessage:'请输入价格'
	});
	//简介加验证
	$("#intro").validatebox({
		required:true
	});
});
//显示所有的书籍列表
function listBook(){
	$("#bookbody").datagrid({
		whidth:600,
		height:"auto",
		iconsCls:'icon-help',//表格左上角的图标样式
		title:'显示所有书籍',//表格标题
		url:'list.action',//访问服务器的地址，要求返回 JSON 对象
		rownumbers:true,//在最前面显示行号
		fitColumns:true,//自动适应列宽
		pagination:true,//在底部显示分页工具栏
		striped:true,//隔行变色
		singleSelect:true,//每次只选中一行
		loadMsg:'加载书籍列表，请稍候...',
		pageSize:5,//指定每页的大小，服务器要加上 page 属性和 total 属性
		remoteSort:true,//从服务器端排序，默认 true
		pageList:[3,5,10],//可以设置每页记录数的列表，服务器要加上 rows 属性
		idField:'id',//主键属性
		
		toolbar:[{//工具栏
			text:'添加',
			iconCls:'icon-add',//图标
			handler:function(){//处理函数
				addBook();
			}
		},{
			text:'删除',
			iconCls:'icon-cancel',//图标
			handler:function(){//处理函数
				deleteBook();
			}
		},{
			text:'编辑',
			iconCls:'icon-edit',//图标
			handler:function(){//处理函数
				editBook();
			}
		}],
		
		columns:[[{//注意 2 个中括号
			field:'isbn',//实体类属性
			title:'ISBN',//显示的列标题
			width:70
		},{
			field:'title',
			title:'书籍名称',
			//可以排序，但服务器也完成相应的代码，要加入 sort 和 order 属性
			sortable:true
		},{
			field:'price',
			title:'价格',
			align:'right',
			width:60,
			sortable:true,
			formatter:function(value){
				return "$"+value;
			},
			styler:function(value,row,index){//自定义单元格样式
				if(value<80){
					return 'color:red;';
				}
			}
		},{
			field:'pubdate',
			title:'出版日期',
			sortable:true,
			formatter:function(value){
				return value.substring(0,10);
			}
		}]]
	});
};
//显示添加/编辑窗口
function showEditForm(){
	$("#tabEdit").dialog({
		modal:true,//模式窗口
		title:'书籍操作',
		iconCls:'icon-save',
		buttons:[{
			text:'确认',
			handler:function(){
				//进行表单字段验证，当全部字段都有效时返回 true 和 validatebox 一起使用
				if($("#tabEdit").form('validate')){
					//提交到服务器并写入数据库
					dealSave();
					//关闭窗口
					colseForm();
				}else{
					$.messager.alert('验证','书籍信息有误或不完整','error');
				}
			}
		},{
			text:'取消',
			handler:function(){
				colseForm();
			}
		}]
	});
}

//关闭窗口
function colseForm(){
	$("#frmEdit").form('clear');
	$("#tabEdit").dialog('close');
}

//添加的函数
function addBook(){
	//清空原有的数据
	$("#frmEdit").form('clear');
	//显示添加对话
	showEditForm();
}

//删除书籍
function deleteBook(){
	var book = $("#bookbody").datagrid('getSelected');//得到选中的一行数据
	//如果没有选中记录
	if(book == null){
		$.messager.alert('删除','请先选中要删除的书籍','info');
		return;
	}
	$.messager.confirm('确认','真的要删除选中的记录吗',function(r){
		if(r){
			var url='deleteBook.action?book.id='+book.id;
			//试一下 get 方法（地址，回调函数）
			$.get(url,function(operateSuccess){
				if(operateSuccess){
					$.messager.alert('删除','选中的书籍成功删除','info');
					//清除选中
					$("#bookbody").datagrid('unselectAll');
					//重新加载
					$("#bookbody").datagrid('reload');
				}else{
					$.messager.alert('删除','删除失败','warning');
				}
			});	
		}
	});
}

//在增加和更新时点确定按钮的处理函数
function dealSave(){
	//表单数据序列化一个字符串用 & 拼接
	var params = $("#frmEdit").serialize();
	//得到 ID 值，为空串表示添加
	if($("#id").val() == ""){
		$.post("addBook.action",params,function(operateSuccess){
			if(operateSuccess){
				$("#bookbody").datagrid("reload");//重新加载
				$.messager.alert('添加','添加成功','info');
			}else{
				$.messager.alert('添加','添加出现问题！','info');
			}
		});
	}else{
		//表示更新
		$.post("updateBook.action",params,function(operateSuccess){
			if(operateSuccess){
				$("#bookbody").datagrid("reload");//重新加载
				$.messager.alert('更新','更新成功','info');
			}else{
				$.messager.alert('更新','更新出现问题！','info');
			}
		});
	}
}

//编辑按钮的操作
function editBook(){
	var book = $("#bookbody").datagrid('getSelected');//得到选中的一行数据
	//如果没有选中记录
	if(book == null){
		$.messager.alert('书籍','请先选中要编辑的书籍','info');
		return;
	}
	$("#frmEdit").form('clear');
	//填充数据
	$("#id").val(book.id);
	$("#isbn").val(book.isbn);
	$("#title").val(book.title);
	//赋值方法不同
	$("#price").numberbox("setValue",book.price);
	//给默认方法不同
	$("#pubdate").datebox("setValue",book.pubdate.substring(0,10));
	//给默认值
	$("#intro").val(book.intro);
	//显示编辑页面
	showEditForm();
}
