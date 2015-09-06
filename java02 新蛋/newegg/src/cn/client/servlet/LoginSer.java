package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.client.dao.NeUserDao;
import cn.client.dao.impl.NeUserDaoImpl;

public class LoginSer extends HttpServlet {
	public LoginSer() {
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
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		boolean flag = true;
		if(uname==null || uname.equals("")){//没有数据则进入本页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			NeUserDao neUserDao = new NeUserDaoImpl();
			int count = neUserDao.login(uname, upass);
			//成功进入首页
			if(count==1){
				request.getSession().setAttribute("username", uname);
				response.sendRedirect("index");  
			}else{//失败提醒
				flag = false;
				request.setAttribute("flag",flag);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		//关闭输出流  
		out.flush();  
		out.close(); 
	}
	public void init() throws ServletException {
	}
}
