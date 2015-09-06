package cn.entity;

/*
 * 商品类型表（products_classify）
 * */
public class ProductsClassify {
	private int products_classify_id;//分类编号
	private String products_classify_content;//分类名称
	
	/*如下是封装方法和构造方法*/
	
	public ProductsClassify() {
	}
	
	public ProductsClassify(int products_classify_id,
			String products_classify_content) {
		this.products_classify_id = products_classify_id;
		this.products_classify_content = products_classify_content;
	}
	
	public int getProducts_classify_id() {
		return products_classify_id;
	}
	public void setProducts_classify_id(int products_classify_id) {
		this.products_classify_id = products_classify_id;
	}
	public String getProducts_classify_content() {
		return products_classify_content;
	}
	public void setProducts_classify_content(String products_classify_content) {
		this.products_classify_content = products_classify_content;
	}
}
