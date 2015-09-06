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
import cn.client.dao.NeCommentDao;
import cn.client.dao.NeOrderFatherDao;
import cn.client.dao.impl.NeCommentDaoImpl;
import cn.client.dao.impl.NeOrderFatherDaoImpl;
import cn.entity.PlanOrder;
import cn.entity.Products;
import cn.client.tool.Tool;

public class TimeSer extends HttpServlet {
	public TimeSer() {
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

		//商品联表 业务逻辑层
		ProductsBiz productsBiz = new ProductsBizImpl();
		List<Products> lbList = productsBiz.listBystatusId(2);
		request.setAttribute("lbList",lbList);

		//浮动窗口的数据
		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
		NeCommentDao neCommentDao = new NeCommentDaoImpl();
		PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
		NeOrderFatherDao neOrderFatherDao = new NeOrderFatherDaoImpl();
		int commentCount=0;//存放评论数
		List<PlanOrder> collectList =null;//存放收藏夹列表
		int collectListSize = 0;//存在收藏夹数量
		List<PlanOrder>  cartList = null;//存在购物车列表
		int cartListSize = 0;//存在购物车数量
		int orderCount = 0;//存在订单数
		double carttotaPrice = 0.0;//购物车总价
		if(username != null){
			commentCount = neCommentDao.getTotalCount(username);
			collectList = planOrderBiz.planOrderList(username, 1);
			collectListSize = collectList.size();
			cartList =  planOrderBiz.planOrderList(username, 2);
			cartListSize = cartList.size();
			orderCount = neOrderFatherDao.getTotalCount(username);
			carttotaPrice = Tool.totaPrice(username, 2);
		}

		request.setAttribute("commentCount",commentCount);
		request.setAttribute("collectList",collectList);
		request.setAttribute("collectListSize",collectListSize);
		request.setAttribute("cartList",cartList);
		request.setAttribute("cartListSize",cartListSize);
		request.setAttribute("orderCount",orderCount);
		request.setAttribute("carttotaPrice",carttotaPrice);

		request.getRequestDispatcher("time.jsp").forward(request, response);
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
