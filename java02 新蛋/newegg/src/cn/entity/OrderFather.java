package cn.entity;

import java.util.List;

/* 
 * 订单主表联表（orderFather） 
 * */  
public class OrderFather {
	private String order_father_id;//订单号
	private String user_id;//用户编号
	private String order_time;//下单时间
	private int status_id;//订单状态编号
	private String status;//订单状态
	private double total;//订单总价
	private List<OrderSon> orderSonList ;//订单号子表
	
	/*如下是封装方法和构造方法*/
	public OrderFather() {}
	public OrderFather(String order_father_id, String user_id,
			String order_time, String status, double total,
			List<OrderSon> orderSonList) {
		this.order_father_id = order_father_id;
		this.user_id = user_id;
		this.order_time = order_time;
		this.status = status;
		this.total = total;
		this.orderSonList = orderSonList;
	}
	
	public OrderFather(String order_father_id, String user_id,
			String order_time, int status_id, String status, double total,
			List<OrderSon> orderSonList) {
		this.order_father_id = order_father_id;
		this.user_id = user_id;
		this.order_time = order_time;
		this.status_id = status_id;
		this.status = status;
		this.total = total;
		this.orderSonList = orderSonList;
	}
	public String getOrder_father_id() {
		return order_father_id;
	}
	public void setOrder_father_id(String order_father_id) {
		this.order_father_id = order_father_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<OrderSon> getOrderSonList() {
		return orderSonList;
	}
	public void setOrderSonList(List<OrderSon> orderSonList) {
		this.orderSonList = orderSonList;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
}
