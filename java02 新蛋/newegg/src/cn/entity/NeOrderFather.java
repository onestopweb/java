package cn.entity;

/*
 * 订单主表（ne_order_father）
 * */
public class NeOrderFather {
	private String ne_order_father_id;//订单号
	private String ne_user_id;//用户编号
	private String ne_order_time;//下单时间
	private int ne_status_id;//订单状态编号
	
	/*如下是封装方法和构造方法*/
	
	public NeOrderFather() {
	}
	
	public NeOrderFather(String ne_order_father_id, String ne_user_id,
			String ne_order_time, int ne_status_id) {
		this.ne_order_father_id = ne_order_father_id;
		this.ne_user_id = ne_user_id;
		this.ne_order_time = ne_order_time;
		this.ne_status_id = ne_status_id;
	}
	
	public String getNe_order_father_id() {
		return ne_order_father_id;
	}
	public void setNe_order_father_id(String ne_order_father_id) {
		this.ne_order_father_id = ne_order_father_id;
	}
	public String getNe_user_id() {
		return ne_user_id;
	}
	public void setNe_user_id(String ne_user_id) {
		this.ne_user_id = ne_user_id;
	}
	public String getNe_order_time() {
		return ne_order_time;
	}
	public void setNe_order_time(String ne_order_time) {
		this.ne_order_time = ne_order_time;
	}
	public int getNe_status_id() {
		return ne_status_id;
	}
	public void setNe_status_id(int ne_status_id) {
		this.ne_status_id = ne_status_id;
	}
}
