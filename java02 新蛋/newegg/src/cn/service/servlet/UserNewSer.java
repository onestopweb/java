package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.dao.NeUserDao;
import cn.service.dao.impl.NeUserDaoImpl;

public class UserNewSer extends HttpServlet {
	public UserNewSer() {
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
		//获取了一个输出流  
		PrintWriter out = response.getWriter(); 
		
		//创建用户
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		
		NeUserDao neUserDao = new NeUserDaoImpl();
		if(userId!=null){
			neUserDao.insert(userId, password, username, phone, 2);
		}
		
		request.getRequestDispatcher("admin/userNew.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}
}
