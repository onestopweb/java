package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.dao.NeUserDao;
import cn.service.dao.impl.NeUserDaoImpl;

public class AjaxUserNewSer extends HttpServlet {
	public AjaxUserNewSer() {
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
		
		//Ajax 验证用户是否存在
		String userId = request.getParameter("userId");
		NeUserDao neUserDao = new NeUserDaoImpl();
		int count = neUserDao.ajaxUser(userId);
		if(count == 0){
			out.println("(必填)通过");
		}else{
			out.println("(必填)该姓名已经存在");
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
