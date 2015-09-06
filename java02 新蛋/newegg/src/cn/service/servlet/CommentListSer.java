package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.Comment;
import cn.entity.CommentStatus;
import cn.service.biz.CommentBiz;
import cn.service.biz.impl.CommentBizImpl;
import cn.service.dao.CommentStatusDao;
import cn.service.dao.NeCommentDao;
import cn.service.dao.NeProductsDao;
import cn.service.dao.impl.CommentStatusDaoImpl;
import cn.service.dao.impl.NeCommentDaoImpl;
import cn.service.dao.impl.NeProductsDaoImpl;
import cn.service.tool.Tool;

public class CommentListSer extends HttpServlet {
	public CommentListSer() {
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

		//评论列表
		CommentBiz commentBiz = new CommentBizImpl();
		NeCommentDao neCommentDao = new NeCommentDaoImpl();
		CommentStatusDao commentStatusDao = new CommentStatusDaoImpl();
		NeProductsDao neProductsDao = new NeProductsDaoImpl();

		String substance = request.getParameter("substance");  
		String pageIndexStr = request.getParameter("pageIndex");
		int pageIndex = pageIndexStr !=null ? Integer.parseInt(pageIndexStr) : 1;
		int totalCount = 0;
		int  end =0;

		String uid = request.getParameter("uid"); 
		String userId = request.getParameter("userId");  
		String content = request.getParameter("content");  

		if(uid!=null){
			neCommentDao.updateComment(Integer.parseInt(uid), userId, content);
		}

		List<Comment> cList = new ArrayList<Comment>();
		boolean mat =false;
		if(substance!=null){
			mat = substance.matches("\\d+");
		}

		if(mat && substance!=null){
			totalCount = neCommentDao.getNeCommentByCount(neProductsDao.selectId(Integer.parseInt(substance)), null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			totalCount = neCommentDao.getNeCommentByCount(Integer.parseInt(substance), null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				cList = commentBiz.getCommentByPage(1, Tool.pageSize, Integer.parseInt(substance), null);
			}else if(pageIndex > end){ 
				pageIndex = end;
				cList = commentBiz.getCommentByPage(end, Tool.pageSize, Integer.parseInt(substance), null);
			}else{
				cList = commentBiz.getCommentByPage(pageIndex, Tool.pageSize, Integer.parseInt(substance), null);
			}
		}else if(substance!=null){
			totalCount = neCommentDao.getNeCommentByCount(0, substance);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				cList = commentBiz.getCommentByPage(1, Tool.pageSize, 0, substance);
			}else if(pageIndex > end){ 
				pageIndex = end;
				cList = commentBiz.getCommentByPage(end, Tool.pageSize, 0, substance);
			}else{
				cList = commentBiz.getCommentByPage(pageIndex, Tool.pageSize, 0, substance);
			}
		}else{
			totalCount = neCommentDao.getNeCommentByCount(0, null);
			end = (int)Math.ceil((double)totalCount/Tool.pageSize);
			if(pageIndex < 1){
				cList = commentBiz.getCommentByPage(1, Tool.pageSize, 0, null);
			}else if(pageIndex > end){ 
				pageIndex = end;
				cList = commentBiz.getCommentByPage(end, Tool.pageSize, 0, null);
			}else{
				cList = commentBiz.getCommentByPage(pageIndex, Tool.pageSize, 0, null);
			}
		}

		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("end",end);
		request.setAttribute("cList",cList);
		request.setAttribute("substance",substance);

		List<CommentStatus> csList = commentStatusDao.commentStatusList();
		request.setAttribute("csList",csList);

		request.getRequestDispatcher("admin/commentList.jsp").forward(request, response);
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
