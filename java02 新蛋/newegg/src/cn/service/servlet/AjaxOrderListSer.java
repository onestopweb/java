package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.User;
import cn.service.biz.UserBiz;
import cn.service.biz.impl.UserBizImpl;

public class AjaxOrderListSer extends HttpServlet {
	public AjaxOrderListSer() {
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

		//查看单条和修改订单showAjax
		String userId = request.getParameter("userId");
		UserBiz userBiz = new UserBizImpl();
		User userItem = userBiz.select(userId);

		out.println("<table cellpadding=\"0\" cellspacing=\"0\">");
		out.println("    <tr class=\"explain\">");
		out.println("        <td colspan=\"8\">订单内容详情</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">用户编号</td>");
		out.println("        <td class=\"value\">"+userItem.getUser_id()+"</td>");
		out.println("        <td class=\"key\">用户姓名</td>");
		out.println("        <td class=\"value\">"+userItem.getUsername()+"</td>");
		out.println("        <td class=\"key\">电话</td>");
		out.println("        <td class=\"value\">"+userItem.getTel()+"</td>");
		out.println("        <td class=\"key\">手机</td>");
		out.println("        <td class=\"value\">"+userItem.getPhone()+"</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">电子邮箱</td>");
		out.println("        <td class=\"value\">"+userItem.getEmail()+"</td>");
		out.println("        <td class=\"key\">邮政编号</td>");
		out.println("        <td class=\"value\">"+userItem.getPostalcode()+"</td>");
		out.println("        <td class=\"key\">省份</td>");
		out.println("        <td class=\"value\">"+userItem.getSave()+"</td>");
		out.println("        <td class=\"key\">城市</td>");
		out.println("        <td class=\"value\">"+userItem.getCity()+"</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">区域</td>");
		out.println("        <td class=\"value\">"+userItem.getBorough()+"</td>");
		out.println("        <td class=\"key\">其余的地址</td>");
		out.println("        <td class=\"value\" colspan=\"5\">"+userItem.getAddress()+"</td>");
		out.println("    </tr>");
		out.println("</table>");
		
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
