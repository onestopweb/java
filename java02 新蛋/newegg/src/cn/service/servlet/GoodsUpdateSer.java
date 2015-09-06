package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.Products;
import cn.entity.ProductsClassify;
import cn.entity.ProductsContent;
import cn.entity.ProductsImages;
import cn.entity.ProductsStatus;
import cn.service.biz.ProductsBiz;
import cn.service.biz.impl.ProductsBizImpl;
import cn.service.dao.NeProductsDao;
import cn.service.dao.ProductsClassifyDao;
import cn.service.dao.ProductsContentDao;
import cn.service.dao.ProductsImagesDao;
import cn.service.dao.ProductsStatusDao;
import cn.service.dao.impl.NeProductsDaoImpl;
import cn.service.dao.impl.ProductsClassifyDaoImpl;
import cn.service.dao.impl.ProductsContentDaoImpl;
import cn.service.dao.impl.ProductsImagesDaoImpl;
import cn.service.dao.impl.ProductsStatusDaoImpl;


public class GoodsUpdateSer extends HttpServlet {

	public GoodsUpdateSer() {
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

		//商品图、大小图、内容图修改和上传，和修改商品内容
		ProductsBiz productsBiz = new ProductsBizImpl();
		NeProductsDao neProductsDao = new NeProductsDaoImpl();
		ProductsImagesDao productsImagesDao = new ProductsImagesDaoImpl();
		ProductsContentDao productsContentDao = new ProductsContentDaoImpl();
		ProductsStatusDao productsStatusDao = new ProductsStatusDaoImpl();

		//修改商品、内容和大小图
		String id = request.getParameter("id");  

		//修改商品
		String uid = request.getParameter("uid");  
		String classifyId = request.getParameter("classifyId");  
		String brandId = request.getParameter("brandId");  
		String model = request.getParameter("model");  
		String price = request.getParameter("price");  
		String number = request.getParameter("number");  
		String introduce = request.getParameter("introduce");  
		String bewrite = request.getParameter("bewrite");  
		String statusId = request.getParameter("statusId");  
		if(uid!=null){
			neProductsDao.updateById(Integer.parseInt(id),
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

		//删除所有的大小图
		String delImg =  request.getParameter("delImg");  
		if(delImg!=null){
			productsImagesDao.delete(Integer.parseInt(id));
		}

		//删除单个大小图
		String delImgById = request.getParameter("delImgById");  
		if(delImgById!=null){
			productsImagesDao.delete(Integer.parseInt(id),delImgById);
		}

		//删除所有的内容图
		String delCon =  request.getParameter("delCon");  
		if(delCon!=null){
			productsContentDao.delete(Integer.parseInt(id));
		}

		//删除单个的内容图
		String delConById =  request.getParameter("delConById");  
		if(delConById!=null){
			productsContentDao.delete(Integer.parseInt(id),delConById);
		}
		
		//修改商品图
		String print =  request.getParameter("print");  
		String picture =  request.getParameter("picture");  
		if(print!=null && picture!=null){
			neProductsDao.update(Integer.parseInt(id), print, picture);
		}
		
		//添加大小图
		String productsSmallmap =  request.getParameter("productsSmallmap");  
		String productsLarge =  request.getParameter("productsLarge");  
		if(productsSmallmap!=null&&productsLarge!=null){
			productsImagesDao.insert(Integer.parseInt(id), productsSmallmap, productsLarge);
		}
		
		//添加内容图
		String productsContent = request.getParameter("productsContent");  
		if(productsContent != null){
			productsContentDao.insert(Integer.parseInt(id), productsContent);
		}

		//根据 id 查找商品的数据（商品表，商品品牌表，商品类型类，商品状态表）
		Products pItem = productsBiz.select(Integer.parseInt(id));
		request.setAttribute("pItem",pItem);

		//根据 id 查找商品大小图的数据
		List<ProductsImages> piList = productsImagesDao.selectList(Integer.parseInt(id));
		request.setAttribute("piList",piList);

		//根据 id 查找商品内容的数据
		List<ProductsContent> pcList= productsContentDao.selectList(Integer.parseInt(id));
		request.setAttribute("pcList",pcList);

		//商品状态表
		List<ProductsStatus> psList = productsStatusDao.productsStatusList();
		request.setAttribute("psList",psList);

		//商品类型表
		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();
		List<ProductsClassify> pc2List = productsClassifyDao.productsClassifyList();
		request.setAttribute("pc2List",pc2List);


		request.getRequestDispatcher("admin/goodsUpdate.jsp").forward(request, response);

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
