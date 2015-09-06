package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.client.biz.OrderFatherBiz;
import cn.client.biz.PlanOrderBiz;
import cn.client.biz.impl.OrderFatherBizImpl;
import cn.client.biz.impl.PlanOrderBizImpl;
import cn.client.dao.NeCommentDao;
import cn.client.dao.NeOrderFatherDao;
import cn.client.dao.impl.NeCommentDaoImpl;
import cn.client.dao.impl.NeOrderFatherDaoImpl;
import cn.entity.OrderFather;
import cn.entity.PlanOrder;
import cn.client.tool.Tool;

public class HomeSer extends HttpServlet {
	public HomeSer() {
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

		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;

		String orderId =  request.getParameter("orderId");  
		if(orderId!=null){
			NeOrderFatherDao neOrderFatherDao= new NeOrderFatherDaoImpl();
			neOrderFatherDao.update(orderId, 5);
		}

		//分页查询，联表（订单主表，订单子表，订单状态表，商品表）
		OrderFatherBiz orderFatherBiz = new OrderFatherBizImpl();
		NeOrderFatherDao neOrderFatherDao = new NeOrderFatherDaoImpl();
		List<OrderFather> ofList = null;
		int pageIndex = 1; 
		String pageStr = request.getParameter("pageIndex");  
		int totalCount = neOrderFatherDao.getTotalCount(username);
		int noNdvanceCount = neOrderFatherDao.getTotalCount(username, 1);
		int  end = (int)Math.ceil((double)totalCount/5);
		if( pageStr==null || pageStr.equals("")){
			//根据设置每页的数目和第几页和用户名来获取列表数据
			ofList =orderFatherBiz.getOrderFatherByPage(1, 5, username);
		}else{
			if(!Pattern.matches("^\\d+$",pageStr)){  
				pageIndex = 1;  
			}else{  
				int index  = Integer.parseInt(pageStr);  
				if(index < 1){  
					pageIndex = 1;  
				}else if(index > end){  
					pageIndex = end;  
				}else{  
					pageIndex = index;  
				}                 
			}  
			//根据设置每页的数目和第几页和用户名来获取列表数据
			ofList =orderFatherBiz.getOrderFatherByPage(pageIndex, 5, username);
		}
		double totaPrice = Tool.totaPrice;
		request.setAttribute("totaPrice",totaPrice);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("noNdvanceCount",noNdvanceCount);
		request.setAttribute("end",end);
		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("ofList",ofList);

		//根据名字和收藏夹编号来获取预订单的内容
		PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
		List<PlanOrder> poList =  planOrderBiz.planOrderList(username, 1);
		//收藏夹数量
		int planOrdeCount = poList.size();
		request.setAttribute("poList",poList);
		request.setAttribute("planOrdeCount",planOrdeCount);

		//浮动窗口的数据
		NeCommentDao neCommentDao = new NeCommentDaoImpl();
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


		request.getRequestDispatcher("home.jsp").forward(request, response);

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
