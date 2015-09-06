package cn.entity;

/*
 * 订单主状态表（order_father_status）
 * */
public class OrderFatherStatus {
	private int order_father_status_id;//状态编号
	private String order_father_status_content;//状态名称
	
	/*如下是封装方法和构造方法*/
	
	public OrderFatherStatus() {
	}
	
	public OrderFatherStatus(int order_father_status_id,
			String order_father_status_content) {
		this.order_father_status_id = order_father_status_id;
		this.order_father_status_content = order_father_status_content;
	}
	
	public int getOrder_father_status_id() {
		return order_father_status_id;
	}
	public void setOrder_father_status_id(int order_father_status_id) {
		this.order_father_status_id = order_father_status_id;
	}
	public String getOrder_father_status_content() {
		return order_father_status_content;
	}
	public void setOrder_father_status_content(String order_father_status_content) {
		this.order_father_status_content = order_father_status_content;
	}
}
