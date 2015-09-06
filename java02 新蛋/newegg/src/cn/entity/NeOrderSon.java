package cn.entity;

/*
 * 订单子表（ne_order_son）
 * */
public class NeOrderSon {
	private String ne_order_father_id;//订单号
	private int ne_products_id;//商品编号
	private double ne_money;//商品金额
	private int ne_number;//商品数量
	
	/*如下是封装方法和构造方法*/
	
	public NeOrderSon() {
	}
	public NeOrderSon(String ne_order_father_id, int ne_products_id,
			double ne_money, int ne_number) {
		this.ne_order_father_id = ne_order_father_id;
		this.ne_products_id = ne_products_id;
		this.ne_money = ne_money;
		this.ne_number = ne_number;
	}
	
	public String getNe_order_father_id() {
		return ne_order_father_id;
	}
	public void setNe_order_father_id(String ne_order_father_id) {
		this.ne_order_father_id = ne_order_father_id;
	}
	public int getNe_products_id() {
		return ne_products_id;
	}
	public void setNe_products_id(int ne_products_id) {
		this.ne_products_id = ne_products_id;
	}
	public double getNe_money() {
		return ne_money;
	}
	public void setNe_money(double ne_money) {
		this.ne_money = ne_money;
	}
	public int getNe_number() {
		return ne_number;
	}
	public void setNe_number(int ne_number) {
		this.ne_number = ne_number;
	}
}
