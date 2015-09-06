package cn.entity;

/*
 * 商品内容表（products_content）
 * */
public class ProductsContent {
	private int products_id;//商品编号
	private String products_content;//商品内容
	
	/*如下是封装方法和构造方法*/
	
	public ProductsContent() {
	}
	
	public ProductsContent(int products_id, String products_content) {
		this.products_id = products_id;
		this.products_content = products_content;
	}
	
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public String getProducts_content() {
		return products_content;
	}
	public void setProducts_content(String products_content) {
		this.products_content = products_content;
	}
}
