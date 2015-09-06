package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.dao.ProductsBrandDao;
import cn.service.dao.impl.ProductsBrandDaoImpl;

public class AjaxBrandUpdateSer extends HttpServlet {
	public AjaxBrandUpdateSer() {
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

		//修改品牌的Ajax
		ProductsBrandDao productsBrandDao = new ProductsBrandDaoImpl();
		java.net.URLDecoder urlDecoder = new java.net.URLDecoder();  
		String productsBrandId = request.getParameter("productsBrandId");
		String brandContent = request.getParameter("brandContent");
		String brandContentStr = urlDecoder.decode(brandContent,"UTF-8");

		int count  = productsBrandDao.update(brandContentStr, Integer.parseInt(productsBrandId));
		if(count>0){
			out.println("品牌id"+productsBrandId+"修改成功");
		}else{
			out.println("品牌id"+productsBrandId+"修改失败");
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
