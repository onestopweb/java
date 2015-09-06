package cn.client.dao;

import java.util.List;

import cn.entity.NeOrderSon;

/*
 * 订单子表 DAO 接口
 * */
public interface NeOrderSonDao {
	
	//插入订单号，商品id,和金钱和数量 
	public int insertOrderSon(String orderFatherId,  int id , double money, int number);
	
	//根据订单号获得列表
	public List<NeOrderSon> neOrderSonList(String orderFatherId);
}
