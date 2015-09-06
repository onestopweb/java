package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.ProductsClassify;
import cn.service.dao.ProductsBrandDao;
import cn.service.dao.ProductsClassifyDao;
import cn.service.dao.impl.ProductsBrandDaoImpl;
import cn.service.dao.impl.ProductsClassifyDaoImpl;

public class ClassNewSer extends HttpServlet {
	public ClassNewSer() {
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

		//新增分类和品牌
		ProductsBrandDao productsBrandDao = new ProductsBrandDaoImpl();
		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();
		List<ProductsClassify> pcList = productsClassifyDao.productsClassifyList();
		
		String productsClassify = request.getParameter("productsClassify");
		String productsClassifyId = request.getParameter("productsClassifyId");
		String productsBrand = request.getParameter("productsBrand");
		
		if(productsClassify != null){
			productsClassifyDao.insert(new String(request.getParameter("productsClassify").getBytes("ISO-8859-1"),"utf-8"));
		}
		
		if(productsClassifyId!=null && productsBrand!=null){
			productsBrandDao.insert(new String(request.getParameter("productsBrand").getBytes("ISO-8859-1"),"utf-8"), Integer.parseInt(productsClassifyId));
		}
		
		request.setAttribute("pcList",pcList);
		
		
		request.getRequestDispatcher("admin/classNew.jsp").forward(request, response);
		
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
