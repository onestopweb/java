package cn.entity;

/* 
 * 用户联表（user） 
 * */  
public class User {
	private String user_id;//用户编号
	private String password;//密码
	private String username;//用户姓名
	private String tel;//电话
	private String phone;//手机
	private String email;//电子邮箱
	private String postalcode;//邮政编号
	private String save;//省
	private String city;//市
	private String borough;//区
	private String address;//其它地址
	private int level_id;//用户级别编号
	private String leve_content;//级别内容

	/*如下是封装方法和构造方法*/
	public User() {
	}
	public User(String user_id, String password, String username, String tel,
			String phone, String email, String postalcode, String save,
			String city, String borough, String address, int level_id,
			String leve_content) {
		this.user_id = user_id;
		this.password = password;
		this.username = username;
		this.tel = tel;
		this.phone = phone;
		this.email = email;
		this.postalcode = postalcode;
		this.save = save;
		this.city = city;
		this.borough = borough;
		this.address = address;
		this.level_id = level_id;
		this.leve_content = leve_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getSave() {
		return save;
	}
	public void setSave(String save) {
		this.save = save;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBorough() {
		return borough;
	}
	public void setBorough(String borough) {
		this.borough = borough;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public String getLeve_content() {
		return leve_content;
	}
	public void setLeve_content(String leve_content) {
		this.leve_content = leve_content;
	}
	
	
}
