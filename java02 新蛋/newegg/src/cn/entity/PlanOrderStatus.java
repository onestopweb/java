package cn.entity;

/*
 * 预订单状态表（plan_order_status）
 * */
public class PlanOrderStatus {
	private int plan_order_status_id;//状态编号
	private String plan_order_status_content;//状态名称
	
	/*如下是封装方法和构造方法*/
	
	public PlanOrderStatus() {
	}
	
	public PlanOrderStatus(int plan_order_status_id,
			String plan_order_status_content) {
		this.plan_order_status_id = plan_order_status_id;
		this.plan_order_status_content = plan_order_status_content;
	}
	
	public int getPlan_order_status_id() {
		return plan_order_status_id;
	}
	public void setPlan_order_status_id(int plan_order_status_id) {
		this.plan_order_status_id = plan_order_status_id;
	}
	public String getPlan_order_status_content() {
		return plan_order_status_content;
	}
	public void setPlan_order_status_content(String plan_order_status_content) {
		this.plan_order_status_content = plan_order_status_content;
	}
}
