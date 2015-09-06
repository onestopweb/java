package cn.client.dao;

import cn.entity.NeUser;

/*
 * 用户表 DAO 接口
 * */
public interface NeUserDao {
	//登陆方法
	public int login(String username,String password);

	//注册方法
	public int register(String username,String password);

	//ajaxUser验证
	public int ajaxUser(String username);

	//根据用户ID获得对应的用户资料
	public NeUser select(String username);
	
	//修改用户资料
	public int update(String ne_username, String ne_tel, String ne_phone, String ne_email, String ne_postalcode, 
			String ne_save,String ne_city, String ne_borough, String ne_address, String ne_user_id);
	
}
