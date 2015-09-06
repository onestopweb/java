<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.lxh.smart.*"%>
<%@ page import="cn.service.tool.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<base href="<%=basePath%>">
<head><title>产品图片上传</title></head>
<body>
<%
	response.setCharacterEncoding("utf-8");  
%>
<%
	SmartUpload smart = new SmartUpload() ;
	smart.initialize(pageContext) ;	// 初始化上传操作
	smart.upload() ;			// 上传准备
	String id = smart.getRequest().getParameter("uid") ;
	SmartUploadTool its = new SmartUploadTool(request.getRemoteAddr()) ;	// 取得客户端的IP地址
	String fileName = null;
	String fileName2 = null;
	for(int x=0;x<smart.getFiles().getCount();x++){
		String ext = smart.getFiles().getFile(x).getFileExt() ;	// 扩展名称
		if(x==0){
			fileName = its.getIPTimeRand() + "." + ext ;
			smart.getFiles().getFile(x).saveAs(this.getServletContext().getRealPath("/")+"images/share"+java.io.File.separator + fileName) ;
		}else{
			fileName2 = its.getIPTimeRand() + "." + ext ;
			smart.getFiles().getFile(x).saveAs(this.getServletContext().getRealPath("/")+"images/share"+java.io.File.separator + fileName2) ;
		}
	}
	response.sendRedirect("../goodsUpdate?id="+id+"&print="+fileName+"&picture="+fileName2);  
%>
</body>
</html>