package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.tool.Tool;
import cn.entity.Products;
import cn.entity.ProductsBrand;
import cn.service.biz.ProductsBiz;
import cn.service.biz.impl.ProductsBizImpl;
import cn.service.dao.NeProductsDao;
import cn.service.dao.ProductsBrandDao;
import cn.service.dao.ProductsClassifyDao;
import cn.service.dao.impl.NeProductsDaoImpl;
import cn.service.dao.impl.ProductsBrandDaoImpl;
import cn.service.dao.impl.ProductsClassifyDaoImpl;

public class GoodsListSer extends HttpServlet {
	public GoodsListSer() {
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

		//商品列表
		String substance = new String(request.getParameter("substance").getBytes("ISO-8859-1"),"utf-8");
		String pageIndexStr = request.getParameter("pageIndex");
		String statusNumStr =   request.getParameter("statusNum");
		int pageIndex = pageIndexStr !=null ? Integer.parseInt(pageIndexStr) : 1;
		int statusNum = statusNumStr !=null ? Integer.parseInt(statusNumStr) : 1;
		

		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();
		ProductsBrandDao productsBrandDao = new ProductsBrandDaoImpl();
		ProductsBiz productsBiz = new ProductsBizImpl();
		NeProductsDao neProductsDao = new NeProductsDaoImpl();
		List<Products> pList = null;
		
		String id = request.getParameter("id");
		String grounding = request.getParameter("grounding");
		
		//修改上架下架
		if(grounding!=null){
			neProductsDao.updateGrounding(Integer.parseInt(id), grounding);
		}
		String uid = request.getParameter("uid");
		String model = request.getParameter("model");
		String introduce = request.getParameter("introduce");
		String bewrite = request.getParameter("bewrite");
		String price = request.getParameter("price");
		String number = request.getParameter("number");
		String statusId = request.getParameter("statusId");
		
		if(uid !=null){
			neProductsDao.updateById(Integer.parseInt(uid), model, introduce, bewrite, Double.parseDouble(price), Integer.parseInt(number), Integer.parseInt(statusId));
		}

		int totalCount = 0;
		int end =0;
		if(productsClassifyDao.selectKey(substance)>0 && !(substance.equals(""))){
			int classifyKey = productsClassifyDao.selectKey(substance);
			totalCount = neProductsDao.getNeProductsLisByCount(classifyKey, 0, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				pList = productsBiz.getProductsByPage(1, Tool.pageSize, classifyKey, 0, null, statusNum);
			}else if(pageIndex > end){ 
				pageIndex = end;
				pList = productsBiz.getProductsByPage(end, Tool.pageSize, classifyKey, 0, null, statusNum);
			}else{
				pList = productsBiz.getProductsByPage(pageIndex, Tool.pageSize, classifyKey, 0, null, statusNum);
			}
		}else if(productsBrandDao.selectKey(substance)>0 && !(substance.equals(""))){
			int brandKey = productsBrandDao.selectKey(substance);
			totalCount = neProductsDao.getNeProductsLisByCount(0, brandKey, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				pList = productsBiz.getProductsByPage(1, Tool.pageSize, 0, brandKey, null, statusNum);
			}else if(pageIndex > end){ 
				pageIndex = end;
				pList = productsBiz.getProductsByPage(end, Tool.pageSize, 0, brandKey, null, statusNum);
			}else{
				pList = productsBiz.getProductsByPage(pageIndex, Tool.pageSize, 0, brandKey, null, statusNum);
			}
		}else if(!substance.equals("")){
			totalCount = neProductsDao.getNeProductsLisByCount(0, 0, substance);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				pList = productsBiz.getProductsByPage(1, Tool.pageSize, 0, 0, substance, statusNum);
			}else if(pageIndex > end){ 
				pageIndex = end;
				pList = productsBiz.getProductsByPage(end, Tool.pageSize, 0, 0, substance, statusNum);
			}else{
				pList = productsBiz.getProductsByPage(pageIndex, Tool.pageSize, 0, 0, substance, statusNum);
			}
		}else{
			totalCount = neProductsDao.getNeProductsLisByCount(0, 0, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				pList = productsBiz.getProductsByPage(1, Tool.pageSize, 0, 0, null, statusNum);
			}else if(pageIndex > end){ 
				pageIndex = end;
				pList = productsBiz.getProductsByPage(end, Tool.pageSize, 0, 0, null, statusNum);
			}else{
				pList = productsBiz.getProductsByPage(pageIndex, Tool.pageSize, 0, 0, null, statusNum);
			}
		}
		
		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("statusNum",statusNum);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("end",end);
		request.setAttribute("pList",pList);
		request.setAttribute("substance",substance);

		request.getRequestDispatcher("admin/goodsList.jsp").forward(request, response);
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
