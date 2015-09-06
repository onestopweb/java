package cn.entity;

/*
 * 评论表（ne_comment）
 * */
public class NeComment {
	private int ne_products_id;//商品编号
	private String ne_content;//内容
	private String ne_user_id;//评论人
	private String ne_time;//评论时间
	private int ne_status_id;//评论状态编号
	
	/*如下是封装方法和构造方法*/
	
	public NeComment() {
	}
	
	public NeComment(int ne_products_id, String ne_content, String ne_user_id,
			String ne_time, int ne_status_id) {
		this.ne_products_id = ne_products_id;
		this.ne_content = ne_content;
		this.ne_user_id = ne_user_id;
		this.ne_time = ne_time;
		this.ne_status_id = ne_status_id;
	}
	
	public int getNe_products_id() {
		return ne_products_id;
	}
	public void setNe_products_id(int ne_products_id) {
		this.ne_products_id = ne_products_id;
	}
	public String getNe_content() {
		return ne_content;
	}
	public void setNe_content(String ne_content) {
		this.ne_content = ne_content;
	}
	public String getNe_user_id() {
		return ne_user_id;
	}
	public void setNe_user_id(String ne_user_id) {
		this.ne_user_id = ne_user_id;
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
}
