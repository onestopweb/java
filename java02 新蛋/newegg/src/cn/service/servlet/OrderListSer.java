package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.OrderFather;
import cn.entity.OrderFatherStatus;
import cn.service.biz.OrderFatherBiz;
import cn.service.biz.impl.OrderFatherBizImpl;
import cn.service.dao.NeOrderFatherDao;
import cn.service.dao.OrderFatherStatusDao;
import cn.service.dao.impl.NeOrderFatherDaoImpl;
import cn.service.dao.impl.OrderFatherStatusDaoImpl;
import cn.service.tool.Tool;

public class OrderListSer extends HttpServlet {
	public OrderListSer() {
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
		
		//分页查询，联表（订单主表，订单子表，订单状态表，商品表）
		OrderFatherBiz orderFatherBiz = new OrderFatherBizImpl();
		NeOrderFatherDao neOrderFatherDao = new NeOrderFatherDaoImpl();
		List<OrderFather> ofList = null;
		String substance = request.getParameter("substance");  
		String pageIndexStr = request.getParameter("pageIndex");
		int pageIndex = pageIndexStr !=null ? Integer.parseInt(pageIndexStr) : 1;
		int totalCount = 0;
		int  end =0;
		if(substance==null){
			totalCount = neOrderFatherDao.getTotalCount(null, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				ofList =orderFatherBiz.getOrderFatherByPage(1, Tool.pageSize, null, null);
			}else if(pageIndex > end){ 
				pageIndex = end;
				ofList =orderFatherBiz.getOrderFatherByPage(end, Tool.pageSize, null, null);
			}else{
				ofList =orderFatherBiz.getOrderFatherByPage(pageIndex, Tool.pageSize, null, null);
			}
		}else if(neOrderFatherDao.getTotalCount(substance, null)>0){
			totalCount = neOrderFatherDao.getTotalCount(substance, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				ofList =orderFatherBiz.getOrderFatherByPage(1, Tool.pageSize, substance, null);
			}else if(pageIndex > end){ 
				pageIndex = end;
				ofList =orderFatherBiz.getOrderFatherByPage(end, Tool.pageSize, substance, null);
			}else{
				ofList =orderFatherBiz.getOrderFatherByPage(pageIndex, Tool.pageSize, substance, null);
			}

		}else{
			totalCount = neOrderFatherDao.getTotalCount(null, substance);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				ofList =orderFatherBiz.getOrderFatherByPage(1,  Tool.pageSize, null, substance);
			}else if(pageIndex > end){ 
				pageIndex = end;
				ofList =orderFatherBiz.getOrderFatherByPage(end, Tool.pageSize, null, substance);
			}else{
				ofList =orderFatherBiz.getOrderFatherByPage(pageIndex, Tool.pageSize, null, substance);
			}
		}

		request.setAttribute("substance",substance);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("end",end);
		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("ofList",ofList);
		
		//订单状态下拉菜单
		OrderFatherStatusDao orderFatherStatusDao = new OrderFatherStatusDaoImpl();
		List<OrderFatherStatus> ofsList = orderFatherStatusDao.orderFatherStatusList();
		request.setAttribute("ofsList",ofsList);

		request.getRequestDispatcher("admin/orderList.jsp").forward(request, response);
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
