package cn.service.dao;

import java.util.List;

import cn.entity.NeOrderFather;

/*
 * 订单父表 DAO 接口
 * */
public interface NeOrderFatherDao {

	//订单列表分页
	public List<NeOrderFather> getNeOrderFatherByPage(int pageIndex, int pageSize,String orderFatherId ,String userId);

	//根据用户名和订单号来获取总订单数
	public  int getTotalCount(String orderFatherId ,String userId);
	
	//修改订单号状态
	public int updaeOrderStatus(String orderFatherId, int statusId);
}
