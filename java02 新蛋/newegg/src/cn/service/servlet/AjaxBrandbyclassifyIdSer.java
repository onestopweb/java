package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.ProductsBrand;
import cn.service.dao.ProductsBrandDao;
import cn.service.dao.impl.ProductsBrandDaoImpl;

public class AjaxBrandbyclassifyIdSer extends HttpServlet {
	public AjaxBrandbyclassifyIdSer() {
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
		
		//根据分类找到品牌Ajax
		String classifyId = request.getParameter("classifyId");
		ProductsBrandDao productsBrandDao = new ProductsBrandDaoImpl();
		List<ProductsBrand> pbList = productsBrandDao.productsBrandList(Integer.parseInt(classifyId));
		for(int i=0; i<pbList.size(); i++){
			out.println("<option value=\""+pbList.get(i).getProducts_brand_id()+"\">"+pbList.get(i).getProducts_brand_content()+"</option>");
		}

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
