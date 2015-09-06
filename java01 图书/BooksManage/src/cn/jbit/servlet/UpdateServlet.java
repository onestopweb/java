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

public class UpdateServlet extends HttpServlet {
	public UpdateServlet() {
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
		//接收 name
		String name = request.getParameter("name");
		//接收 author
		String author = request.getParameter("author");
		//接收 time
		String time = request.getParameter("time");
		//接收 type
		String type = request.getParameter("type");
		//封装数据到 BookManage 对象中
		BookManage item = new BookManage(Integer.parseInt(id),name,author,time,type);
		//向下转型
		BookManageDao dao = new BookManageDaoImpl();
		//根据修改结果返回提示
		if(dao.update(item)>0){
			//添加成功给出提示，返回列表页面
			out.print("<script>alert('修改图书成功');location.href='search';</script>");
		}else{
			//添加失败给出提示，返回添加面
			out.print("<script>alert('修改图书失败');history.back();</script>");
		}
		//关闭输出流
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用 doGet() 方法，使其同步
		doGet(request, response);
	}
	public void init() throws ServletException {
	}

}
