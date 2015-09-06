package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.entity.NeUser;
import cn.service.dao.NeUserDao;
import cn.service.dao.impl.NeUserDaoImpl;

public class SideMenuSer extends HttpServlet {
	public SideMenuSer() {
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
		
		//权限，超级管理员和普通管理员的权限
		HttpSession session  = request.getSession();
		String adminName = session.getAttribute("adminName")!= null ?session.getAttribute("adminName").toString():null;
		NeUserDao neUserDao = new NeUserDaoImpl();
		NeUser uList =null;
		if(adminName!=null){
			uList = neUserDao.select(adminName);
		}
		request.setAttribute("uList",uList);
		request.getRequestDispatcher("admin/sideMenu.jsp").forward(request, response);
		
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
