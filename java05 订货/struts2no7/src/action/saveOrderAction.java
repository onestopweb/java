package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tool.Tool;
import biz.GoodsBiz;
import biz.impl.GoodsBizImpl;
import com.opensymphony.xwork2.ActionSupport;
import entity.Goods;
import entity.Order;
import entity.OrderDetail;
/**
 * 保存并显示订单 Action
 * */
public class saveOrderAction extends ActionSupport {
	private GoodsBiz goodsBiz=new GoodsBizImpl();
	private Order order;
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	private Integer[] ids;
	private Integer[] amounts;
	private String name;
	private String address;
	private double total = 0.0;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public GoodsBiz getGoodsBiz() {
		return goodsBiz;
	}
	public void setGoodsBiz(GoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Integer[] getAmounts() {
		return amounts;
	}
	public void setAmounts(Integer[] amounts) {
		this.amounts = amounts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String execute() throws Exception {
		try {
			goodsBiz.saveOrder(ids, amounts, name, address);
			order = goodsBiz.getOrderByIds(Tool.oId);
			orderDetails = goodsBiz.getOrderDetailByOdIds(Tool.odIds);
			for (OrderDetail orderDetail : orderDetails) {
				total += orderDetail.getGoods().getPrice()*orderDetail.getAmount();
			}
			Tool.oId=0;
			Tool.odIds.clear();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
