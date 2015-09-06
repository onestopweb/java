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
import cn.client.dao.NeOrderFatherDao;
import cn.client.dao.NeOrderSonDao;
import cn.client.dao.NePlanOrderDao;
import cn.client.dao.impl.NeOrderFatherDaoImpl;
import cn.client.dao.impl.NeOrderSonDaoImpl;
import cn.client.dao.impl.NePlanOrderDaoImpl;
import cn.entity.PlanOrder;
import cn.client.tool.Tool;

public class SuccessSer extends HttpServlet {
	public SuccessSer() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
		
		//只允许一次，第二次刷新则跳转到 home 页面
		if(Tool.skip==0){
			String statusId = request.getParameter("statusId");  
			HttpSession session  = request.getSession();
			String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
			double total = total(username, Integer.parseInt(statusId));
			PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
			List<PlanOrder> poList =  planOrderBiz.planOrderList(username, Integer.parseInt(statusId));
			request.setAttribute("poList",poList);
			//该步骤是首先得到一个8位的随机数
			//然后先插入主表再插入子表
			//最后删除预订单
			int randomNum = (int)(89999999*Math.random()+10000000);
			String orderFatherId =String.valueOf(randomNum);
			System.out.println(randomNum);
			NeOrderFatherDao neOrderFatherDao = new NeOrderFatherDaoImpl();
			neOrderFatherDao.insertOrderFather(orderFatherId, username);
			NeOrderSonDao neOrderSonDao = new NeOrderSonDaoImpl();
			for(int i =0; i<poList.size();i++){
				int pid = poList.get(i).getProducts_id();
				double money = poList.get(i).getPrice();
				int number = poList.get(i).getNumber();
				neOrderSonDao .insertOrderSon(orderFatherId,pid, money, number);
			}
			NePlanOrderDao nePlanOrderDao = new NePlanOrderDaoImpl();
			nePlanOrderDao.deletePlanOrder(username, Integer.parseInt(statusId));
			request.setAttribute("total",total);
			request.setAttribute("orderFatherId",orderFatherId);
			++Tool.skip;
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			response.sendRedirect("home");  
		}
		out.flush();
		out.close();
	}

	public double total(String username, int statusId){
		PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
		List<PlanOrder> poList =  planOrderBiz.planOrderList(username, statusId);
		double sum = 5.00;
		for(int i =0; i<poList.size();i++){
			int number = poList.get(i).getNumber();
			double price = poList.get(i).getPrice();
			sum+=price*number;
		}
		return sum;
	}

	public void init() throws ServletException {
	}

}
