package cn.entity;

/* 
 * 预订单表联表（planOrder） 
 * */  
public class PlanOrder {
	private int products_id;//商品编号
	private int number;//数量
	private String user_id;//用户编号
	private String time;//提交时间
	private int status_id;//订单状态编号
	private String model;//商品型号
	private String introduce;//商品介绍
	private String bewrite;//商品描述
	private String print;//商品小图
	private String picture;//商品中图
	private double price;//商品价格
	/*如下是封装方法和构造方法*/
	public PlanOrder() {}	
	public PlanOrder(int products_id, int number, String user_id, String time,
			int status_id, String model, String introduce, String bewrite,
			String print, String picture, double price) {
		this.products_id = products_id;
		this.number = number;
		this.user_id = user_id;
		this.time = time;
		this.status_id = status_id;
		this.model = model;
		this.introduce = introduce;
		this.bewrite = bewrite;
		this.print = print;
		this.picture = picture;
		this.price = price;
	}
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
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
}
