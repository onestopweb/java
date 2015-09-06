package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.MembersInfo;

import biz.MembersInfoBiz;
import biz.impl.MembersInfoBizImpl;

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

		MembersInfoBiz membersInfoBiz = new MembersInfoBizImpl();
		// 获取当前的页数，如果为空则访问第一页
		String pageIndexStr = request.getParameter("pageIndex");
		int pageIndex = pageIndexStr != null ? Integer.parseInt(pageIndexStr)
				: 1;

		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mgender = request.getParameter("mgender");
		String mage = request.getParameter("mage");

		// 为“更改信息成功”作一个标记
		Boolean flag = false;
		// id、姓名、性别以及年龄不为空，则插入一条数据
		if (mid != null && mname != null && mgender != null && mage != null) {
			String maddress = request.getParameter("maddress");
			String memail = request.getParameter("memail");
			MembersInfo membersInfo = new MembersInfo(Integer.parseInt(mid),
					mname, mgender, Integer.parseInt(mage), maddress, memail);
			membersInfoBiz.update(membersInfo);
			// 修改标记
			flag = true;
		}

		// 分页列表，每页显示四条信息
		List<MembersInfo> membersInfos = membersInfoBiz.getMembersInfoByPage(
				pageIndex, 4);

		request.setAttribute("flag", flag);
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("membersInfos", membersInfos);

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
