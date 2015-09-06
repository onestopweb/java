package cn.entity;

/*
 * 商品品牌表（products_brand）
 * */
public class ProductsBrand {
	private int products_brand_id;//品牌编号
	private String products_brand_content;//品牌内容
	private int products_classify_id;//商品类型编号
	
	/*如下是封装方法和构造方法*/
	
	public ProductsBrand() {
	}
	
	public ProductsBrand(int products_brand_id, String products_brand_content,
			int products_classify_id) {
		this.products_brand_id = products_brand_id;
		this.products_brand_content = products_brand_content;
		this.products_classify_id = products_classify_id;
	}
	
	public int getProducts_brand_id() {
		return products_brand_id;
	}
	public void setProducts_brand_id(int products_brand_id) {
		this.products_brand_id = products_brand_id;
	}
	public String getProducts_brand_content() {
		return products_brand_content;
	}
	public void setProducts_brand_content(String products_brand_content) {
		this.products_brand_content = products_brand_content;
	}
	public int getProducts_classify_id() {
		return products_classify_id;
	}
	public void setProducts_classify_id(int products_classify_id) {
		this.products_classify_id = products_classify_id;
	}
}
