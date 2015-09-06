package cn.entity;

/*
 * 预订单表（ne_plan_order）
 * */
public class NePlanOrder {
	private int ne_products_id;//商品编号
	private int ne_number;//数量
	private String ne_user_id;//用户编号
	private String ne_time;//提交时间
	private int ne_status_id;//订单状态编号
	
	/*如下是封装方法和构造方法*/
	
	public NePlanOrder() {
	}
	
	public NePlanOrder(int ne_products_id, int ne_number, String ne_user_id,
			String ne_time, int ne_status_id) {
		this.ne_products_id = ne_products_id;
		this.ne_number = ne_number;
		this.ne_user_id = ne_user_id;
		this.ne_time = ne_time;
		this.ne_status_id = ne_status_id;
	}
	
	public int getNe_products_id() {
		return ne_products_id;
	}
	public void setNe_products_id(int ne_products_id) {
		this.ne_products_id = ne_products_id;
	}
	public int getNe_number() {
		return ne_number;
	}
	public void setNe_number(int ne_number) {
		this.ne_number = ne_number;
	}
	public String getNe_user_id() {
		return ne_user_id;
	}
	public void setNe_user_id(String ne_user_id) {
		this.ne_user_id = ne_user_id;
	}
	public String getNe_time() {
		return ne_time;
	}
	public void setNe_time(String ne_time) {
		this.ne_time = ne_time;
	}
	public int getNe_status_id() {
		return ne_status_id;
	}
	public void setNe_status_id(int ne_status_id) {
		this.ne_status_id = ne_status_id;
	}
}
