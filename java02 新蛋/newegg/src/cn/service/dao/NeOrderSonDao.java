package cn.service.dao;

import java.util.List;

import cn.entity.NeOrderSon;

/*
 * 订单子表 DAO 接口
 * */
public interface NeOrderSonDao {
	//根据订单号获得列表
	public List<NeOrderSon> neOrderSonList(String orderFatherId);
}
