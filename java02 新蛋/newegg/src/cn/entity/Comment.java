package cn.entity;

/* 
 * 评论联表（comment） 
 * */  
public class Comment {
	private int products_id;//商品编号
	private String content;//内容
	private String user_id;//评论人
	private String time;//评论时间
	private int status_id;//评论状态编号
	private String status_content;//评论状态内容
	/*如下是封装方法和构造方法*/
	public Comment() {
	}
	
	public Comment(int products_id, String content, String user_id,
			String time, int status_id, String status_content) {
		this.products_id = products_id;
		this.content = content;
		this.user_id = user_id;
		this.time = time;
		this.status_id = status_id;
		this.status_content = status_content;
	}

	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getStatus_content() {
		return status_content;
	}
	public void setStatus_content(String status_content) {
		this.status_content = status_content;
	}
}
