package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Movie;
import biz.MovieBiz;
import biz.impl.MovieBizImpl;

public class IndexSer extends HttpServlet {
	public IndexSer() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收时设置的编码
		request.setCharacterEncoding("utf-8");
		// 转发时设置的编码
		response.setCharacterEncoding("utf-8");
		// 以 超文本格式 方式转发
		response.setContentType("text/html");
		// 获取了一个输出流
		PrintWriter out = response.getWriter();
		// 显示电影所有
		MovieBiz movieBiz = new MovieBizImpl();
		List<Movie> movies = movieBiz.getAll();
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
