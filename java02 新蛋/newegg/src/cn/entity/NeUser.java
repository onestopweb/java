package cn.entity;

/*
 * 用户表（ne_user）
 * */
public class NeUser {
	private String ne_user_id;//用户编号
	private String ne_password;//密码
	private String ne_username;//用户姓名
	private String ne_tel;//电话
	private String ne_phone;//手机
	private String ne_email;//电子邮箱
	private String ne_postalcode;//邮政编号
	private String ne_save;//省
	private String ne_city;//市
	private String ne_borough;//区
	private String ne_address;//其它地址
	private int ne_level_id;//用户级别编号
	
	/*如下是封装方法和构造方法*/
	
	public NeUser() {
	}
	
	public NeUser(String ne_user_id, String ne_password, String ne_username,
			String ne_tel, String ne_phone, String ne_email,
			String ne_postalcode, String ne_save, String ne_city,
			String ne_borough, String ne_address, int ne_level_id) {
		this.ne_user_id = ne_user_id;
		this.ne_password = ne_password;
		this.ne_username = ne_username;
		this.ne_tel = ne_tel;
		this.ne_phone = ne_phone;
		this.ne_email = ne_email;
		this.ne_postalcode = ne_postalcode;
		this.ne_save = ne_save;
		this.ne_city = ne_city;
		this.ne_borough = ne_borough;
		this.ne_address = ne_address;
		this.ne_level_id = ne_level_id;
	}
	
	public String getNe_user_id() {
		return ne_user_id;
	}
	public void setNe_user_id(String ne_user_id) {
		this.ne_user_id = ne_user_id;
	}
	public String getNe_password() {
		return ne_password;
	}
	public void setNe_password(String ne_password) {
		this.ne_password = ne_password;
	}
	public String getNe_username() {
		return ne_username;
	}
	public void setNe_username(String ne_username) {
		this.ne_username = ne_username;
	}
	public String getNe_tel() {
		return ne_tel;
	}
	public void setNe_tel(String ne_tel) {
		this.ne_tel = ne_tel;
	}
	public String getNe_phone() {
		return ne_phone;
	}
	public void setNe_phone(String ne_phone) {
		this.ne_phone = ne_phone;
	}
	public String getNe_email() {
		return ne_email;
	}
	public void setNe_email(String ne_email) {
		this.ne_email = ne_email;
	}
	public String getNe_postalcode() {
		return ne_postalcode;
	}
	public void setNe_postalcode(String ne_postalcode) {
		this.ne_postalcode = ne_postalcode;
	}
	public String getNe_save() {
		return ne_save;
	}
	public void setNe_save(String ne_save) {
		this.ne_save = ne_save;
	}
	public String getNe_city() {
		return ne_city;
	}
	public void setNe_city(String ne_city) {
		this.ne_city = ne_city;
	}
	public String getNe_borough() {
		return ne_borough;
	}
	public void setNe_borough(String ne_borough) {
		this.ne_borough = ne_borough;
	}
	public String getNe_address() {
		return ne_address;
	}
	public void setNe_address(String ne_address) {
		this.ne_address = ne_address;
	}
	public int getNe_level_id() {
		return ne_level_id;
	}
	public void setNe_level_id(int ne_level_id) {
		this.ne_level_id = ne_level_id;
	}
}
