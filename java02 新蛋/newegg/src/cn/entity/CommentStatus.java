package cn.entity;

/*
 * 评论状态表（comment_status）
 * */
public class CommentStatus {
	private int comment_status_id;//状态编号
	private String comment_status_content;//状态名称
	
	/*如下是封装方法和构造方法*/
	
	public CommentStatus() {
	}
	
	public CommentStatus(int comment_status_id, String comment_status_content) {
		this.comment_status_id = comment_status_id;
		this.comment_status_content = comment_status_content;
	}
	
	public int getComment_status_id() {
		return comment_status_id;
	}
	public void setComment_status_id(int comment_status_id) {
		this.comment_status_id = comment_status_id;
	}
	public String getComment_status_content() {
		return comment_status_content;
	}
	public void setComment_status_content(String comment_status_content) {
		this.comment_status_content = comment_status_content;
	}
}
