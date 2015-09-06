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
import cn.client.biz.ProductsBiz;
import cn.client.biz.impl.PlanOrderBizImpl;
import cn.client.biz.impl.ProductsBizImpl;
import cn.client.dao.NePlanOrderDao;
import cn.client.dao.impl.NePlanOrderDaoImpl;
import cn.entity.PlanOrder;
import cn.entity.Products;
import cn.client.tool.Tool;

public class CartSer extends HttpServlet {
	public CartSer() {
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
		String id = request.getParameter("id"); 
		String number = request.getParameter("number"); 
		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
		
		PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
		List<PlanOrder> poList = null;
		
		NePlanOrderDao nePlanOrderDao = new NePlanOrderDaoImpl();
		
		//修改信息
		if(username !=null && id !=null&&number!=null){
			int number2 = Integer.parseInt(number);
			if(number2<1){//小于1则删除
				nePlanOrderDao.deletePlanOrder(Integer.parseInt(id), username, Integer.parseInt(statusId));
			}else{
				nePlanOrderDao.updatePlanOrder(Integer.parseInt(id), username, Integer.parseInt(statusId), number2);
			}
		}else if(username !=null && id !=null){//删除信息
			nePlanOrderDao.deletePlanOrder(Integer.parseInt(id), username, Integer.parseInt(statusId));
		}
		
		//根据名字和状态号来获取预订单的内容
		if(username !=null){
			poList = planOrderBiz.planOrderList(username, Integer.parseInt(statusId));
		}
		request.setAttribute("statusId",statusId);
		request.setAttribute("poList",poList);

		//疯抢商品
		ProductsBiz productsBiz = new ProductsBizImpl();
		List<Products> folieList = productsBiz.groomList(2);
		request.setAttribute("folieList",folieList);
		
		//计算总价
		double totaPrice = Tool.totaPrice(username, Integer.parseInt(statusId));
		request.setAttribute("totaPrice",totaPrice);

		request.getRequestDispatcher("cart.jsp").forward(request, response);
		

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
