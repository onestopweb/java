package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.biz.UserBiz;
import cn.service.biz.impl.UserBizImpl;
import cn.service.dao.NeUserDao;
import cn.service.dao.UserLevelDao;
import cn.service.dao.impl.NeUserDaoImpl;
import cn.service.dao.impl.UserLevelDaoImpl;
import cn.entity.User;
import cn.entity.UserLevel;
import cn.service.tool.Tool;

public class UserListSer extends HttpServlet {
	public UserListSer() {
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

		//用户列表
		String pageIndexStr = request.getParameter("pageIndex");
		String userId = request.getParameter("userId");
		String levelIdStr = request.getParameter("levelId");
		int pageIndex = pageIndexStr !=null ? Integer.parseInt(pageIndexStr) : 1;
		int levelId = levelIdStr !=null ? Integer.parseInt(levelIdStr) : 0;
		int totalCount = 0;
		int end =0;
		UserBiz userBiz = new UserBizImpl();
		NeUserDao neUserDao = new NeUserDaoImpl();
		

		//注销
		String logout = request.getParameter("logout");
		if(logout != null){
			neUserDao.logoutUser(logout);
		}
		
		String username = request.getParameter("username");
		String tel = request.getParameter("tel");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String postalcode = request.getParameter("postalcode");
		String save = request.getParameter("save");
		String city = request.getParameter("city");
		String borough = request.getParameter("borough");
		String address = request.getParameter("address");
		String updateName = request.getParameter("updateName");
		
		//修改用户数据
		if(updateName!=null){
			neUserDao.update(username, tel, phone, email, postalcode, save, city, borough, address, updateName);
		}

		//分页列表
		List<User> uList = null;
		if(levelId >0 && userId !=null){
			totalCount = neUserDao.getNeUserByCount(levelId, userId);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				uList = userBiz.userList(1, Tool.pageSize, levelId, userId);
			}else if(pageIndex > end){
				pageIndex = end;
				uList = userBiz.userList(end, Tool.pageSize, levelId, userId);
			}else{
				uList = userBiz.userList(pageIndex, Tool.pageSize, levelId, userId);
			}
		}else if(levelId>0 && userId ==null){
			totalCount = neUserDao.getNeUserByCount(levelId, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				uList = userBiz.userList(1, Tool.pageSize, levelId, null);
			}else if(pageIndex > end){ 
				pageIndex = end;
				uList = userBiz.userList(end, Tool.pageSize, levelId, null);
			}else{
				uList = userBiz.userList(pageIndex, Tool.pageSize, levelId, null);
			}
		}else if(userId!=null){
			totalCount = neUserDao.getNeUserByCount(0, userId);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				uList = userBiz.userList(1, Tool.pageSize, 0, userId);
			}else if(pageIndex > end){ 
				pageIndex = end;
				uList = userBiz.userList(end, Tool.pageSize, 0, userId);
			}else{
				uList = userBiz.userList(pageIndex, Tool.pageSize, 0, userId);
			}
		}else{
			totalCount = neUserDao.getNeUserByCount(0, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				uList = userBiz.userList(1, Tool.pageSize, 0, null);
			}else if(pageIndex > end){ 
				uList = userBiz.userList(end, Tool.pageSize, 0, null);
			}else{
				uList = userBiz.userList(pageIndex, Tool.pageSize, 0, null);
			}
		}
		UserLevelDao userLevelDao = new UserLevelDaoImpl();
		List<UserLevel> ulList = userLevelDao.userLevelList();

		request.setAttribute("totalCount",totalCount);
		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("end",end);
		request.setAttribute("userId",userId);
		request.setAttribute("levelId",levelId);
		request.setAttribute("uList",uList);
		request.setAttribute("ulList",ulList);

		request.getRequestDispatcher("admin/userList.jsp").forward(request, response);
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}
}
