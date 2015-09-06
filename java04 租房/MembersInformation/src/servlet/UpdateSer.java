package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.MembersInfo;

import biz.MembersInfoBiz;
import biz.impl.MembersInfoBizImpl;

public class UpdateSer extends HttpServlet {
	public UpdateSer() {
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

		// 获取id
		String mid = request.getParameter("mid");

		MembersInfoBiz membersInfoBiz = new MembersInfoBizImpl();
		// 根据 id 查询信息
		MembersInfo membersInfo = membersInfoBiz.getMembersInfoByMid(Integer
				.parseInt(mid));

		request.setAttribute("membersInfo", membersInfo);

		request.getRequestDispatcher("update.jsp").forward(request, response);

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
