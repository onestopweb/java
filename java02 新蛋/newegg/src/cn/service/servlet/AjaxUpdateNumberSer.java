package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.dao.NeProductsDao;
import cn.service.dao.impl.NeProductsDaoImpl;

public class AjaxUpdateNumberSer extends HttpServlet {
	public AjaxUpdateNumberSer() {
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

		//修改库存数量Ajax
		String id = request.getParameter("id");
		String number = request.getParameter("number");
		NeProductsDao neProductsDao = new NeProductsDaoImpl();
		int count = neProductsDao.updateNumber(Integer.parseInt(id), Integer.parseInt(number));
		if(count>0){
			out.println("商品"+id+"库存数量修改成功");
		}else{
			out.println("商品"+id+"库存数量修改失败");
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
