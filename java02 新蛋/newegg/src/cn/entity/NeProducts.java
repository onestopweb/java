package cn.entity;

/*
 * 商品表（ne_products）
 * */
public class NeProducts {
	private int ne_products_id;//商品编号
	private int ne_classify_id;//商品类型编号
	private int ne_brand_id;//商品品牌编号
	private String ne_model;//商品型号
	private String ne_introduce;//商品介绍
	private String ne_bewrite;//商品描述
	private String ne_print;//商品小图
	private String ne_picture;//商品中图
	private double ne_price;//商品价格
	private int ne_number;//商品库存
	private String ne_time;//商品上传时间
	private int ne_status_id;//商品状态编号
	private String ne_grounding;//上架和下架，0代表上架，1代表下架
	
	/*如下是封装方法和构造方法*/
	
	public NeProducts() {
	}
	public NeProducts(int ne_products_id, int ne_classify_id, int ne_brand_id,
			String ne_model, String ne_introduce, String ne_bewrite,
			String ne_print, String ne_picture, double ne_price, int ne_number,
			String ne_time, int ne_status_id, String ne_grounding) {
		this.ne_products_id = ne_products_id;
		this.ne_classify_id = ne_classify_id;
		this.ne_brand_id = ne_brand_id;
		this.ne_model = ne_model;
		this.ne_introduce = ne_introduce;
		this.ne_bewrite = ne_bewrite;
		this.ne_print = ne_print;
		this.ne_picture = ne_picture;
		this.ne_price = ne_price;
		this.ne_number = ne_number;
		this.ne_time = ne_time;
		this.ne_status_id = ne_status_id;
		this.ne_grounding = ne_grounding;
	}


	public int getNe_products_id() {
		return ne_products_id;
	}
	public void setNe_products_id(int ne_products_id) {
		this.ne_products_id = ne_products_id;
	}
	public int getNe_classify_id() {
		return ne_classify_id;
	}
	public void setNe_classify_id(int ne_classify_id) {
		this.ne_classify_id = ne_classify_id;
	}
	public int getNe_brand_id() {
		return ne_brand_id;
	}
	public void setNe_brand_id(int ne_brand_id) {
		this.ne_brand_id = ne_brand_id;
	}
	public String getNe_model() {
		return ne_model;
	}
	public void setNe_model(String ne_model) {
		this.ne_model = ne_model;
	}
	public String getNe_introduce() {
		return ne_introduce;
	}
	public void setNe_introduce(String ne_introduce) {
		this.ne_introduce = ne_introduce;
	}
	public String getNe_bewrite() {
		return ne_bewrite;
	}
	public void setNe_bewrite(String ne_bewrite) {
		this.ne_bewrite = ne_bewrite;
	}
	public String getNe_print() {
		return ne_print;
	}
	public void setNe_print(String ne_print) {
		this.ne_print = ne_print;
	}
	public String getNe_picture() {
		return ne_picture;
	}
	public void setNe_picture(String ne_picture) {
		this.ne_picture = ne_picture;
	}
	public double getNe_price() {
		return ne_price;
	}
	public void setNe_price(double ne_price) {
		this.ne_price = ne_price;
	}
	public int getNe_number() {
		return ne_number;
	}
	public void setNe_number(int ne_number) {
		this.ne_number = ne_number;
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
	public String getNe_grounding() {
		return ne_grounding;
	}
	public void setNe_grounding(String ne_grounding) {
		this.ne_grounding = ne_grounding;
	}
}
