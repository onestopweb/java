package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.client.biz.ProductsBiz;
import cn.client.biz.impl.ProductsBizImpl;
import cn.client.dao.NeCommentDao;
import cn.client.dao.ProductsImagesDao;
import cn.client.dao.impl.NeCommentDaoImpl;
import cn.client.dao.impl.ProductsImagesDaoImpl;
import cn.entity.NeComment;
import cn.entity.Products;
import cn.entity.ProductsImages;

public class GoodGoodsSer extends HttpServlet {
	public GoodGoodsSer() {
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

		NeCommentDao neCommentDao = new NeCommentDaoImpl();
		List<NeComment>  cList = neCommentDao.getNeCommentByStatus(3);
		int sid1 = cList.get(0).getNe_products_id();
		int sid2 = cList.get(1).getNe_products_id();
		int sid3 = cList.get(2).getNe_products_id();
		int sid4 = cList.get(3).getNe_products_id();
		int sid5 = cList.get(4).getNe_products_id();
		ProductsBiz productsBiz = new ProductsBizImpl();
		Products pItem1 = productsBiz.select(sid1);
		Products pItem2 = productsBiz.select(sid2);
		Products pItem3 = productsBiz.select(sid3);
		Products pItem4 = productsBiz.select(sid4);
		Products pItem5 = productsBiz.select(sid5);
		ProductsImagesDao productsImagesDao = new ProductsImagesDaoImpl();
		ProductsImages piItem1 = productsImagesDao.selectList(sid1).get(0);
		ProductsImages piItem2 = productsImagesDao.selectList(sid2).get(0);
		ProductsImages piItem3 = productsImagesDao.selectList(sid3).get(0);
		ProductsImages piItem4 = productsImagesDao.selectList(sid4).get(0);
		ProductsImages piItem5 = productsImagesDao.selectList(sid5).get(0);

		request.setAttribute("cList",cList);
		request.setAttribute("pItem1",pItem1);
		request.setAttribute("pItem2",pItem2);
		request.setAttribute("pItem3",pItem3);
		request.setAttribute("pItem4",pItem4);
		request.setAttribute("pItem5",pItem5);
		request.setAttribute("piItem1",piItem1);
		request.setAttribute("piItem2",piItem2);
		request.setAttribute("piItem3",piItem3);
		request.setAttribute("piItem4",piItem4);
		request.setAttribute("piItem5",piItem5);

		request.getRequestDispatcher("implant/goodGoods.jsp").forward(request, response);

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
