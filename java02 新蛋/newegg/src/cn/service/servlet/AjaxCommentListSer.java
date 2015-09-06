package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.NeComment;
import cn.entity.Products;
import cn.service.biz.ProductsBiz;
import cn.service.biz.impl.ProductsBizImpl;
import cn.service.dao.NeCommentDao;
import cn.service.dao.NeProductsDao;
import cn.service.dao.impl.NeCommentDaoImpl;
import cn.service.dao.impl.NeProductsDaoImpl;

public class AjaxCommentListSer extends HttpServlet {
	public AjaxCommentListSer() {
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
		
		//查看单条和修改评论showAjax
		PrintWriter out = response.getWriter(); 
		String id = request.getParameter("id");
		String userId = request.getParameter("userId");
		NeCommentDao neCommentDao = new NeCommentDaoImpl();
		NeComment cItem = neCommentDao.getComment(Integer.parseInt(id), userId);
		ProductsBiz productsBiz = new ProductsBizImpl();
		Products pItem = productsBiz.select(Integer.parseInt(id));
		
		out.println("<table cellpadding=\"0\" cellspacing=\"0\">");
		out.println("    <tr class=\"explain\">");
		out.println("        <td colspan=\"10\">商品内容详情</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">商品编号</td>");
		out.println("        <td class=\"value\">"+pItem.getProducts_id()+"<input type=\"hidden\" name=\"uid\" value=\""+pItem.getProducts_id()+"\" /></td>");
		out.println("        <td class=\"key\">商品类型</td>");
		out.println("        <td class=\"value\">"+pItem.getClassify()+"</td>");
		out.println("        <td class=\"key\">商品品牌</td>");
		out.println("        <td class=\"value\">"+pItem.getBrand()+"</td>");
		out.println("        <td class=\"key\">商品型号</td>");
		out.println("        <td class=\"value\">"+pItem.getModel()+"</td>");
		out.println("        <td class=\"key\">评论人</td>");
		out.println("        <td class=\"value\">"+userId+"<input type=\"hidden\" name=\"userId\" value=\""+userId+"\" /></td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">商品图</td>");
		out.println("        <td class=\"value\"><img");
		out.println("							src=\"images/share/"+pItem.getPrint()+"\" width=\"20\" height=\"15\" /> </td>");
		out.println("        <td class=\"key\">商品价格</td>");
		out.println("        <td class=\"value\">"+pItem.getPrice()+"</td>");
		out.println("        <td class=\"key\">商品库存</td>");
		out.println("        <td class=\"value\">"+pItem.getNumber()+"</td>");
		out.println("        <td class=\"key\">商品状态</td>");
		out.println("        <td class=\"value\">"+pItem.getStatus_content()+"</td>");
		out.println("        <td class=\"key\">评论时间</td>");
		out.println("        <td class=\"value\">"+cItem.getNe_time()+"</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">评论内容</td>");
		out.println("        <td class=\"value\" colspan=\"9\"><input type=\"text\" name=\"content\"");
		out.println("						value=\""+cItem.getNe_content()+"\"");
		out.println("						style=\" width:920px;\" />");
		out.println("            (500字之内)</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"update\">");
		out.println("        <td colspan=\"10\"><input type=\"submit\" class=\"submit f_r\"");
		out.println("						value=\"修改\" /></td>");
		out.println("    </tr>");
		out.println("</table>");
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
