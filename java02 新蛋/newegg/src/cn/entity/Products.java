package cn.entity;

/* 
 * 商品联表（products） 
 * */  
public class Products {
	private int products_id;//商品编号
	private int classifyId;//商品类型id
	private String classify;//商品类型
	private int brandId;//商品品牌id
	private String brand;//商品品牌
	private String model;//商品型号
	private String introduce;//商品介绍
	private String bewrite;//商品描述
	private String print;//商品小图
	private String picture;//商品中图
	private double price;//商品价格
	private int number;//商品库存
	private String time;//商品上传时间
	private String status_content;//商品状态内容
	private String status_img;//商品状态图片
	private int status_id;//商品状态编号
	private String grounding;//上架和下架，0代表上架，1代表下架
	/*如下是封装方法和构造方法*/
	public Products() {
	}
	public Products(int products_id, String classify, String brand,
			String model, String introduce, String bewrite, String print,
			String picture, double price, int number, String time,
			String status_content, String status_img, int status_id,
			String grounding) {
		this.products_id = products_id;
		this.classify = classify;
		this.brand = brand;
		this.model = model;
		this.introduce = introduce;
		this.bewrite = bewrite;
		this.print = print;
		this.picture = picture;
		this.price = price;
		this.number = number;
		this.time = time;
		this.status_content = status_content;
		this.status_img = status_img;
		this.status_id = status_id;
		this.grounding = grounding;
	}
	public Products(int products_id, int classifyId, String classify,
			int brandId, String brand, String model, String introduce,
			String bewrite, String print, String picture, double price,
			int number, String time, String status_content, String status_img,
			int status_id, String grounding) {
		this.products_id = products_id;
		this.classifyId = classifyId;
		this.classify = classify;
		this.brandId = brandId;
		this.brand = brand;
		this.model = model;
		this.introduce = introduce;
		this.bewrite = bewrite;
		this.print = print;
		this.picture = picture;
		this.price = price;
		this.number = number;
		this.time = time;
		this.status_content = status_content;
		this.status_img = status_img;
		this.status_id = status_id;
		this.grounding = grounding;
	}
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus_content() {
		return status_content;
	}
	public void setStatus_content(String status_content) {
		this.status_content = status_content;
	}
	public String getStatus_img() {
		return status_img;
	}
	public void setStatus_img(String status_img) {
		this.status_img = status_img;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getGrounding() {
		return grounding;
	}
	public void setGrounding(String grounding) {
		this.grounding = grounding;
	}
	public int getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(int classifyId) {
		this.classifyId = classifyId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
}
