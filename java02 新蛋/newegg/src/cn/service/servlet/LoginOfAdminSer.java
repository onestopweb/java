package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.dao.NeUserDao;
import cn.service.dao.impl.NeUserDaoImpl;


public class LoginOfAdminSer extends HttpServlet {
	public LoginOfAdminSer() {
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
		
		//后台登陆界面
		String inputAdmin = request.getParameter("inputAdmin");
		String inputPass = request.getParameter("inputPass");
		boolean flag = true;
		if(inputAdmin==null || inputAdmin.equals("")){//没有数据则进入本页面
			request.getRequestDispatcher("admin/loginOfAdmin.jsp").forward(request, response);
		}else{
			NeUserDao neUserDao = new NeUserDaoImpl();
			int count = neUserDao.loginOfAdmin(inputAdmin, inputPass);
			//成功进入后台管理页面
			if(count==1){
				request.getSession().setAttribute("adminName", inputAdmin);
				response.sendRedirect("admin");  
			}else{//失败提醒
				flag = false;
				request.setAttribute("flag",flag);
				request.getRequestDispatcher("admin/loginOfAdmin.jsp").forward(request, response);
			}
		}
		//关闭输出流  
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
