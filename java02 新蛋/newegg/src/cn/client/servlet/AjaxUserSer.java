package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.client.dao.NeUserDao;
import cn.client.dao.impl.NeUserDaoImpl;

public class AjaxUserSer extends HttpServlet {
	public AjaxUserSer() {
		super();
	}
	public void destroy() {
		super.destroy();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//接收时设置的编码  
		request.setCharacterEncoding("utf-8");  
		//转发时设置的编码  
		response.setCharacterEncoding("utf-8");  
		//以 超文本格式 方式转发  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");  
		NeUserDao neUserDao = new NeUserDaoImpl();
		int count = neUserDao.ajaxUser(userName);
		if(count>0){  
			out.println("该用户已经使用");  
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}
}
