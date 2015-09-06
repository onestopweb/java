package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.dao.ProductsBrandDao;
import cn.service.dao.ProductsClassifyDao;
import cn.service.dao.impl.ProductsBrandDaoImpl;
import cn.service.dao.impl.ProductsClassifyDaoImpl;

public class AjaxClassUpdateSer extends HttpServlet {
	public AjaxClassUpdateSer() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//接收时设置的编码  
		request.setCharacterEncoding("utf-8");  
		//转发时设置的编码  
		response.setCharacterEncoding("utf-8");  
		//以 超文本格式 方式转发  
		response.setContentType("text/html");  
		//获取了一个输出流  
		PrintWriter out = response.getWriter();

		//修改分类的Ajax
		java.net.URLDecoder urlDecoder = new java.net.URLDecoder();     
		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();

		String productsClassifyId = request.getParameter("productsClassifyId");
		String classifyContent = request.getParameter("classifyContent");
		String classifyContentStr = urlDecoder.decode(classifyContent,"UTF-8");

		int count  = productsClassifyDao.update(classifyContentStr, Integer.parseInt(productsClassifyId));
		if(count>0){
			out.println("分类id"+productsClassifyId+"修改成功");
		}else{
			out.println("分类id"+productsClassifyId+"修改失败");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}

}
