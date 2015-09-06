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
<head><title>内容图片上传</title></head>
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
	String ext = smart.getFiles().getFile(0).getFileExt() ;	// 扩展名称
	String fileName = its.getIPTimeRand() + "." + ext ;
	smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+"images/share"+java.io.File.separator + fileName) ;
	response.sendRedirect("../goodsUpdate?id="+id+"&productsContent="+fileName);  
%>
</body>
</html>