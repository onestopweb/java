package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.client.dao.NeCommentDao;
import cn.client.dao.impl.NeCommentDaoImpl;

public class AjaxSelectCommentSer extends HttpServlet {
	public AjaxSelectCommentSer() {
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
		
		//查找用户是否评论过该商品 Ajax
		NeCommentDao neCommentDao = new NeCommentDaoImpl();
		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
		String id = request.getParameter("id"); 
		if(username!=null&&id!=null){
			int count = neCommentDao.selectComment(Integer.parseInt(id), username);
			if(count>0){
				out.print("你已经评论过该商品，不可以再评论");
			}
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
