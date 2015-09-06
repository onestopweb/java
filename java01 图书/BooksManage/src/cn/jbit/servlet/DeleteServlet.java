package cn.jbit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.dao.BookManageDao;
import cn.jbit.dao.impl.BookManageDaoImpl;
import cn.jbit.entity.BookManage;

public class DeleteServlet extends HttpServlet {
	public DeleteServlet() {
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
		//接收 id
		String id = request.getParameter("id");
		//向下转型
		BookManageDao dao = new BookManageDaoImpl();
		//根据 id 删除数据
		dao.delete(Integer.parseInt(id));
		//location 跳转到 search 页面
		out.print("<script>location.href='search';</script>");
		//关闭输出流
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用 doGet() 方法
		doGet(request, response);
	}
	public void init() throws ServletException {
	}
}
