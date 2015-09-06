package cn.service.dao;

import java.util.List;

import cn.entity.NeUser;

/*
 * 用户表 DAO 接口
 * */
public interface NeUserDao {

	//后台登陆方法
	public int loginOfAdmin(String inputAdmin,String inputPass);

	//用户列表分页
	public List<NeUser> getNeUserByPage(int pageIndex, 
			int pageSize, int levelId,String userId );

	//获取数量
	public int getNeUserByCount(int levelId,String userId);

	//注销
	public int logoutUser(String logout);

	//查找用用户数据
	public NeUser select(String userId);

	//根据用户ID修改用户数据
	public int update(String username,String tel, String phone, String email, 
			String postalcode,String save, String city,String borough,String address,String updateName);

	//插入一条用户数据
	public int insert(String userId, String password, String username, String phone, int levelId);

	//ajaxUser验证
	public int ajaxUser(String userId);

}
