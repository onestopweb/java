package cn.service.dao;

import java.util.List;

import cn.entity.OrderFatherStatus;

/*
 * 订单主状态表 DAO 接口
 * */
public interface OrderFatherStatusDao {
	
	//订单主状态列表
	public List<OrderFatherStatus> orderFatherStatusList();
	
}
