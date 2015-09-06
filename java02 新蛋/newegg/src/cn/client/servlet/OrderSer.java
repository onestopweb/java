package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.client.biz.PlanOrderBiz;
import cn.client.biz.impl.PlanOrderBizImpl;
import cn.client.dao.NeUserDao;
import cn.client.dao.impl.NeUserDaoImpl;
import cn.entity.NeUser;
import cn.entity.PlanOrder;
import cn.client.tool.Tool;

public class OrderSer extends HttpServlet {
	public OrderSer() {
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

		String statusId = request.getParameter("statusId");  
		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
		request.setAttribute("statusId",statusId);
		String consignee = request.getParameter("consignee");  
		String phone = request.getParameter("phone");  
		String tel = request.getParameter("tel");  
		String province = request.getParameter("province");  
		String city = request.getParameter("city");  
		String area = request.getParameter("area");  
		String address = request.getParameter("address"); 
		String code = request.getParameter("code");  
		String email = request.getParameter("email");  

		//用户表
		NeUserDao neUserDao = new NeUserDaoImpl();
		//修改用户资料
		if(consignee!=null || phone!=null || province != null || city !=null || area != null || address !=null || code!= null || email !=null){
			neUserDao.update(consignee, tel, phone, email,
					code, province, city, area, address, username);
		}

		//根据用户ID获得对应的用户资料
		NeUser userSelect = neUserDao.select(username);
		request.setAttribute("userSelect",userSelect);

		//根据名字和状态号来获取预订单的内容
		PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
		List<PlanOrder> poList =  planOrderBiz.planOrderList(username, Integer.parseInt(statusId));
		request.setAttribute("poList",poList);

		//计算总价
		double totaPrice = Tool.totaPrice(username, Integer.parseInt(statusId));
		request.setAttribute("totaPrice",totaPrice);
		
		//恢复初始值
		Tool.skip=0;

		request.getRequestDispatcher("order.jsp").forward(request, response);
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
