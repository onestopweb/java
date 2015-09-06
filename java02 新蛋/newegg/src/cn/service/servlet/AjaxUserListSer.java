package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.biz.UserBiz;
import cn.service.biz.impl.UserBizImpl;
import cn.entity.User;

public class AjaxUserListSer extends HttpServlet {
	public AjaxUserListSer() {
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

		//查看单条和修改用户showAjax
		String userId = request.getParameter("userId");
		UserBiz userBiz = new UserBizImpl();
		User userItem = userBiz.select(userId);
		
		out.println("<table cellpadding=\"0\" cellspacing=\"0\">");
		out.println("    <tr class=\"explain\">");
		out.println("        <td colspan=\"8\">用户内容详情</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">用户编号</td>");
		out.println("<input type=\"hidden\" name=\"updateName\" value=\""+userItem.getUser_id()+"\"  />");
		out.println("        <td class=\"value\">"+userItem.getUser_id()+"</td>");
		out.println("        <td class=\"key\">密码</td>");
		out.println("        <td class=\"value\">"+userItem.getPassword()+"</td>");
		out.println("        <td class=\"key\">用户姓名</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"username\" value=\""+userItem.getUsername()+"\" /></td>");
		out.println("        <td class=\"key\">用户级别</td>");
		out.println("        <td class=\"value\">"+userItem.getLeve_content()+"</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">电话</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"tel\" value=\""+userItem.getTel()+"\" /></td>");
		out.println("        <td class=\"key\">手机</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"phone\" value=\""+userItem.getPhone()+"\" /></td>");
		out.println("        <td class=\"key\">电子邮箱</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"email\" value=\""+userItem.getEmail()+"\" /></td>");
		out.println("        <td class=\"key\">邮政编号</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"postalcode\" value=\""+userItem.getPostalcode()+"\" /></td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">省份</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"save\" value=\""+userItem.getSave()+"\" /></td>");
		out.println("        <td class=\"key\">城市</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"city\" value=\""+userItem.getCity()+"\" /></td>");
		out.println("        <td class=\"key\">区域</td>");
		out.println("        <td class=\"value\"><input type=\"text\" name=\"borough\" value=\""+userItem.getBorough()+"\" /></td>");
		out.println("        <td class=\"value\" colspan=\"2\">&nbsp;</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">其余的地址</td>");
		out.println("        <td class=\"value\" colspan=\"7\"><input type=\"text\"");
		out.println("			name=\"address\"			value=\""+userItem.getAddress()+"\" style=\" width:1000px;\" /></td>");
		out.println("    </tr>");
		out.println("    <tr class=\"update\">");
		out.println("        <td colspan=\"8\"><input type=\"submit\" class=\"submit f_r\"");
		out.println("						value=\"修改\" /></td>");
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
