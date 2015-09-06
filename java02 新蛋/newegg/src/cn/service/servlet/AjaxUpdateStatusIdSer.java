package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.dao.NeCommentDao;
import cn.service.dao.impl.NeCommentDaoImpl;

public class AjaxUpdateStatusIdSer extends HttpServlet {

	public AjaxUpdateStatusIdSer() {
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
		
		//Ajax 修改评论状态
		String id = request.getParameter("id");
		String userId = request.getParameter("userId");
		String statusId = request.getParameter("statusId");
		NeCommentDao neCommentDao = new NeCommentDaoImpl();
		int count = neCommentDao.updateStatusId(Integer.parseInt(id), userId, Integer.parseInt(statusId));
		if(count>0){
			out.println("修改状态成功");
		}else{
			out.println("修改状态失败");
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
