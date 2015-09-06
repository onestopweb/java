package cn.entity;

/*
 * 大图小图表（products_images）
 * */
public class ProductsImages {
	private int products_id;//商品编号
	private String products_smallmap;//大图
	private String products_large;//小图
	
	/*如下是封装方法和构造方法*/
	
	public ProductsImages() {
	}
	
	public ProductsImages(int products_id, String products_smallmap,
			String products_large) {
		this.products_id = products_id;
		this.products_smallmap = products_smallmap;
		this.products_large = products_large;
	}
	
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public String getProducts_smallmap() {
		return products_smallmap;
	}
	public void setProducts_smallmap(String products_smallmap) {
		this.products_smallmap = products_smallmap;
	}
	public String getProducts_large() {
		return products_large;
	}
	public void setProducts_large(String products_large) {
		this.products_large = products_large;
	}
}
