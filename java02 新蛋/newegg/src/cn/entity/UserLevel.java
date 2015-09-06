package cn.entity;

/*
 * 用户级别表(user_level)
 * */
public class UserLevel {
	private int user_leve_id;//级别编号
	private String user_leve_content;//级别内容
	
	/*如下是封装方法和构造方法*/
	
	public UserLevel() {
	}
	
	public UserLevel(int user_leve_id, String user_leve_content) {
		this.user_leve_id = user_leve_id;
		this.user_leve_content = user_leve_content;
	}
	
	public int getUser_leve_id() {
		return user_leve_id;
	}
	public void setUser_leve_id(int user_leve_id) {
		this.user_leve_id = user_leve_id;
	}
	public String getUser_leve_content() {
		return user_leve_content;
	}
	public void setUser_leve_content(String user_leve_content) {
		this.user_leve_content = user_leve_content;
	}
}
