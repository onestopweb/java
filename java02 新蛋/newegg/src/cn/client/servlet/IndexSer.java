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

public class IndexSer extends HttpServlet {
	public IndexSer() {
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

		//商品联表 业务逻辑层
		ProductsBiz productsBiz = new ProductsBizImpl();

		//手机摄影类,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> ppList = productsBiz.phone_photographyList();
		request.setAttribute("ppList",ppList);

		//电脑平板类,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> ctList = productsBiz.computer_tabletList();
		request.setAttribute("ctList",ctList);

		//手机排行,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> pList = productsBiz.rankList(1);
		request.setAttribute("pList",pList);

		//微单排行,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> sList = productsBiz.rankList(3);
		request.setAttribute("sList",sList);

		//相机排行,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> cList = productsBiz.rankList(4);
		request.setAttribute("cList",cList);

		//耳机排行,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> eList = productsBiz.rankList(5);
		request.setAttribute("eList",eList);

		//笔记本排行,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> nList = productsBiz.rankList(2);
		request.setAttribute("nList",nList);

		//路由器排行,联表（商品表，商品品牌表，商品类型类，商品状态表）
		List<Products> rList = productsBiz.rankList(7);
		request.setAttribute("rList",rList);
		
		//推荐系列
		List<Products> GroomList1 = productsBiz.groomList(1);//新品首发
		List<Products> GroomList5 = productsBiz.groomList(5);//经典款
		List<Products> GroomList6 = productsBiz.groomList(6);//热销推荐
		List<Products> GroomList4 = productsBiz.groomList(4);//秒杀价
		
		request.setAttribute("GroomList1",GroomList1);
		request.setAttribute("GroomList5",GroomList5);
		request.setAttribute("GroomList6",GroomList6);
		request.setAttribute("GroomList4",GroomList4);

		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;

		//浮动窗口的数据
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

		request.getRequestDispatcher("index.jsp").forward(request, response);
		//关闭输出流  
		out.flush();  
		out.close(); 
	}
	public void init() throws ServletException {
	}
}
