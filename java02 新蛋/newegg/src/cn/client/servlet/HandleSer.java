package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.client.dao.NePlanOrderDao;
import cn.client.dao.impl.NePlanOrderDaoImpl;

public class HandleSer extends HttpServlet {
	public HandleSer() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		
		//立即订购处理页
		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
		String id = request.getParameter("id"); 
		String number = request.getParameter("number"); 
		NePlanOrderDao nePlanOrderDao=new NePlanOrderDaoImpl();
		int count = nePlanOrderDao.selectPlanOrde(Integer.parseInt(id),username , 3);
		if(username==null){
			out.print("<script>alert('请登陆后再作操作');location.href='login';</script>"); 
		}else if(count>0){
			out.print("<script>alert('该商品已经购买');location.href='goods?id="+id+"';</script>"); 
		}else{
			nePlanOrderDao.insertPlanOrder(Integer.parseInt(id), username, 3, Integer.parseInt(number));
			response.sendRedirect("cart?statusId=3");
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
