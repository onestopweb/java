package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Movie;
import bean.MovieCondition;
import bean.Type;
import biz.MovieBiz;
import biz.impl.MovieBizImpl;

public class ShowListSer extends HttpServlet {
	public ShowListSer() {
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
		MovieBiz movieBiz = new MovieBizImpl();
		// 获取查询条件
		String titile = request.getParameter("titile");
		// 模糊查找关键字
		titile = "%" + titile + "%";
		String typeid = request.getParameter("typeid");
		String actor = request.getParameter("actor");
		actor = "%" + actor + "%";
		String director = request.getParameter("director");
		director = "%" + director + "%";
		String minPrice = request.getParameter("minPrice");
		String maxPrice = request.getParameter("maxPrice");
		// 根据id获取type类型
		Type type = movieBiz.getTypeById(Integer.parseInt(typeid));
		MovieCondition condition = new MovieCondition(titile, director, actor,
				Double.parseDouble(minPrice), Double.parseDouble(maxPrice),
				type);
		List<Movie> movies = movieBiz.searchMovie(condition);
		// 绑定Movies
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("showList.jsp").forward(request, response);
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
