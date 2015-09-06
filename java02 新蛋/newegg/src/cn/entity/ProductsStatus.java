package cn.entity;

/*
 * 商品状态表（products_status）
 * */
public class ProductsStatus {
	private int products_status_id;//状态编号
	private String products_status_content;//状态名称
	private String products_status_img;//状态图片
	
	/*如下是封装方法和构造方法*/
	
	public ProductsStatus() {
	}
	public ProductsStatus(int products_status_id,
			String products_status_content, String products_status_img) {
		this.products_status_id = products_status_id;
		this.products_status_content = products_status_content;
		this.products_status_img = products_status_img;
	}

	public int getProducts_status_id() {
		return products_status_id;
	}
	public void setProducts_status_id(int products_status_id) {
		this.products_status_id = products_status_id;
	}
	public String getProducts_status_content() {
		return products_status_content;
	}
	public void setProducts_status_content(String products_status_content) {
		this.products_status_content = products_status_content;
	}
	public String getProducts_status_img() {
		return products_status_img;
	}
	public void setProducts_status_img(String products_status_img) {
		this.products_status_img = products_status_img;
	}
}
