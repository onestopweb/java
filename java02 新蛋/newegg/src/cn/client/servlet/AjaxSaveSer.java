package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.client.dao.NePlanOrderDao;
import cn.client.dao.impl.NePlanOrderDaoImpl;

public class AjaxSaveSer extends HttpServlet {
	public AjaxSaveSer() {
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

		//收藏收藏夹、购物车、立即购买的Ajax页面
		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
		String id = request.getParameter("id"); 
		String number = request.getParameter("number"); 
		String statusId = request.getParameter("statusId"); 
		NePlanOrderDao nePlanOrderDao=new NePlanOrderDaoImpl();
		int count = nePlanOrderDao.selectPlanOrde(Integer.parseInt(id),username , Integer.parseInt(statusId));
		if(username==null){
			out.print("请先登陆后再操作"); 
		}else if(count>0){
			if(Integer.parseInt(statusId)==1){
				out.print("收藏夹已经存在该商品，不可重复购买"); 
			}else if(Integer.parseInt(statusId)==2){
				out.print("购物车已经存在该商品，不可重复购买"); 
			}else{
				out.print("立即购买已经存在该商品，不可重复购买"); 
			}
		}else{
			nePlanOrderDao.insertPlanOrder(Integer.parseInt(id), username,Integer.parseInt(statusId), Integer.parseInt(number));
			if(Integer.parseInt(statusId)==1){
				out.print("收藏夹购买成功"); 
			}else if(Integer.parseInt(statusId)==2){
				out.print("购物车购买成功"); 
			}else{
				out.print("立即购买已成功"); 
			}
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
