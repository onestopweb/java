package cn.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.client.biz.PlanOrderBiz;
import cn.client.biz.ProductsBiz;
import cn.client.biz.impl.PlanOrderBizImpl;
import cn.client.biz.impl.ProductsBizImpl;
import cn.client.dao.NeCommentDao;
import cn.client.dao.NeOrderFatherDao;
import cn.client.dao.ProductsContentDao;
import cn.client.dao.ProductsImagesDao;
import cn.client.dao.impl.NeCommentDaoImpl;
import cn.client.dao.impl.NeOrderFatherDaoImpl;
import cn.client.dao.impl.ProductsContentDaoImpl;
import cn.client.dao.impl.ProductsImagesDaoImpl;
import cn.entity.NeComment;
import cn.entity.PlanOrder;
import cn.entity.Products;
import cn.entity.ProductsContent;
import cn.entity.ProductsImages;
import cn.client.tool.Tool;

public class GoodsSer extends HttpServlet {

	public GoodsSer() {
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

		String id = request.getParameter("id");  

		//根据 id 查找商品的数据（商品表，商品品牌表，商品类型类，商品状态表）
		ProductsBiz productsBiz = new ProductsBizImpl();
		Products pItem = productsBiz.select(Integer.parseInt(id));
		request.setAttribute("pItem",pItem);

		//根据 id 查找商品大小图的数据
		ProductsImagesDao productsImagesDao = new ProductsImagesDaoImpl();
		List<ProductsImages> piList = productsImagesDao.selectList(Integer.parseInt(id));
		request.setAttribute("piList",piList);

		//根据 id 查找商品内容的数据
		ProductsContentDao productsContentDao = new ProductsContentDaoImpl();
		List<ProductsContent> pcList= productsContentDao.selectList(Integer.parseInt(id));
		request.setAttribute("pcList",pcList);

		//评论分页
		NeCommentDao neCommentDao = new NeCommentDaoImpl();

		//插入内容
		String content = request.getParameter("content");  
		HttpSession session  = request.getSession();
		String username = session.getAttribute("username")!= null ?session.getAttribute("username").toString():null;
		if(username !=null && content !=null){
			int count = neCommentDao.selectComment(Integer.parseInt(id), username);
			if(count==0){
				neCommentDao.addNeComment(Integer.parseInt(id), username, content);
			}
		}

		//显示内容
		List<NeComment> cList =null;
		int pageIndex = 1; 
		String pageStr = request.getParameter("pageIndex");  
		int totalCount = neCommentDao.getTotalCount(Integer.parseInt(id));
		int  end = (int)Math.ceil((double)totalCount/5);
		if( pageStr==null || pageStr.equals("")){
			//根据设置每页的数目和第几页和商品id来获取列表数据
			cList = neCommentDao.getNeCommentByPage(1, 5, Integer.parseInt(id));
		}else{
			if(!Pattern.matches("^\\d+$",pageStr)){  
				pageIndex = 1;  
			}else{  
				int index  = Integer.parseInt(pageStr);  
				if(index < 1){  
					pageIndex = 1;  
				}else if(index > end){  
					pageIndex = end;  
				}else{  
					pageIndex = index;  
				}                 
			}  
			//根据设置每页的数目和第几页和商品id来获取列表数据
			cList = neCommentDao.getNeCommentByPage(pageIndex, 5, Integer.parseInt(id));
		}
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("end",end);
		request.setAttribute("pageIndex",pageIndex);
		request.setAttribute("cList",cList);

		//热销推荐
		List<Products> groomList = productsBiz.groomList(6);
		request.setAttribute("groomList",groomList);

		//浮动窗口的数据
		PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
		NeOrderFatherDao neOrderFatherDao = new NeOrderFatherDaoImpl();
		int commentCount=0;//存放评论数
		List<PlanOrder> collectList =null;//存放收藏夹列表
		int collectListSize = 0;//存在收藏夹数量
		List<PlanOrder>  cartList = null;//存在购物车列表
		int cartListSize = 0;//存在购物车数量
		int orderCount = 0;//存在订单数
		double carttotaPrice = 0.0;//购物车总价
		if(username != null){
			commentCount = neCommentDao.getTotalCount(username);
			collectList = planOrderBiz.planOrderList(username, 1);
			collectListSize = collectList.size();
			cartList =  planOrderBiz.planOrderList(username, 2);
			cartListSize = cartList.size();
			orderCount = neOrderFatherDao.getTotalCount(username);
			carttotaPrice = Tool.totaPrice(username, 2);
		}

		request.setAttribute("commentCount",commentCount);
		request.setAttribute("collectList",collectList);
		request.setAttribute("collectListSize",collectListSize);
		request.setAttribute("cartList",cartList);
		request.setAttribute("cartListSize",cartListSize);
		request.setAttribute("orderCount",orderCount);
		request.setAttribute("carttotaPrice",carttotaPrice);

		request.getRequestDispatcher("goods.jsp").forward(request, response);

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
