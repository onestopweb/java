package cn.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.entity.Products;
import cn.entity.ProductsStatus;
import cn.service.biz.ProductsBiz;
import cn.service.biz.impl.ProductsBizImpl;
import cn.service.dao.ProductsStatusDao;
import cn.service.dao.impl.ProductsStatusDaoImpl;

public class AjaxGoodsListSer extends HttpServlet {

	public AjaxGoodsListSer() {
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
		
		//查看单条和修改商品showAjax
		String id = request.getParameter("id");
		ProductsBiz productsBiz = new ProductsBizImpl();
		Products item = productsBiz.select(Integer.parseInt(id));
		
		ProductsStatusDao productsStatusDao = new ProductsStatusDaoImpl();
		List<ProductsStatus> psList = productsStatusDao.productsStatusList();
		
		out.println("<table cellpadding=\"0\" cellspacing=\"0\">");
		out.println("    <tr class=\"explain\">");
		out.println("        <td colspan=\"10\">商品内容详情</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">商品编号</td>");
		out.println("        <td class=\"value\">"+item.getProducts_id()+"<input type=\"hidden\" name=\"uid\" value=\""+item.getProducts_id()+"\" /></td>");
		out.println("        <td class=\"key\">商品类型</td>");
		out.println("        <td class=\"value\">"+item.getClassify()+"</td>");
		out.println("        <td class=\"key\">商品品牌</td>");
		out.println("        <td class=\"value\">"+item.getBrand()+"</td>");
		out.println("        <td class=\"key\">商品型号</td>");
		out.println("        <td class=\"value\"><input type=\"text\" value=\""+item.getModel()+"\" name=\"model\" style=\" width:120px;\" />");
		out.println("            (50字节之内)</td>");
		out.println("        <td class=\"key\">上传时间</td>");
		out.println("        <td class=\"value\">"+item.getTime()+"</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">商品图</td>");
		out.println("        <td class=\"value\"><img src=\"images/share/"+item.getPrint()+"\" width=\"20\" height=\"15\" /></td>");
		out.println("        <td class=\"key\">商品价格</td>");
		out.println("        <td class=\"value\"><input type=\"text\" value=\""+item.getPrice()+"\" name=\"price\"");
		out.println("						style=\"width:60px;\" /></td>");
		out.println("        <td class=\"key\">商品库存</td>");
		out.println("        <td class=\"value\"><input type=\"text\" value=\""+item.getNumber()+"\" name=\"number\"");
		out.println("						style=\"width:42px;\" /></td>");
		out.println("        <td class=\"key\">商品状态</td>");
		out.println("        <td class=\"value\"><select name=\"statusId\">");
		for(int i=0; i<psList.size(); i++){
			out.println("                <option value=\""+psList.get(i).getProducts_status_id()+"\" >"+psList.get(i).getProducts_status_content()+"</option>");	
		}
		out.println("            </select></td>");
		out.println("        <td class=\"value\" colspan=\"2\">&nbsp;</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">商品介绍</td>");
		out.println("        <td class=\"value\" colspan=\"9\"><input type=\"text\" name=\"introduce\"");
		out.println("						value=\""+item.getIntroduce()+"\"");
		out.println("						style=\" width:920px;\" />");
		out.println("            (120字节之内)</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">商品描述</td>");
		out.println("        <td class=\"value\" colspan=\"9\"><input type=\"text\" name=\"bewrite\"");
		out.println("						value=\""+item.getBewrite()+"\" style=\" width:920px;\" />");
		out.println("            (120字节之内)</td>");
		out.println("    </tr>");
		out.println("    <tr class=\"item\">");
		out.println("        <td class=\"key\">商品中图路径</td>");
		out.println("        <td class=\"value\" colspan=\"3\">/newegg/images/share/"+item.getPicture()+"</td>");
		out.println("        <td class=\"key\">商品小图路径</td>");
		out.println("        <td class=\"value\" colspan=\"3\">/newegg/images/share/"+item.getPrint()+"</td>");
		out.println("        <td class=\"value\" colspan=\"2\">&nbsp;</td>");
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
