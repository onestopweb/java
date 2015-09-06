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

import cn.client.biz.PlanOrderBiz;
import cn.client.biz.ProductsBiz;
import cn.client.biz.impl.PlanOrderBizImpl;
import cn.client.biz.impl.ProductsBizImpl;
import cn.client.dao.NeCommentDao;
import cn.client.dao.NeOrderFatherDao;
import cn.client.dao.NeProductsDao;
import cn.client.dao.ProductsBrandDao;
import cn.client.dao.ProductsClassifyDao;
import cn.client.dao.impl.NeCommentDaoImpl;
import cn.client.dao.impl.NeOrderFatherDaoImpl;
import cn.client.dao.impl.NeProductsDaoImpl;
import cn.client.dao.impl.ProductsBrandDaoImpl;
import cn.client.dao.impl.ProductsClassifyDaoImpl;
import cn.entity.PlanOrder;
import cn.entity.Products;
import cn.entity.ProductsBrand;
import cn.client.tool.Tool;

public class SearchSer extends HttpServlet {
	public SearchSer() {
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

		//搜索页面
		String substance = new String(request.getParameter("substance").getBytes("ISO-8859-1"),"utf-8");
		String pageIndexStr = request.getParameter("pageIndex");
		String priceBeginStr =  request.getParameter("priceBegin");
		String priceEndStr =   request.getParameter("priceEnd");
		String statusNumStr =   request.getParameter("statusNum");
		String classifyName = null;
		int pageIndex = pageIndexStr !=null ? Integer.parseInt(pageIndexStr) : 1;
		int priceBegin = priceBeginStr !=null ? Integer.parseInt(priceBeginStr) : 0;
		int priceEnd = priceEndStr !=null ? Integer.parseInt(priceEndStr) : 0;
		int statusNum = statusNumStr !=null ? Integer.parseInt(statusNumStr) : 0;

		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();
		ProductsBrandDao productsBrandDao = new ProductsBrandDaoImpl();
		ProductsBiz productsBiz = new ProductsBizImpl();
		NeProductsDao neProductsDao = new NeProductsDaoImpl();
		List<ProductsBrand> brandList = null;
		List<Products> pList = null;

		int totalCount = 0;
		int end =0;
		int classifyId =1;
		if(productsClassifyDao.selectKey(substance)>0){
			int classifyKey = productsClassifyDao.selectKey(substance);
			classifyId = classifyKey;
			classifyName = substance;
			brandList = productsBrandDao.productsBrandList(productsClassifyDao.selectKey(substance));
			totalCount = neProductsDao.getNeProductsByCount(classifyKey, 0, null, priceBegin, priceEnd);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				pList = productsBiz.getProductsByPage(1, Tool.pageSize, classifyKey, 0, null, priceBegin, priceEnd, statusNum);
			}else if(pageIndex > end){  
				pageIndex = end;
				pList = productsBiz.getProductsByPage(end, Tool.pageSize, classifyKey, 0, null, priceBegin, priceEnd, statusNum);
			}else{
				pList = productsBiz.getProductsByPage(pageIndex, Tool.pageSize, classifyKey, 0, null, priceBegin, priceEnd, statusNum);
			}  
		}else if(productsBrandDao.selectKey(substance)>0){
			int brandKey = productsBrandDao.selectKey(substance);
			int ClassifyKey = productsBrandDao.selectClassifyKey(substance);
			classifyId = ClassifyKey;
			classifyName = productsClassifyDao.selectName(ClassifyKey);
			brandList = productsBrandDao.productsBrandList(ClassifyKey);
			totalCount = neProductsDao.getNeProductsByCount(0, brandKey, null, priceBegin, priceEnd);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				pList = productsBiz.getProductsByPage(1, Tool.pageSize, 0, brandKey, null, priceBegin, priceEnd, statusNum);
			}else if(pageIndex > end){  
				pageIndex = end;
				pList = productsBiz.getProductsByPage(end, Tool.pageSize, 0, brandKey, null, priceBegin, priceEnd, statusNum);
			}else{
				pList = productsBiz.getProductsByPage(pageIndex, Tool.pageSize, 0, brandKey, null, priceBegin, priceEnd, statusNum);
			}  
		}else{
			totalCount = neProductsDao.getNeProductsByCount(0, 0, substance, priceBegin, priceEnd);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				pList = productsBiz.getProductsByPage(1,Tool.pageSize, 0, 0, substance, priceBegin, priceEnd, statusNum);
			}else if(pageIndex > end){  
				pageIndex = end;
				pList = productsBiz.getProductsByPage(end, Tool.pageSize, 0, 0, substance, priceBegin, priceEnd, statusNum);
			}else{
				pList = productsBiz.getProductsByPage(pageIndex, Tool.pageSize, 0, 0, substance, priceBegin, priceEnd, statusNum);
			}
		}

		List<Products> rList = productsBiz.rankList(classifyId);

		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("priceBegin",priceBegin);
		request.setAttribute("priceEnd",priceEnd);
		request.setAttribute("statusNum",statusNum);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("classifyName",classifyName);
		request.setAttribute("end",end);
		request.setAttribute("pList",pList);
		request.setAttribute("substance",substance);
		request.setAttribute("brandList",brandList);
		request.setAttribute("rList",rList);

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

		request.getRequestDispatcher("search.jsp").forward(request, response);
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
