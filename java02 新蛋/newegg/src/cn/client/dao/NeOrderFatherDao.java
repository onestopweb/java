package cn.client.dao;

import java.util.List;

import cn.entity.NeOrderFather;

/*
 * 订单父表 DAO 接口
 * */
public interface NeOrderFatherDao {
	
	//插入新的订单号和用户名
	public int insertOrderFather(String orderFatherId, String username);
	
	//根据用户名来获取总订单数
	public  int getTotalCount(String username);
	
	//根据用户名和状态号来获取订单数
	public  int getTotalCount(String username,int statusId);
	
	//根据设置每页的数目和第几页和用户名来获取列表数据
	public List<NeOrderFather> getNeOrderFatherByPage(int pageIndex, int pageSize,String username);
	
	//修改订单状态,根据订单号，和要修改的状态号
	public int update(String orderFatherId,int statusId);
	
}
