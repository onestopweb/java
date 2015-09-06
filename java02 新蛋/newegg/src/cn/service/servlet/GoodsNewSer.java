package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.ProductsClassify;
import cn.entity.ProductsStatus;
import cn.service.dao.NeProductsDao;
import cn.service.dao.ProductsClassifyDao;
import cn.service.dao.ProductsStatusDao;
import cn.service.dao.impl.NeProductsDaoImpl;
import cn.service.dao.impl.ProductsClassifyDaoImpl;
import cn.service.dao.impl.ProductsStatusDaoImpl;

public class GoodsNewSer extends HttpServlet {
	public GoodsNewSer() {
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

		//新增商品
		NeProductsDao neProductsDao = new NeProductsDaoImpl();
		ProductsStatusDao productsStatusDao = new ProductsStatusDaoImpl();

		//商品状态表
		List<ProductsStatus> psList = productsStatusDao.productsStatusList();
		request.setAttribute("psList",psList);

		//商品类型表
		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();
		List<ProductsClassify> pcList = productsClassifyDao.productsClassifyList();
		request.setAttribute("pcList",pcList);

		String classifyId =  request.getParameter("classifyId");  
		String brandId =  request.getParameter("brandId");  
		String model =  request.getParameter("model");  
		String price =  request.getParameter("price"); 
		String statusId =  request.getParameter("statusId");  
		String number =  request.getParameter("number");  
		String introduce =  request.getParameter("introduce");  
		String bewrite =  request.getParameter("bewrite");  
		if(classifyId!=null&&brandId!=null&&model!=null&&price!=null&&number!=null&&introduce!=null&&bewrite!=null&&statusId!=null){
			neProductsDao.insert(
					Integer.parseInt(classifyId),
					Integer.parseInt(brandId),
					model,
					introduce,
					bewrite,
					Double.parseDouble(price),
					Integer.parseInt(number),
					Integer.parseInt(statusId),
					0);
		}

		request.getRequestDispatcher("admin/goodsNew.jsp").forward(request, response);

		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}

}
