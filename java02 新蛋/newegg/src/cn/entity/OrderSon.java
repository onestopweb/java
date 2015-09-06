package cn.entity;

/* 
 * 订单子表联表（orderSon） 
 * */  
public class OrderSon {
	private String order_father_id;//订单号
	private int products_id;//商品编号
	private double money;//商品金额
	private int number;//商品数量
	private String model;//商品型号
	private String introduce;//商品介绍
	private String bewrite;//商品描述
	private String print;//商品小图
	private String picture;//商品中图
	private double price;//商品价格
	private int ne_number;//商品库存
	private String ne_grounding;//上架和下架，0代表上架，1代表下架
	
	/*如下是封装方法和构造方法*/
	
	public OrderSon() {
	}
	public OrderSon(String order_father_id, int products_id, double money,
			int number, String model, String introduce, String bewrite,
			String print, String picture, double price, int ne_number,
			String ne_grounding) {
		this.order_father_id = order_father_id;
		this.products_id = products_id;
		this.money = money;
		this.number = number;
		this.model = model;
		this.introduce = introduce;
		this.bewrite = bewrite;
		this.print = print;
		this.picture = picture;
		this.price = price;
		this.ne_number = ne_number;
		this.ne_grounding = ne_grounding;
	}
	public String getOrder_father_id() {
		return order_father_id;
	}
	public void setOrder_father_id(String order_father_id) {
		this.order_father_id = order_father_id;
	}
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getBewrite() {
		return bewrite;
	}
	public void setBewrite(String bewrite) {
		this.bewrite = bewrite;
	}
	public String getPrint() {
		return print;
	}
	public void setPrint(String print) {
		this.print = print;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNe_number() {
		return ne_number;
	}
	public void setNe_number(int ne_number) {
		this.ne_number = ne_number;
	}
	public String getNe_grounding() {
		return ne_grounding;
	}
	public void setNe_grounding(String ne_grounding) {
		this.ne_grounding = ne_grounding;
	}
}
