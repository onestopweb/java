package cn.jbit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.dao.BookManageDao;
import cn.jbit.dao.impl.BookManageDaoImpl;
import cn.jbit.entity.BookManage;

public class SearchServlet extends HttpServlet {
	public SearchServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用 doPost() 方法，使其同步
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
		//向下转型
		BookManageDao dao = new BookManageDaoImpl();
		//接收 id
		String id = request.getParameter("id");
		//没点击修改链接，则 id 为空
		if(id==null || id.equals("")){
			//查询所有图书列表
			List<BookManage> list = dao.list();
			//保存内容，和重新命名
			request.setAttribute("list",list);
			//进入list.jsp，request里有参数，response为转发
			request.getRequestDispatcher("list.jsp").forward(request, response);

		}else{
			//查询一个图书对象
			int bid = Integer.parseInt(id);
			//保存内容，和重新命名
			request.setAttribute("item", dao.select(bid));
			//进入update.jsp，request里有参数，response为转发
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		//关闭输出流
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}
}
